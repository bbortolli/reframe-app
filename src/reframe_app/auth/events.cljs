(ns reframe-app.auth.events
  (:require
   [re-frame.core :as re-frame]
   [superstructor.re-frame.fetch-fx]
   [day8.re-frame.tracing :refer-macros [fn-traced]]))

(re-frame/reg-event-db
 ::set-form-field
 (fn-traced [db [_ field value]]
   (assoc-in db [:auth :form-data field] value)))