; Using maps as data is generally universally accepted
; to model data. Records are created faster, consume less 
; memory, looks up keys with itself quickly. Record cannot serve
; as functions (see maps/maps.clj), not can they be equal 
; to maps with the same key/values.

{:first-name "Dwight", :middle-name "David", :last-name "Eisenhower"}

; The only issue is that it isn't it's own type, this
; is where records can play a role

(defrecord President [first-name middle-name last-name])

(def jfk (President. "John" "Fitzgerald" "Kennedy"))

; record information can be accessed
(assert (= (:first-name jfk) "John"))
(assert (= (:last-name jfk) "Kennedy"))

; Use the function update-in to update the contents of a record
; this operation is immutable

(def jack-kennedy (assoc-in jfk [:first-name] "Jack"))

(assert (= (:first-name jack-kennedy) "Jack"))
(assert (= (:first-name jfk) "John"))
