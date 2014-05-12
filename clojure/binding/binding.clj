; Any call to def or defn (See functions)
; that object is stored in a var.
;
; def binds a function or data to a name
; this is also called a root binding

(def x 3)

(assert (= x 3))

; binding will re-bind the var into another value inside of
; for a different form context. This will perform anything with in the binding
; in parallel which differs from `let`. You can't do it this though
; if the root binding is not declared dynamic as it will throw a 
; `IllegalStateException`

(try 
   (binding [x 5] (+ x 5))
   (catch IllegalStateException e (.getMessage e)))

; the remedy to the situation declare the root binding with 
; the ^:dynamic macro annotation

(def ^:dynamic y 3)

(assert (= y 3))

(binding [y 5] (assert (= y 5)))


