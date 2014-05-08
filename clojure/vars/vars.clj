; Anything declared as a `def` for value names 
; or `defn` for function names can be referred by a var.
; Any def or def n calls are a root binding available to all threads.

(def x 10)

; locating x in a separate thread
(.start (Thread. #(assert (= x 10))))

; dynamic is a macro that allows a var to be reassigned in a binding
(def ^:dynamic y 10)

; inside the binding scope `y` takes on the value of `11`, the var `y` had
; previous been declared as `^:dynamic`

(binding [y 11]
  (assert (= y 11)))

; the binding should no take effect outside of the scope of the binding
; therefore y should be 10
(assert (= y 10))


; The initial value of a var is called a root binding

(assert (= (var x) #'user/x))         ; var will not return the value but the binding
                                      ; the #' is a reader macro that does the same thing

(defn funx [] "Up on a hill")
(assert (= (var x) #'x))
(assert (= (var funx) #'user/funx))
(assert (= (var funx) #'funx))

;vars can be alias into their own namespaces
;vars can contain metadata for documentation, type hints, and unit tests
;vars can rebound on a per-thread basis
