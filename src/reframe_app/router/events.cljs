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
 (rf/path [:router :active-panel])
 (fn-traced [_ [_ panel]]
   panel))

(rf/reg-event-db
 ::set-route
 (rf/path [:router :route])
 (fn-traced [_ [_ route]]
   route))