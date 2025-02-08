(ns reframe-app.router.core
  (:require [bidi.bidi :as bidi]
            [pushy.core :as pushy]
            [re-frame.core :as rf]
            [reframe-app.router.events :as events]))

(defmulti panels identity)
(defmethod panels :default [] [:h1 "Page not found."])

(def routes
  (atom
   ["/" {""      :home
         "auth"  :auth
         "about" :about
         "users" {"" :users-index
                  ["/" :id] :user-view}}]))

(defn parse [url]
  (bidi/match-route @routes url))

(parse "/auth")

(defn url-for [& args]
  (apply bidi/path-for (into [@routes] args)))

(defn dispatch [route]
  (let [panel (keyword (str (name (:handler route)) "-panel"))]
    (rf/dispatch [::events/set-route {:route route :panel panel}])))

(defonce history
  (pushy/pushy dispatch parse))

(defn navigate!
  [handler]
  (pushy/set-token! history (apply url-for handler)))

(defn start!
  []
  (pushy/start! history))

(rf/reg-fx
 ::navigate
 (fn [handler]
   (navigate! handler)))