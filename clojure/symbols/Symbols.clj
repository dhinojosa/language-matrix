; Symbols are identifiers
; They evaluate to the values held by var
; Begin with a non-numeric and can contain *, +, !, -, _, and ?
; The slash (/) is reserved to separate namespace
; The period (.) is used to seprate class name `java.util.Set`or namespace\

; `str` is a Symbol
(println (str "One" "Two" "Three" "A" "Clock"))

; creating a method
(defn adder 
  [x y]
  (+ x y))

; adder is now a symbol
(println (adder 3 5))
