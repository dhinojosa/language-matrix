; A function's parameters can be destructured and able to go from:
(defn find-all-by-first-name
  "find all records of a list given a firstName"
  [person, people-list]
  (filter #(= (:first-name %) (:first-name person)) people-list))

(defn find-all-by-first-name-with-destructuring
  "find all records of a list given a firstName but with destructuring"
  [{fname :first-name}, people-list]
  (filter #(= fname (:first-name %)) people-list))

(def hendrix {:first-name "Jimi" :last-name "Hendrix"})

(def performers [{:first-name "Jimmy" :last-name "Page"}
                 {:first-name "Janis" :last-name "Joplin"}
                 hendrix
                 {:first-name "Jim" :last-name "Morrison"}])

(assert (= (find-all-by-first-name hendrix performers) (list hendrix)))

(assert (= (find-all-by-first-name-with-destructuring hendrix performers) (list hendrix)))
