;Vectors are collection that map a elements sequentially by 
;contiguous integers.  Vectors are preferrable to Lists for faster
;access (log₂₃n)

(def states ["Ohio" "Michigan" "Illinois" "Indiana"])

;`conj` adds an element or elements to a vector behind the collection

(assert (= (last (conj states "Kentucky")) "Kentucky"))

; `conj` can also add other items as well

(assert (= (last (conj states "Kentucky" "Alabama" "Oregon" "Nevada")) "Nevada"))
