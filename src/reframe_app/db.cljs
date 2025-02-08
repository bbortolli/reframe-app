(ns reframe-app.db
  (:require
   [reframe-app.auth.db :refer [auth-db]]
   [reframe-app.router.db :refer [router-db]]
   [reframe-app.pages.person.db :refer [person-db]]))

(def default-db
  {:auth   auth-db
   :person person-db
   :router router-db})
