(ns reframe-app.views
  (:require
   [reframe-app.subs :as subs]
   [reframe-app.router.subs :as router-subs]
   [reframe-app.util :refer [<sub]]
   [reframe-app.router.core :as router]
   [reframe-app.router.views :as router-view]))

(defn x-panel []
  (let [user (<sub [::subs/user])]
    (if (:name user)
      (router-view/router-view user)
      []
      #_(login-panel))))

(defn main-panel []
  (let [active-panel (<sub [::router-subs/active-panel])]
    [:div "this is on every page"
     [:div (router/panels active-panel)]]))