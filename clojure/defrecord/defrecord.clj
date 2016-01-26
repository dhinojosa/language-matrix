; Similar to an object. A record holds information

(defrecord Person [first-name last-name])

; Creating a record
(def louis-armstrong (Person. "Louis" "Armstrong"))

(assert (= (:first-name louis-armstrong) "Louis")) ; Use a keyword first-name

