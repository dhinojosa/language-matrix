; A list, set, map are sequences and can be operated on
; by a common set of functions.  Keep in mind that all 
; sequence functions may return an `ISeq`, a java representation 
; of a `Seq` (sequence) pronounced 'Seek'
;
; first obtains the first element
(assert (= (first '(1 2 3 4 5)) 1))

; rest obtains the collection minus the first element
; the seq function will return a `seq` of any sequence.
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

; maps are seq-able
(def contact-info {:first-name "Elvis" :last-name "Presley" :address "Graceland" :city "Memphis" :state "TN"})

; Operations that return collections are different 
; depending on the collection being operated on.

; An operation on a list returns a clojure.lang.PersistentList
(assert (= (. (class (rest '(1 2 3 4))) getName) "clojure.lang.PersistentList"))

; An operation on a vector returns a clojure.lang.PersistentVector$ChunkedSeq
(assert (= (. (class (rest [1 2 3 4])) getName) "clojure.lang.PersistentVector$ChunkedSeq"))

; An operation on a set returns a clojure.lang.APersistentMap$KeySeq
(assert (= (. (class (rest #{1 2 3 4})) getName) "clojure.lang.APersistentMap$KeySeq"))

; An operation on a map returns a clojure.lang.Aclojure.lang.PersistentHashMap
(assert (= (. (class (rest contact-info)) getName) "clojure.lang.PersistentHashMap$NodeSeq"))

; Many of these operations wouldn't make sense based on implementation like hash maps and sets 
; since the order cannot be determined at runtime.  You can however use collections like sorted set 
; and sorted map see sorted_sets/sortedsets.clj and sorted_maps/sortedmaps.clj for more information

(def star-trek-characters (sorted-set "Spock" "Kirk" "Worf" "Picard" "Riker"))
(assert (first star-trek-characters) "Spock")

(def band-hometowns (sorted-map :depeche-mode :basildon :the-cure :crawley :talking-heads :providence))
(assert (first band-hometowns) [:depeche-mode :basildon])
