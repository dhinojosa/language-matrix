; `ref` is a mutable reference. Clojure is immutable in just about every
; regard, but when mutability is required, then ref wraps around 
; a reference that can potentially be mutable. `ref` protects the state.
; `ref` is synchronous.

; Modelling the roll of some dice
(def current-roll (ref [6 3]))

; Use `deref` to read the contents
(assert (= (deref current-roll) [6 3]))

; The @<ref-name> can also be used to `deref`
(assert (= @current-roll [6 3]))

; If we do not use `deref`, you will merely get the ref object
(assert (= (. (class current-roll) getName) "clojure.lang.Ref"))

; In order to reassign a `ref`, do so with `ref-set` with a 
; wrapped transaction function `dosync`. `dosync` will ensure that 
; transactions are:
;    atomic - more than one ref in a single transaction
;             will occur simultanously)
;    consistent - if one update fails, the entire transaction fails
;    isolated - no update can viewed until all updates are done
;
(dosync (ref-set current-roll [1 2]))
(assert (= (deref current-roll) [1 2]))

; To update two separate refs, wrap two ref-sets in a `dosync`

(def checking (ref 1000))
(def savings (ref 20000))

(dosync
  (ref-set checking (+ (deref checking) 100))
  (ref-set savings (- (deref savings) 100)))

(assert (and
           (= @checking 1100)
           (= @savings 19900)))

; While the previous examples work, there is a better way using `alter`
; Alter will perform a read and write operation in a single step by applying 
; a function to referenced object in a transaction. The function must be one that accepts
; the ref as the first argument.

(dosync
  (alter checking + 100)
  (alter savings - 100))

(assert (and
          (= (deref checking) 1200)
          (= (deref savings) 19800)))


; alter will perform operation in the order that they are give, commute will
; allow for more concurrency since they will occur in any order

(def log (ref []))
(dosync
  (alter log conj 1)
  (alter log conj 2)
  (alter log conj 3)
  (alter log conj 4))

(assert (= (deref log) [1 2 3 4]))

; TODO: Come back to this one when we do agents and threads, or put in that category
; (def log (ref []))
; (dosync
;   (doseq [x (range 0 4)]
;     (commute log conj (do
;                          (let [rand-num (* (rand-int 2000) x)]
;                              (println rand-num)
;                              (Thread/sleep rand-num)
;                              (+ x 1))))
;   )
; )
; (println (deref log))
; (assert (not (= (deref log) [1 2 3 4])))

; refs can be validated when added as an option to a ref using `:validator.`
; `validator` requires a function that takes one argument.

(def is-even #(= (mod % 2) 0))

(def my-number (ref 0 :validator is-even)) ; uses the function is-even to 
                                           ; validate reference

(dosync
  (alter my-number + 2))

(assert (= (deref my-number) 2))
