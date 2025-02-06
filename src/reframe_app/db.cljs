(ns reframe-app.db
  (:require [reframe-app.pages.person.db :refer [person-db]]))

(def default-db
  (merge {}
         {:person person-db}))
