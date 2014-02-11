; Clojure does not have a for loop.  What clojure has like all 
; functional languages is a for comprehension which 
; takes a (binding vector) pair and returns a 
; sequence of expressions

; This simple case is a map
(def a (for [x [1 2 3 4]] (+ x 1)))

(assert (= a [2 3 4 5]))

; This simple case take two collection bindings and add them
; this is almost similar to a nested for loop.

(def b (for [x [1 2 3 4] y [5 6 7 8]] (+ x y)))

(assert (= b [6 7 8 9 7 8 9 10 8 9 10 11 9 10 11 12]))
