; A list, set, map are sequences and can be operated on
; by a common set of functions.  Keep in mind that all 
; sequence functions may return an `ISeq`, a java representation 
; of a `Seq` (sequence)
;
; first obtains the first element
(assert (= (first '(1 2 3 4 5)) 1))

; rest obtains the collection minus the first element
; the seq function will return a `seq` of any sequence.
;
(assert (= (rest #{1 2 3 4 5}) (seq #{4 3 2 5})))

; cons will append an element depending on the collectiona
(assert (= (cons 3 '(4 5 6 7)) '(3 4 5 6 7)))

; `seq` will return nil if the collection is empty
(assert (= (seq '()) nil))

; `next` is the equivalent of (seq(rest aseq))
(assert (= (next #{1 2 3 4 5}) (seq #{2 3 4 5})))

; vectors are seq-able
(assert (= (cons 3 [4 5 6 7]) [3 4 5 6 7]))
(assert (= (rest [3 4 5 6]) [4 5 6]))
(assert (= (first [5 6 7 9]) 5))

; Operations that return collections are different 
; depending on the collection being operated on.

; An operation on a list returns a clojure.lang.PersistentList
(assert (= (. (class (rest '(1 2 3 4))) getName) "clojure.lang.PersistentList"))

; An operation on a vector returns a clojure.lang.PersistentVector$ChunkedSeq
(assert (= (. (class (rest [1 2 3 4])) getName) "clojure.lang.PersistentVector$ChunkedSeq"))

; An operation on a set returns a clojure.lang.APersistentMap$KeySeq
(assert (= (. (class (rest #{1 2 3 4})) getName) "clojure.lang.APersistentMap$KeySeq"))
