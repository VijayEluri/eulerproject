(defn odd [] 
  (iterate #(+ % 2) 3))

(defn possible-factors[n]
  (cons 2 (take-while #(<= % (Math/sqrt n)) (odd))))

(defn problem-3 [n]
  (loop [n n factors (possible-factors n)]
    (let [factor (first factors)]
      (if factor
        (if (> n 1)
          (if (zero? (rem n factor))
            (recur (/ n factor) factors)
            (recur n (rest factors)))
          factor)
        n))))

(println (problem-3 600851475143))
