; Lists are peculiar in Clojure
; A list can be created much like in other languages, but it must be created using a list function or be quoted

; Creating a list with the `list` function
(def a-list (list 1 2 3 4))

; Creating a list with a quote
(def a-list-prime '(1 2 3 4))

(assert (= a-list a-list-prime))

; If you don't quote it the first element must be a function, 
; macro or java class or a special form


; Typically vectors are used in place of list as a collection, and lists are used to evaluate functions.
