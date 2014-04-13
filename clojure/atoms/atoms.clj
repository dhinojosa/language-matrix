; Atoms are used for uncoordinated and synchronous updates.
; Atoms are light weight in nature and since there are no transactions,
; the require no do sync, use reset! to make a change to an atom

(def counter (atom 0))
(assert (= @counter 0))
(reset! counter 2)
(assert (= @counter 2))

; swap! will apply a function with arguments on an atom as an update

(swap! counter + 4)
(assert (= @counter 6))
