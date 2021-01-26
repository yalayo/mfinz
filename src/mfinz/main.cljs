(ns mfinz.main
  (:require [reagent.core :as r]
            [re-frame.core :as re-frame]
            [mfinz.views.core :as v]))

(defn app []
  [v/balance])

(defn figwheel-rn-root []
  ;(re-frame/dispatch-sync [:initialize-app])
  (r/as-element [app]))
