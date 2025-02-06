(ns reframe-app.components
  (:require [reframe-app.util :refer [<sub >evt]]))

(defn- ->value [e] (-> e .-target .-value))

(defn- on-change-wrapper [event f element]
  (>evt [event f (->value element)]))

(defn input-field [{:keys [subs event label field type]}]
  (fn []
    (let [current-value (<sub [subs field])]
      [:div
       [:label label]
       [:input {:type type
                :default-value current-value
                :on-change (partial on-change-wrapper event field)}]])))