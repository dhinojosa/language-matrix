; Vars are containers to mutable storage locations
; The can come in
;   * global bindings
;   * thread local bindings
;   * function local bindings
;   * local to a form

(def ^:dynamic v 1); `dynamic` allows a thread local value
                   ;  within the scope of a binding call
		   ;  it allows re-definition of an assigned value
		   ;  per execution thread and scope
		   ;  if the var is not-reassigned to a new value in
		   ;  a separate execution thread, the var will refer to 
		   ;  the root binding, if accessed from another thread
		   ;
		   ;  ^ is "the meta character" it tells the reader 
		   ;  to add the symbol starting with ^ as metadata 
		   ;  to the next symbol, (kind of like annotation) 


(defn f1 []
  (println "f1: v:" v)) ; `defn` is the keyword to define a method

(defn f2 []
  (println "f2: before let v:" v)
  ; creates local binding v that shadows a global binding
  (let [v 2]
    ; local binding only works within this let statement
    ; let creates a lexically scoped immutable alias for a value
    (println "f2: in let, v:" v)
    (f1))
  ; out of the let, v refers again to the global binding
  (println "f2: after let v:" v))

(defn f3 []
  (println "f3: before binding v:" v)
  ; same global binding with new, temporary value
  ; binding creates a dynamically scoped binding for a Var only
  (binding [v 3]
    ;global binding, new value
    (println "f3: with binding function v" v)
    (f1)) ; calling f1 with the new value of v
  ;outside of the binding v, referring to the first global value
  (println "f3: after binding v:" v))

(defn f4 []
  (def v 4)) ;change the value of v in the global scope

(println "(= v 1) => " (= v 1))
(println "Calling f2: ")
(f2)
(println)
(f3)
(println)
(println "Calling f4: ")
(f4)
(println "after calling f4, v = " v)

