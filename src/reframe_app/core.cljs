(ns reframe-app.core
  (:require
   [reagent.dom :as rdom]
   [re-frame.core :as re-frame]
   [reframe-app.events :as events]
   [reframe-app.views :as views]
   [reframe-app.config :as config]))


(defn dev-setup []
  (when config/debug?
    (println "dev mode")))

(defn ^:dev/after-load mount-root []
  (re-frame/clear-subscription-cache!)
  (let [root-el (.getElementById js/document "app")]
    (rdom/unmount-component-at-node root-el)
    (rdom/render [views/main-panel] root-el)))

(defn init []
  (re-frame/dispatch-sync [::events/initialize-db])
  (re-frame/dispatch-sync [::events/load-local-storage])
  (dev-setup)
  (mount-root))
