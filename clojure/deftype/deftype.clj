;;require a protocol to create the methods that are required
(defprotocol FullNaming
  (full-name [this]))

;; specify the type and use the protocol to present the method
(deftype Employee 
  [first-name last-name]
  FullNaming 
  (full-name [this] (str first-name " " last-name))
)

;; assignment to employee
(def employee (Employee. "Maya" "Angelou"))

;; assert that the value is correct
(assert (= (full-name employee) "Maya Angelou"))
