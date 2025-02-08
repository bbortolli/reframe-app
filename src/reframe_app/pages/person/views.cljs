(ns reframe-app.pages.person.views
  (:require
   [re-frame.core :as rf]
   [reframe-app.components :refer [input-field input-email input-date]]
   [reframe-app.pages.person.events :as events]
   [reframe-app.pages.person.subs :as subs]))

(defn person-form [{:keys [subs ev form-path]}]
  (let [field (fn [field label]
                {:label label :field field 
                 :event [ev field] :subs [subs field] :type "text"})]
    [:div.flex.flex-col.gap-2
     [:h2 "Cadastro de Pessoa"]
     [input-field  (field :nome "Nome Completo")]
     [input-date   (field :nascimento "Data de Nascimento")]
     [input-field  (field :cpf "CPF")]
     [input-field  (field :sexo "Sexo")]
     [input-email  (field :email "Email")]
     [input-field  (field :telefone "Telefone")]
     [:button {:on-click #(rf/dispatch [::events/submit-form {:form-path form-path}])} "Cadastrar"]]))


(defn person-create []
  (person-form {:ev   ::events/set-create-form-field
                :subs ::subs/create-form-data
                :form-path :create}))

(defn person-update []
  (person-form {:ev   ::events/set-update-form-field
                :subs ::subs/update-form-data
                :form-path :update}))