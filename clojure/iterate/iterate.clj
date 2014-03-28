; infinite lazy streams in clojure are implemented using iterate,
; merely calling (iterate f x) will go on forever and usually needs 
; another function to grab a handful of items, like the function, `take`

(assert (= (take 5 (iterate #(+ % 2) 4)) '(4 6 8 10 12)))
