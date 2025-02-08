(ns reframe-app.components
  (:require [reframe-app.util :refer [<sub >evt]]
            [clojure.string :as st]
            [re-frame.core :as rf]))

(defn- ->value [e] (-> e .-target .-value))

(defn- on-change-wrapper [event element]
  (>evt (conj event (->value element))))

(defn- base-input [{:keys [subs event label type class]}]
  (let [current-value (<sub subs)]
    [:div
     [:label label]
     [:input {:class (st/trim (str "border-1 rounded " class))
              :type type
              :default-value current-value
              :on-change (partial on-change-wrapper event)}]]))

(defn input-field [{:keys [subs event label type class]
                    :or   {type "text" class ""}}]
  (fn []
    (let [current-value (<sub subs)]
      [:div
       [:label label]
       [:input {:class (st/trim (str "border-1 rounded " class))
                :type type
                :default-value current-value
                :on-change (partial on-change-wrapper event)}]])))

(defn input-text [params]
  (fn [] (base-input (assoc params :type "text"))))

(defn input-email [params]
  (fn [] (base-input (assoc params :type "email"))))

(defn input-date [params]
  (fn [] (base-input (assoc params :type "date"))))

(defn submit-wrapper [rf-event ev]
  (.preventDefault ev)
  (rf/dispatch rf-event))

(defn submit [{:keys [text event]
               :or   {text "Submit"}}]
  (fn []
    [:button {:on-click (partial submit-wrapper event)} text]))