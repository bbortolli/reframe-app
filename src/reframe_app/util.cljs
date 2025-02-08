(ns reframe-app.util
  (:require [re-frame.core :as rf]))

(def <sub (comp deref rf/subscribe))
(def >evt rf/dispatch)

(defn empty-value? [v]
  (or (nil? v)
      (and (string? v) (empty? v))
      (and (sequential? v) (empty? v))
      (and (map? v) (empty? v))))

(defn parse-form [form-data fields-rules]
  (reduce-kv
   (fn [current field {:keys [to-api]}]
     (let [v (field current)]
       (if (empty-value? v)
         (dissoc current field)
         (update current field to-api))))
   form-data fields-rules))

(defn model->form-data [t]
  (reduce-kv (fn [current field d]
               (assoc current field (:value d))) {} t))

(defn fetch-sucess [db response path]
  (update-in db path merge (select-keys [:status :body] response)))

(defn fetch-failure [db response path]
  (update-in db path merge (select-keys [:problem :problem-message] response)))