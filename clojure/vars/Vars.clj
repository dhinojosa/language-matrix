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
    ;local binding only works within this let statement
    (println "f2: in let, v:" v)
    (f1))
  ; out of the let, v refers again to the global binding
  (println "f2: after let v:" v))

