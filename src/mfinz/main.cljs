(ns mfinz.main
  (:require [reagent.core :as r]
            [re-frame.core :as re-frame]))

(defn app []
  [:p "Under construction"])

(defn figwheel-rn-root []
  (re-frame/dispatch-sync [:initialize-app])
  (r/as-element [app]))
