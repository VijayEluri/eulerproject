(defn problem-1 [upper]
  (apply + (distinct (concat (range 3 upper 3) (range 5 upper 5)))))

(println (problem-1 1000))
