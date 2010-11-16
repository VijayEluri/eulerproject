(defn fibo []
  (map first (iterate (fn [[a b]] [b (+ a b)]) [0 1])))

(defn problem-2 [upper]
  (apply + (filter #(even? %) (take-while #(< % upper) (fibo)))))

(println (problem-2 4000000))
