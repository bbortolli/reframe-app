(ns reframe-app.router.views
  (:require
   [reframe-app.util :refer [<sub]]
   [reframe-app.pages.person.views :as person-view]
   [reframe-app.router.subs :as subs]))

(defn content-panel [data & slot]
  [:div
   [:h1 (str "Hello, " (-> data :user :name))]
   [:div slot]])

(defmulti router-select :name)

(defmethod router-select :default [_]
  [])

(defmethod router-select :person-create [_]
  (content-panel (person-view/person-create)))

(defmethod router-select :person-update [_]
  (content-panel (person-view/person-update)))

(defn router-view [user]
  (let [active (<sub [::subs/active-router])]
    (router-select {:name active :user user})))