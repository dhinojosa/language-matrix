; A function's parameters can be destructured in a let, 
; with the ability to bind vectors, 
; parameter vectors and any macro

(def albuquerque [35.1107 106.61])

; See let/let.clj for details
(let [[a b] albuquerque]
  (assert (and (= a 35.1107)
               (= b 106.61))))


; Destructuring a vector with an arg vector
(def grocery-vector ["Eggs" "Milk" "Lettuce" "Spinach" "Pork Chops"])

(let [[a b & others] grocery-vector]
   (assert (and (= a "Eggs")
                (= b "Milk")
                (= others ["Lettuce" "Spinach" "Pork Chops"]))))

; Using an :as keyword can be used as an alias for the entire vector, especially
; after destructuring
(let [[a b & others :as all-groceries] grocery-vector]
   (assert (and (= a "Eggs")
                (= b "Milk")
                (= all-groceries ["Eggs" "Milk" "Lettuce" "Spinach" "Pork Chops"])
                (= others ["Lettuce" "Spinach" "Pork Chops"]))))

; Destructuring can be done with a vector
(def elvis {:first-name "Elvis" :last-name "Presley" :middle-name "Aaron"})

(let [{fname :first-name lname :last-name} elvis]
  (assert (and (= fname "Elvis")
               (= lname "Presley"))))


; The above used `fname` and `lname` to show destructuring but mostly
; it used with the same name, this essentially converts keywords to variables
(let [{first-name :first-name last-name :last-name} elvis]
  (assert (and (= first-name "Elvis")
               (= last-name "Presley"))))

; The last two examples are so used that there is a directive that creates variable
(let [{:keys [first-name last-name]} elvis]
  (assert (and (= first-name "Elvis")
               (= last-name  "Presley"))))

; The :as on a vector binds a variable to an entire vector in the groceries example above,
; but it can also be bound to an entire map
(let [{:keys [first-name last-name] :as king-of-rock-and-roll} elvis]
  (assert (and (= first-name "Elvis")
               (= last-name  "Presley"))
               (= king-of-rock-and-roll elvis)))

; Destructuring can contain default values if some are not available
(let [{:keys [first-name last-name age] :or {age 0}} elvis]
   (assert (and (= first-name "Elvis")
                (= last-name "Presley")
                (= age 0))))

; Destructuring with all options available options
(let [{:keys [first-name last-name age] :or {age 0} :as king-of-rock-and-roll} elvis]
   (assert (and (= first-name "Elvis")
                (= last-name "Presley")
                (= age 0)
                (= king-of-rock-and-roll elvis))))

; Destructuring a nested map
(def elvis {:first-name "Elvis" :last-name "Presley" :middle-name "Aaron"
            :address {:name "Graceland" :line1 "3734 Elvis Presley Blvd."
                      :line2 nil :city "Memphis" :state "TN" :zip-code "38116"}})

(let [{first-name :first-name {home-name :name} :address} elvis]
    (assert (and (= first-name "Elvis")
                 (= home-name "Graceland"))))

; Destructuring a nested map using keys; remember keys only bind the keyword
; Therefore `name` must be used instead of `home-name`
(let [{first-name :first-name {:keys [name]} :address} elvis]
    (assert (and (= first-name "Elvis")
                 (= name "Graceland"))))

; Destructuring the outer and inner map together
(let [{:keys [first-name] {:keys [name]} :address} elvis]
    (assert (and (= first-name "Elvis")
                 (= name "Graceland"))))

; Destructuring nested vectors
(def tic-tac-toe [[\X \O \X]
                  [\X \O \X]
                  [\O \X \O]])

(let [[[a1 a2 a2]
       [b1 b2 b3]
       [c1 c2 c3]] tic-tac-toe]
  (assert (and (= a1 \X)
               (= b2 \O)
               (= c3 \O))))

; Destructuring both maps and vectors
(def honor-student {:first-name "Albert" :last-name "Einstein" :scores [88.6 102.0 92.5 91.0 70.2 103.0 104.0]})

(let [{first-name :first-name [score1 score2] :scores} honor-student]
   (assert (and (= first-name "Albert")
                (= score1 88.6)
                (= score2 102.0)))
)

; Destructuring map with :keys and vectors
(let [{:keys [first-name last-name] [score1 score2] :scores} honor-student]
   (assert (and (= first-name "Albert")
                (= score1 88.6)
                (= score2 102.0)))
)

; Destructuring map with :keys and vectors with & with the rest of the list
(let [{:keys [first-name last-name] [score1 score2 & other-scores] :scores} honor-student]
   (assert (and (= first-name "Albert")
                (= score1 88.6)
                (= score2 102.0)
                (= other-scores [92.5 91.0 70.2 103.0 104.0])))
)

; (defn find-all-by-first-name
;   "find all records of a vector given a firstName"
;   [person, people-vector]
;   (filter #(= (:first-name %) (:first-name person)) people-vector))
; 
; (defn find-all-by-first-name-with-destructuring
;   "find all records of a vector given a firstName but with destructuring"
;   [{fname :first-name}, people-vector]
;   (filter #(= fname (:first-name %)) people-vector))
; 
; (def hendrix {:first-name "Jimi" :last-name "Hendrix"})
; 
; (def performers [{:first-name "Jimmy" :last-name "Page"}
;                  {:first-name "Janis" :last-name "Joplin"}
;                  hendrix
;                  {:first-name "Jim" :last-name "Morrison"}])
; 
; (assert (= (find-all-by-first-name hendrix performers) (vector hendrix)))
; 
; (assert (= (find-all-by-first-name-with-destructuring hendrix performers) (vector hendrix)))
