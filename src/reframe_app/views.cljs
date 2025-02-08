(ns reframe-app.views
  (:require
   [reframe-app.subs :as subs]
   [reframe-app.events :as events]
   [reframe-app.util :refer [<sub]]
   [reframe-app.pages.person.views :as person-view]
   [reframe-app.components :refer [input-field submit]]))

(defn login-panel []
  [:div
   [:h1 "Please login."]
   [:form.flex
    [input-field {:label "Name:" :type "text"
                  :subs [::subs/login-name] :event [::events/set-login-name]}]
    [submit {:text "Login" :event [::events/submit-login]}]]])

(defn content-panel [user]
  [:div
   [:h1 (str "Hello, " (:name user))]
   [:div
    (person-view/person-create)]])

(defn main-panel []
  (let [user (<sub [::subs/user])]
    (if (:name user)
      (content-panel user)
      (login-panel))))
