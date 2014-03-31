; `ref` is a mutable reference. Clojure is immutable in just about every
; regard, but when mutability is required, then ref wraps around 
; a reference that can potentially be mutable. `ref` protects the state.

; Modelling the roll of some dice
(def current-roll (ref [6 3]))

; Used `deref` to read the contents
(assert (= (deref current-roll) [6 3]))

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
