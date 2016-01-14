;; A higher order function is a function that takes another function.
;; In this example we have a function op that takes a function f.
;; Notice that the f is taken from the vector argument list and used as an 
;; the first element of the list since it is a function that is be evaluated.

(defn op [f x y] (f x y))

;; A declared function
(defn prod2 [x y] (* x y))

;; Using an anonymous function, see anonymous_functions/anonymous_functions.clj
(assert (= (op (fn [x y] (+ x y 1)) 4 5) 10))

;; Shorthand for an anonymous function
(assert (= (op #(+ %1 %2 1) 4 5) 10))

;; Even shorter hand of anonymous function, where as the % is the first parameter
(assert (= (op #(+ % %2 1) 4 5) 10))

;; Using the prod2 function as the higher order function
(assert (= (op prod2 4 5) 20))
