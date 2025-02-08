(ns reframe-app.views
  (:require
   [reframe-app.components :refer [nav-to]]
   [reframe-app.router.subs :as router-subs]
   [reframe-app.util :refer [<sub]]
   [reframe-app.router.core :as router]))

(defmethod router/panels :home-panel []
  [:div
   [:h1 "Welcome! You are at home panel :)"]
   [nav-to {:text "Go to secret!" :to [:secret]}]])

(defmethod router/panels :secret-panel []
  [:div
   [:h1 "OOOOOOOOOMMMMMMMMMMGGGGG"]])

(defn main-panel []
  (let [active-panel (<sub [::router-subs/active-panel])]
    [:div (str "this is on every page, panel => " active-panel)
     [:div (router/panels active-panel)]]))