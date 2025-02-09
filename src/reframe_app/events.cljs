(ns reframe-app.events
  (:require
   [re-frame.core :as rf]
   [reframe-app.db :as db]
   [reframe-app.storage :as storage]
   [day8.re-frame.tracing :refer-macros [fn-traced]]))

(defn- retrieve-local-storage [db]
  (let [name (storage/get-item! :user)]
    (prn "retrieve-local-storage !")
    (prn "db " db)
    (prn "name " name)
    (cond-> db
      name (assoc-in [:auth :user :name] name))))

(rf/reg-event-db
 ::initialize-db
 (fn-traced [_ _]
   (-> db/default-db
       retrieve-local-storage)))