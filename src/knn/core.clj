(ns knn.core
  (:require [knn.calcs])
  (:gen-class))

(def training-set
  [{:pos [2  0] :class "OSX"}
   {:pos [1  3] :class "Windows"}
   {:pos [-1  0] :class "Unix"}
   {:pos [-9  1] :class "Unix"}
   {:pos [8 -8] :class "OSX"}
   {:pos [4  1] :class "OSX"}
   {:pos [0  0] :class "OSX"}
   {:pos [4  2] :class "Unix"}
   {:pos [2 -3] :class "OSX"}
   {:pos [8 -3] :class "OSX"}])

(defn -main
  [& args]
  (let [query [4 2]
        k 4]
    (println query "-" (knn.calcs/knn training-set query k))))
