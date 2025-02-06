(ns reframe-app.pages.person.views
  (:require
   [re-frame.core :as rf]
   [reframe-app.components :as components]
   [reframe-app.pages.person.events :as events]
   [reframe-app.pages.person.subs :as subs]))

(defn person-form [{:keys [subs ev form-path]}]
  (let [field (fn [field label type]
                {:field field :label label :type type
                 :event ev :subs subs})]
    [:div
     [:h2 "Cadastro de Pessoa"]
     [components/input-field (field :nome "Nome Completo:" "text")]
     [components/input-field (field :nascimento "Data de Nascimento:" "date")]
     [components/input-field (field :cpf "CPF:" "text")]
     [components/input-field (field :sexo "Sexo:" "text")]
     [components/input-field (field :email "Email:" "email")]
     [components/input-field (field :telefone "Telefone:" "text")]
     [:button {:on-click #(rf/dispatch [::events/submit-form {:form-path form-path}])} "Cadastrar"]]))


(defn person-create []
  (person-form {:ev   ::events/set-create-form-field
                :subs ::subs/create-form-data
                :form-path :person/create}))

(defn person-update []
  (person-form {:ev   ::events/set-update-form-field
                :subs ::subs/update-form-data
                :form-path :person/update}))