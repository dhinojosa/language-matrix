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

; The full signature of a method is 
; (defn name doc-string? attr-map? [params*] body)

(defn greeting                                         ; This is the greeting definition
   "Returns a greeting of the form 'Hello, username.'" ; This is the documentation of the method
   [username]                                          ; This is a vector of a arguments for the method
   (str "Hello, " username)                            ; This is the implementation of the method
)

(assert (= (greeting "Jasmine") "Hello, Jasmine"))

; Each method can have alternate calls
(defn greeting2                                        ; This is the greeting definition
  "Returns a greeting of the form 'Hello, username.'"  ; This is the documentation of the method
  ([] (greeting2 "world"))                             ; This is one call, calling without arguments
  ([username] (str "Hello, " username)))               ; This is an alternate call, calling with a username

(assert (= (greeting2 "Bob") "Hello, Bob"))
(assert (= (greeting2) "Hello, world"))

; Each method can variable parameters, varargs in other languages
; The & will bind extra variable to the name provided

(use '[clojure.string :only (join)])                   ; Requires a the join function from the clojure string package
(defn state-info 
   "Format a U.S. State with the name, 
    capital and major cities"
   [statename, capital & major-cities]
   (str "State: " statename "; Capital: " capital 
        "; Major Cities: " (join ", " major-cities)))

(assert (= (state-info "New Mexico", "Santa Fe", "Albuquerque", "Las Cruces", "Taos") 
           "State: New Mexico; Capital: Santa Fe; Major Cities: Albuquerque, Las Cruces, Taos"))
