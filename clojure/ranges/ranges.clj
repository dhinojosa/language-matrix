; A range returns a `Seq` (see sequences/sequences.clj)

; A range of 20 creates a range from 0..19
(assert (= (count (range 20)) 20))
(assert (= (last (range 20)) 19))

; A range is a sequences
(assert (= (. (class (range 30)) getName) "clojure.lang.LazySeq"))

; Therefore all sequence functions work with a range
(assert (= (first (conj (range 5) 10)) 10))

; A range can include a start number
(assert (= (first (range 10 20)) 10))
(assert (= (last (range 10 20)) 19))

; Ranges can also include a step
(assert (= (first (range 3 21 2)) 3))
(assert (= (second (range 3 21 2)) 5))
(assert (= (last (range 3 21 2)) 19))
