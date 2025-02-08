(ns reframe-app.router.events
  (:require
   [re-frame.core :as rf]
   [day8.re-frame.tracing :refer-macros [fn-traced]]))

(rf/reg-event-fx
 ::navigate
 (fn-traced [_ [_ handler]]
   {:router-navigate handler}))

(rf/reg-event-db
 ::set-active-panel
 (fn-traced [db [_ panel]]
   (assoc-in db [:router :active-panel] panel)))

(rf/reg-event-db
 ::set-route
 (fn-traced [db [_ route]]
   (assoc-in db [:router :route] route)))