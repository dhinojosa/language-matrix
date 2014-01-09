; Clojure is defined in terms of the evaluation of data structures 
; and not in terms of the syntax of character streams/files.

; It is quite common, and easy, for Clojure programs to manipulate,
; transform and produce other Clojure programs.
; Source: clojure.org/reader

; The reader is used to parse text and produce the data
; structure the compiler can use.

; Clojure has syntax defined in terms of symbols, lists, vectors,
; maps, etc. The Reader is represented by the function `read` which
; reads the next _form_ (not character).
;
; The reader's purpose is for deserialization

(println (read-string "42"))

(println (read-string "(+ 1 2)"))
