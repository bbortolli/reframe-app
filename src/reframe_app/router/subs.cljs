(ns reframe-app.router.subs
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::active-panel
 (fn [db _]
   (:route/panel db)))

(re-frame/reg-sub
 ::route-params
 (fn [db _]
   (get-in db [:route/route :params])))