; Anything declared as a `def` for value names 
; or `defn` for function names can be referred by a var

(def x 10)

(defn funx [] "Up on a hill")

; The initial value of a var is called a root binding

(assert (= (var x) #'user/x))         ; var will not return the value but the binding
                                      ; the #' is a reader macro that does the same thing
(assert (= (var x) #'x))
(assert (= (var funx) #'user/funx))
(assert (= (var funx) #'funx))
