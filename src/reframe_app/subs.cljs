(ns reframe-app.subs
  (:require
   [re-frame.core :as rf]))

(rf/reg-sub
 ::login-name
 (fn [db _]
   (:login/name db)))

(rf/reg-sub
 ::user
 (fn [db _]
   (:user db)))
