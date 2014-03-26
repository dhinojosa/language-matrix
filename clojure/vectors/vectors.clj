;Vectors are collection that map a elements sequentially by 
;contiguous integers.  Vectors are preferrable to Lists for faster
;access (log₂₃n)

(def states ["Ohio" "Michigan" "Illinois" "Indiana"])

;`conj` adds an element or elements to a vector behind the collection

(assert (= (last (conj states "Kentucky")) "Kentucky"))

; `conj` can also add other items as well and added to the end of the collection

(assert (= (last (conj states "Kentucky" "Alabama" "Oregon" "Nevada")) "Nevada"))

; `into` adds one collection into another. In the case of a vector, it will apply it at the end

(assert (= (last (into states ["Arizona", "Utah", "Tennessee", "North Dakota"])) "North Dakota"))

; `into` can add any collection, what matters is the source, in this case a vector. 
; In the following; adding a list into a vector

(assert (= (last (into states '("Arizona", "Utah", "Tennessee", "North Dakota"))) "North Dakota"))
