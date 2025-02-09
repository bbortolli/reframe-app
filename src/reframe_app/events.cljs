(ns reframe-app.events
  (:require
   [re-frame.core :as rf]
   [reframe-app.db :as db]
   [reframe-app.storage :as storage]
   [day8.re-frame.tracing :refer-macros [fn-traced]]))

(defn- store->db [db local-store ks]
  (reduce-kv (fn [curr k v]
               (assoc-in curr v  (k local-store))) 
             db ks))

(rf/reg-event-db
 ::initialize-db
 (fn-traced [_ _]
   db/default-db))

(defn local-store-items
  "Define keys to retrieve from local-storage and path to db"
  []
  {:user [:auth :user]})

(rf/reg-cofx
 :local-store
 (fn-traced [coeffects ks]
   (assoc coeffects :local-store (storage/get-items! ks))))

(rf/reg-event-fx
 ::load-local-storage
 [(rf/inject-cofx :local-store (keys (local-store-items)))]
 (fn-traced [{:keys [db local-store]} _]
   {:db (store->db db local-store (local-store-items))}))