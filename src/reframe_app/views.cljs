(ns reframe-app.views
  (:require
   [reframe-app.components :refer [submit link router routes route]]
   [reframe-app.router.subs :as router-subs]
   [reframe-app.util :refer [<sub]]
   [reagent.core :as r]
   [reframe-app.router.core :as router]
   [reframe-app.auth.events :as auth-events]
   [reframe-app.auth.subs :as auth-subs]))

(defmethod router/panels :home-panel []
  [:div
   [:h1 "Welcome! You are at home panel :)"]
   [submit {:text "Set user" :event [::auth-events/set-auth-user {:name "test_99"}]}]
   #_[nav-to {:text "Go to secret!" :to [:secret]}]])

(defmethod router/panels :secret-panel []
  [:div
   [:h1 "OOOOOOOOOMMMMMMMMMMGGGGG"]])

(defn home-page []
  [:div
   [:h1 "Home"]
   [link {:to "/about"} "Go to About"]])

(defn about-page []
  [:div
   [:h1 "About"]
   [link {:to "/"} "Back to Home"]])

(defn main-panel []
  [router
   [routes
    [route {:path "/" :exact true :element (r/as-element [home-page])}]
    [route {:path "/about" :element (r/as-element [about-page])}]]]
  #_(let [active-panel (<sub [::router-subs/active-panel])
        current-user (<sub [::auth-subs/user])]
    [:div (str "this is on every page, panel => " active-panel)
     [:div (str "this is from storage => " (:name current-user))
      [:div (router/panels active-panel)]]]))