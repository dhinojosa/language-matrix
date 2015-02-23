; Functions are first-class objects. That is, functions can be created at
;   runtime, passed around, returned, and in general used like any other
;   datatype.
; 
; When creating your own functions it is good practice to use 
; Clojure Parameter convention
;
; `a` A Java array
; `agt` An agent
; `coll` A collection
; `expr` An expression
; `f` A function
; `idx` Index
; `r` A ref
; `v` A vector
; `val` A value

;
; This is a function that is created in clojure

(defn average
  [numbers]
    (/ (apply + numbers) (count numbers)))

;To call the function, invoke the symbol `average`

(assert (= (average [1.0 3.0 10.4 11.5]) 6.475))

; A List with a function;
; Having the + in the beginning is prefix notation

(assert (= (+ 1 2 4) 7))

; A function with just an operator will return a default answer
; For (+) it will return 0, and for (*) it will return 1

(assert (= (+) 0))
(assert (= (*) 1))

; A function is a list
(assert (= (str "hello" " " "world") "hello world"))

; If a function is a predicate is will have a question mark (?) at the end
;  of the name
(assert (= (string? "hello") true))
(assert (= (keyword? :hello) true))
(assert (= (symbol? 'hello) true))

; The full signature of a function is 
; (defn name doc-string? attr-map? [params*] body)

(defn greeting                                         ; This is the greeting definition
   "Returns a greeting of the form 'Hello, username.'" ; This is the documentation of the function
   [username]                                          ; This is a vector of a arguments for the function
   (str "Hello, " username)                            ; This is the implementation of the function
)

(assert (= (greeting "Jasmine") "Hello, Jasmine"))

; Each function can have alternate calls
(defn greeting2                                        ; This is the greeting definition
  "Returns a greeting of the form 'Hello, username.'"  ; This is the documentation of the function
  ([] (greeting2 "world"))                             ; This is one call, calling without arguments
  ([username] (str "Hello, " username)))               ; This is an alternate call, calling with a username

(assert (= (greeting2 "Bob") "Hello, Bob"))
(assert (= (greeting2) "Hello, world"))

; Each function can contain variable parameters, called 
; variadic functions. Similar to C++ ellipsis and Java's varargs
; The & will bind extra variable to the name provided

(use '[clojure.string :only (join)]); Requires the join function from the clojure string package
(defn state-info 
   "Format a U.S. State with the name, 
    capital and major cities"
   [statename, capital & major-cities]
   (str "State: " statename "; Capital: " capital 
        "; Major Cities: " (join ", " major-cities)))

(assert (= (state-info "New Mexico", "Santa Fe", "Albuquerque", 
                       "Las Cruces", "Taos") 
           "State: New Mexico; Capital: Santa Fe; Major Cities: Albuquerque, Las Cruces, Taos"))

; whole functions can be called as a higher order function, just accept the 
; function as a parameter
(defn op [f a b] (f a b))

(assert (= (op + 4 2) 6))

; partial takes a function f and fewer than the normal arguments to f, and
; returns a fn that takes a variable number of additional args. When
; called, the returned function calls f with args + additional args.

(defn add3 [a b c] (+ a b c))

(def add-last (partial add3 1 2))

(assert (= (add-last 3) 6))
