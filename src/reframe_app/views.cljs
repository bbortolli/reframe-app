(ns reframe-app.views
  (:require
   [re-frame.core :as re-frame]
   [reframe-app.subs :as subs]
   [reframe-app.pages.person.views :as person-view]))

(defn main-panel []
  (let [name "(re-frame/subscribe [::subs/name])"]
    [:div
     (person-view/person-create)
     [:h1
      "Hello from null"]]))
