; Similar to an object. A record holds information

(defrecord Person [first-name last-name])

; Creating a record
(def louis-armstrong (Person. "Louis" "Armstrong"))

(assert (map? louis-armstrong)) ; a defrecord can be interpreted as a map

(assert (= (:first-name louis-armstrong) "Louis")) ; Use a keyword first-name

(def louis-map (assoc louis-armstrong :nickname "Satchmo"))

(assert (map? louis-map)) ; a defrecord can be interpreted as a map

(assert (:nickname louis-map) "Satchmo")

;It is also compiled as a class bound to the namespace as a package

(assert (= (.getName (.getClass louis-armstrong))) "user.Person")

; Defrecords can also implement an interface

(defrecord Album [name year number-tracks]
  java.lang.Comparable
  (compareTo [this other]
    (compare (get this :name) (get other :name))
    ))

(def thriller-album (Album. "Thriller" 1982, 12))

(assert (= (instance? java.lang.Comparable thriller-album) true))

(def thriller-copy (Album. "Thriller" 1982, 12))

(assert (= (.compareTo thriller-album thriller-copy) 0))

(defprotocol Named
  (name-of [item])
  )

(defrecord Snack [name calories size]
  Named
  (name-of [item] (get item :name)))

(defrecord Country [name capital]
  Named
  (name-of [cty] (get cty :name)))

(def snackbag (Snack. "Cheetoes" 300 "16oz."))

(def denmark (Country. "Denmark" "Copenhagen"))

(assert (= (name-of snackbag) "Cheetoes"))

(assert (= (name-of denmark) "Denmark"))

(defprotocol PigLatinizable
  (pig-latinize [item]))

(extend-type java.lang.String
  PigLatinizable
  (pig-latinize [s] (let [rest-str (rest s)]
                        (str (Character/toUpperCase (first rest-str))
                             (apply str (rest rest-str))
                             (Character/toLowerCase (first s))
                             "ay"))))

(assert (= (pig-latinize "Clojure") "Lojurecay"))