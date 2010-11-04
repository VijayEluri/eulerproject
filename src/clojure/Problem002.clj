(defn problem-2 [upper]
  (loop [sum 0 prev 1 n 2]
    (if (<= n upper)
      (recur (if (zero? (rem n 2)) (+ sum n) sum) 
             n
             (+ prev n))
      sum)))

(println (problem-2 4000000))
