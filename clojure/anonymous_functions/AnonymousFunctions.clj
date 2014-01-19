; Anonymous functions are used in case you do not wish to come up with a name
; for a method since if it is being used in a small context.

; Anonymous functions are defined using the symbol fn
(assert (= (map (fn [i] (* i 2)) [1 2 3 4 5]))
           [2 4 5 8 10])

; A shorter anonymous syntax is to use %1 %2 etc. for parameters
(assert (= (map #(* %1 2) [1 2 3 4 5]))
           [2 4 6 8 10])

; You can also use % for the first parameter
(assert (= (map #(* % 2) [1 2 3 4 5]))
           [2 4 6 8 10])

; Here is using the reduce method with two parameters
;
; Reduce applies the function to each element and accumulates
; the results
(assert (= (reduce #(+ %1 %2) 0 [1 2 3 4 5]))
           15)

; Here again is using the reduce method with two parameters, 
; but % is used for the first parameter
(assert (= (reduce #(+ % %2) 0 [1 2 3 4 5]))
           15)

