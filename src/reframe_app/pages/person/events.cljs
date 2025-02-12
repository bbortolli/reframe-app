(ns reframe-app.pages.person.events
  (:require
   [re-frame.core :as re-frame]
   [superstructor.re-frame.fetch-fx]
   [reframe-app.util :as util]
   [reframe-app.pages.person.db :as db]
   [day8.re-frame.tracing :refer-macros [fn-traced]]))

(re-frame/reg-event-db
 ::set-create-form-field
 (fn-traced [db [_ field value]]
   (assoc-in db [:person :create :form-data field] value)))

(re-frame/reg-event-db
 ::set-update-form-field
 (fn-traced [db [_ field value]]
   (assoc-in db [:person :update :form-data field] value)))

(re-frame/reg-event-fx
 ::submit-form
 (fn-traced [{:keys [db]} [_ {:keys [form-path]}]]
   (let [form-data     (-> db form-path :form-data)
         api-data      (util/parse-form form-data (db/->person))
         fake-response {:status 200 :body []}]
     (prn "Api data:" api-data)
     {:db db
      :fx [[:dispatch-later {:ms 600 :dispatch [::submit-form-success type fake-response]}]]})))

(re-frame/reg-event-db
 ::submit-form-success
 (fn-traced [db type response]
   (util/fetch-sucess db response [:person type :submit-form])))

#_(re-frame/reg-event-db
 ::submit-form-failure
 (fn-traced [db type response]
   (util/fetch-failure db response [:person type :submit-form])))