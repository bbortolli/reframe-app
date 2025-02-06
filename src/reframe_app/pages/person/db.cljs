(ns reframe-app.pages.person.db
  (:require [reframe-app.util :as util]))

(defn apenas-numeros [s]
  (apply str (re-seq #"\d+" s)))

(defn ->person []
  (hash-map
   :cpf        {:value "" :to-api apenas-numeros}
   :email      {:value "" :to-api str}
   :nascimento {:value "" :to-api str}
   :nome       {:value "" :to-api str}
   :sexo       {:value "" :to-api str}
   :telefone   {:value "" :to-api apenas-numeros}))

(defn person-form-db []
  (hash-map 
   :submit-form {:status nil :problem nil :message nil :body nil}
   :form-data   (util/model->form-data (->person))))


(def person-db
  {:person/create (person-form-db)
   :person/update (person-form-db)})