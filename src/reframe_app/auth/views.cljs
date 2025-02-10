(ns reframe-app.auth.views
  (:require
   [reframe-app.components :refer [input-field submit]]
   [reframe-app.auth.events :as events]
   [reframe-app.auth.subs :as subs]))

(defn login-page []
  [:div
   [:h1 "Please login."]
   [:form.flex
    [input-field {:label "Email" :type "text"
                  :subs [::subs/form-data :email] 
                  :event [::events/set-form-field :email]}]
    [input-field {:label "Password:" :type "password"
                  :subs [::subs/form-data :password] 
                  :event [::events/set-form-field :password]}]
    [submit {:text "Login" :event [::events/submit-login]}]]])