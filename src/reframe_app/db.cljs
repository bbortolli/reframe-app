(ns reframe-app.db
  (:require [reframe-app.pages.person.db :refer [person-db]]))

(def default-db
  (merge
   {:login/name ""
    :user nil}
   person-db))
