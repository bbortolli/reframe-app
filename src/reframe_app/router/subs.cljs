(ns reframe-app.router.subs
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::active-panel
 (fn [db _]
   (-> db :router :active-panel)))

(re-frame/reg-sub
 ::route-params
 (fn [db _]
   (-> db :router :route :params)))