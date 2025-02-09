(ns reframe-app.storage
  (:require
   [re-frame.core :as rf]))

(defn get-item!
  "Get item from localStorage and returns it. Accepts keywords."
  [key]
  (let [value
        (->> (name key)
             (.getItem js/localStorage)
             (.parse js/JSON))]
    (js->clj value :keywordize-keys true)))

(defn set-item!
  "Set item in localStorage and returns the value provided in argument.
   Accepts keywords and EDN."
  [key value]
  (->> (clj->js value)
       (.stringify js/JSON)
       (.setItem js/localStorage (name key)))
  value)

(rf/reg-fx
 :storage/set-item
 (fn [[key value]]
   (set-item! key value)))