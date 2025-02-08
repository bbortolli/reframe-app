(ns reframe-app.events
  (:require
   [re-frame.core :as rf]
   [reframe-app.db :as db]
   [day8.re-frame.tracing :refer-macros [fn-traced]]))

(rf/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))

(rf/reg-event-db
 ::set-login-name
 (fn-traced [db [_ value]]
   (assoc db :login/name value)))

(rf/reg-event-db
 ::submit-login
 (fn-traced [db _]
   (assoc db :user {:name (:login/name db)})))
