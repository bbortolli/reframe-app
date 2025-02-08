(ns reframe-app.auth.subs
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::form-data
 (fn [db _]
   (-> db :auth :form-data)))

(re-frame/reg-sub
 ::user
 (fn [db _]
   (-> db :auth :user)))