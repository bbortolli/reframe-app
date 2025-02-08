(ns reframe-app.router.events
  (:require
   [re-frame.core :as rf]
   [day8.re-frame.tracing :refer-macros [fn-traced]]))

(rf/reg-event-fx
 ::navigate
 (fn-traced [_ [_ handler]]
   {:navigate handler}))

(rf/reg-event-fx
 ::set-active-panel
 (fn-traced [{:keys [db]} [_ active-panel]]
   (assoc db :active-panel active-panel)))

(rf/reg-event-fx
 ::set-route
 (fn-traced [{:keys [db]} [_ route]]
   (assoc db :route route)))