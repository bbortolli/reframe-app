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

(defn- assoc-items! [acc key]
  (assoc acc key (get-item! key)))

(defn get-items!
  "Get items from localStorage and returns it. Accepts a vector of keywords."
  [keys]
  (reduce assoc-items! {} keys))

(defn set-item!
  "Set item in localStorage and returns the value provided in argument.
   Accepts keywords and EDN."
  [key value]
  (->> (clj->js value)
       (.stringify js/JSON)
       (.setItem js/localStorage (name key)))
  value)

(defn set-items!
  "Set items in localStorage and returns the value provided in argument.
   Accepts a map of keywords and EDN."
  [objects]
  (mapv (fn [[key value]] (set-item! key value)) objects)
  objects)

(defn remove-item!
  "Remove item from localStorage and returns the value which was stored inside.
   Accepts keywords."
  [key]
  (let [value (get-item! key)]
    (->> (name key)
         (.removeItem js/localStorage))
    value))

(defn remove-items!
  "Remove items from localStorage and returns the values which was stored inside.
   Accepts a vector of keywords."
  [keys]
  (reduce (fn [acc key] (assoc acc key (remove-item! key))) {} keys))

(rf/reg-fx
 :storage/set-item
 (fn [[key value]]
   (set-item! key value)))