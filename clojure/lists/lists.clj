; Lists are peculiar in Clojure
; A list can be created much like in other languages, but it must be created using a list function or be quoted

; Creating a list with the `list` function
(def a-list (list 1 2 3 4))

; Creating a list with a quote
(def a-list-prime '(1 2 3 4))

(assert (= a-list a-list-prime))

; If you don't quote it the first element must be a function, 
; macro or java class or a special form. In the following example,
; the `=` and `+` are functions.

(assert (= (+ 1 2 3 4) 10))

; Typically lists are used in place of list as a collection, and lists are used to evaluate functions

; A list is a collection and therefore is subject to all sequenceable functions

(def states '("Ohio" "Michigan" "Illinois" "Indiana"))

;`conj` adds an element or elements to a list in front of the collection

(def conj-states (conj states "Kentucky"))
(assert (= (last conj-states) "Indiana"))
(assert (= (first conj-states) "Kentucky"))

; `conj` can also add other items as well and added to the end of the collection

(assert (= (first (conj states "Kentucky" "Alabama" "Oregon" "Nevada")) "Nevada"))

; `into` adds one collection into another. In the case of a list, it will apply it at the end

(assert (= (first (into states '("Arizona", "Utah", "Tennessee", "North Dakota"))) "North Dakota"))

; `into` can add any collection, what matters is the source, in this case a list 
; In the following; adding a vector into a list

(assert (= (first (into states ["Arizona", "Utah", "Tennessee", "North Dakota"])) "North Dakota"))
