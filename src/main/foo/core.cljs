(ns foo.core
  (:require [reagent.core :as r]
            [reagent.dom :as rdom]))

;; STATE

(defonce state (r/atom 0))

;; COMPONENTS

(defn counter []
  [:p "Counter: " @state])

(defn button-inc []
  [:input {:type "button"
           :value "plus one"
           :on-click (fn [_event]
                       (swap! state inc))}])

(defn button-reset []
  [:input {:type "button"
           :value "reset"
           :on-click (fn [_event]
                       (reset! state 0))}])

(defn container []
  [:div
   [counter]
   [button-inc]
   [button-reset]])

;; RENDER

(defn root []
  (.getElementById js/document "app"))

(defn ^:export init []
  (rdom/render [container] (root)))
