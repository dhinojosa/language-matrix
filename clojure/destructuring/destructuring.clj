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
  (assert (= fname "Elvis")
          (= lname "Presley")))



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
