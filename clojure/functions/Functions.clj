; Functions are first-class objects. That is, functions can be created at
;   runtime, passed around, returned, and in general used like any other
;   datatype.
; Data is immutable.
; Functions are pure; that is, they have no side effects.

; This is a function that is created in clojure

(defn average
  [numbers]
    (/ (apply + numbers) (count numbers)))

;To call the function, invoke the symbol `average`

(println (average [1.0 3.0 10.4 11.5]))

; A List with a function;
; Having the + in the beginning is prefix notation

(println (+ 1 2 4))

; A function with just an operator will return a default answer
; For (+) it will return 0, and for (*) it will return 1

(println (+))
(println (*))
