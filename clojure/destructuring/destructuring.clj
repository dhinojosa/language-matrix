; A function's parameters can be destructured in a let, 
; with the ability to bind lists, 
; parameter lists and any macro

(def albuquerque [35.1107 106.61])

; See let/let.clj for details
(let [[a b] albuquerque]
  (assert (and (= a 35.1107)
               (= b 106.61))))


; Destructuring a list with an arg list
(def grocery-list ["Eggs" "Milk" "Lettuce" "Spinach" "Pork Chops"])

(let [[a b & others] grocery-list]
   (assert (and (= a "Eggs")
                (= b "Milk")
                (= others ["Lettuce" "Spinach" "Pork Chops"]))))

; Using an :as keyword can be used as an alias for the entire list, especially
; after destructuring
(let [[a b & others :as all-groceries] grocery-list]
   (assert (and (= a "Eggs")
                (= b "Milk")
                (= all-groceries ["Eggs" "Milk" "Lettuce" "Spinach" "Pork Chops"])
                (= others ["Lettuce" "Spinach" "Pork Chops"]))))

; Destructuring can be done with a list
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

; The :as on a list binds a variable to an entire list in the groceries example above,
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


; (defn find-all-by-first-name
;   "find all records of a list given a firstName"
;   [person, people-list]
;   (filter #(= (:first-name %) (:first-name person)) people-list))
; 
; (defn find-all-by-first-name-with-destructuring
;   "find all records of a list given a firstName but with destructuring"
;   [{fname :first-name}, people-list]
;   (filter #(= fname (:first-name %)) people-list))
; 
; (def hendrix {:first-name "Jimi" :last-name "Hendrix"})
; 
; (def performers [{:first-name "Jimmy" :last-name "Page"}
;                  {:first-name "Janis" :last-name "Joplin"}
;                  hendrix
;                  {:first-name "Jim" :last-name "Morrison"}])
; 
; (assert (= (find-all-by-first-name hendrix performers) (list hendrix)))
; 
; (assert (= (find-all-by-first-name-with-destructuring hendrix performers) (list hendrix)))
