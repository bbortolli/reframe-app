(ns reframe-app.pages.person.subs
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::create-form-data
 (fn [db field]
   (get-in db [:person/create :form-data field :value])))

(re-frame/reg-sub
 ::update-form-data
 (fn [db field]
   (get-in db [:person/update :form-data field :value])))
