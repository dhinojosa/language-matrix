; A protocol is essentially what a type class is in 
; Scala or Haskell, you can very
; loosely consider them similar to interfaces and
; traits but they do not bind a method

(def ranks [:private :corporal :sergeant :lieutenant 
            :captain :major :colonel :general])
(def levels [:intern :worker :middle-manager
             :manager :vice-president :CEO])

; Utilities required to obtain the next item 
; from either ranks or levels, no checks are done to check 
; if the item is the first element or last.

(defn next-item [coll s] 
  (let [current (.indexOf coll s)]
      (coll (inc current))))

(defn prev-item [coll s] 
  (let [current (.indexOf coll s)]
      (coll (dec current))))

; Establish the protocol with methods that are to be defined by
; other types, in our case, Employees and Soldiers.
; Promote will increase this level by one, 
; Demote will decrease by one

(defprotocol Promotable
  (promote [x])
  (demote [x]))

; Create an Employee record, for more information on records see 
; records/records.clj. promote will update the employee to the 
; next level using a partial, for more information on partials
; see functions/functions.clj

(defrecord Employee [first-name last-name level]
  Promotable
  (promote [this] (update-in this [:level] (partial next-item levels)))
  (demote [this] (update-in this [:level] (partial prev-item levels)))
)

(defrecord Soldier [first-name last-name rank]
  Promotable
  (promote [this] (update-in this [:rank] (partial next-item ranks)))
  (demote [this] (update-in this [:rank] (partial prev-item ranks)))
)

(def tim (Employee. "Tim" "Zuzax" :intern))
(def cornelius (Soldier. "Cornelius" "Pepper" :lieutenant))

(def promoted-tim (promote tim))
(def demoted-cornelius (demote cornelius))

(assert (= (:level promoted-tim) :worker))
(assert (= (:rank demoted-cornelius) :sergeant))
