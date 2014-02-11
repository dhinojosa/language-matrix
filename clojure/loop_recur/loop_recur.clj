; Loops work like get, where the loop establishes bindings
; and a recursion point at the top of the loop
; it then then evaluates all expressions
(def x 
  (loop [result [] x 5]
    (if (zero? x)
      result
       (recur (conj result x) (dec x)))))


(def y 
  (loop [e 5]
    (if (= e 0) 0
      (do 
        (println (str "e: is " e)) ; side-effect
        (recur (- e 1))
      )
    )
  )
)

(assert (= x [5 4 3 2 1]))
