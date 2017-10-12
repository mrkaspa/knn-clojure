(ns knn.calcs)

(defn euclidean-distance
  [vec1 vec2]
  (->>
    (map #(Math/pow (- %1 %2) 2) vec1 vec2)
    (reduce +)
    (Math/sqrt)))

(defn nearest-neighbors
  [samples query k]
  (->>
    samples
    (map #(assoc % :score (euclidean-distance query (:pos %))))
    (sort-by :score)
    (take k)))

(defn knn
  [samples query k]
  (let [votes (nearest-neighbors samples query k)
        vote-freq (frequencies (map :class votes))]
       (key (apply max-key val vote-freq))))
