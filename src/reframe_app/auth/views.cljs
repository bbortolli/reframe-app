(ns reframe-app.auth.views
  (:require
   [reframe-app.components :refer [input-field submit]]
   [reframe-app.pages.auth.events :as events]
   [reframe-app.pages.auth.subs :as subs]
   [reframe-app.router.core :as router]))

(defn login-panel []
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

(defmethod router/panels :auth-login [] 
  (login-panel))