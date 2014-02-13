; Loops work like `let`, where the loop establishes bindings
; and a recursion point at the top of the loop
; it then then evaluates all expressions
; recur will then return to the loop that precedes it.

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

(assert (= y 0))

; Recur can also be used with a `defn` where recur will return to the
; `defn` declaration. Note that the `defn` receives a vector of 
; parameters whereas loop contains a vector of bindings

(defn my-reduce [total v]
  (if (= (count v) 0) total
      (recur (+ total (first v)) (rest v))
  )
)
(assert (= 15 (my-reduce 0 [1 2 3 4 5])))
