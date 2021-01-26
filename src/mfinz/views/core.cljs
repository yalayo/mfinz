(ns mfinz.views.core
  (:require [reagent.core :as r]
            [re-frame.core :as re-frame]
            [mfinz.components.core :as c]))

(defn balance [props]
  [c/safe-area-view {:flex 1}
   [c/view {:flex 0.2}
    [c/text {:style {:font-size 30}} "Activos"]]])
