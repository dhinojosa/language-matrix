;This is a function that is created in clojure
(defn average
  [numbers]
    (/ (apply + numbers) (count numbers)))

;To call the function, invoke the symbol `average`
(println (average [1.0 3.0 10.4 11.5]))
