(ns reframe-app.views
  (:require
   [reframe-app.components :refer [input-text link router routes route auth-wrap]]
   [reframe-app.auth.views :as auth-views]
   [reframe-app.auth.subs :as auth-subs]
   [reframe-app.auth.events :as auth-events]
   [reagent.core :as r]))

(defn home-page []
  [:div
   [:h1 "Welcome, please set your username to proceed."]
   [input-text {:subs [::auth-subs] :event [::auth-events] :label "Username:"}]
   [link {:to "/about"} "Go to About"]])

(defn about-page []
  [auth-wrap
   [:div
    [:h1 "About"]
    [link {:to "/"} "Back to Home"]]])

(defn main-panel []
  [router
   [routes
    [route {:path "/" :exact true :element (r/as-element [home-page])}]
    [route {:path "/auth" :element (r/as-element [auth-views/login-page])}]]])