; Metadata is data that is orthogonal with the code. Metadata's
; relationship with the code is immutable.
; 
; Metadata can either be used by the compiler, external systems. 
; Metadata is about the symbol or collection.  Some important
; point to consider:
;
; * Metadata does not affect equality
; * Metadata does not affect the value of the object

; To view the metadata attached to an object
; call the `meta` function and provide the reader macro 
; #' and the name of the symbol that you need information about.

(println (meta #'str))
(println (meta #'clojure.core/str)) ; explicit call with clojure.core

; When viewing the metadata for any clojure symbol, some standards that you will
; need to know
; 
;     :argslists List of vector(s) of argument forms
;     :doc The documentation of the symbol
;     :file Source file where the construct is located
;     :line The line location of the symbol
;     :column The column where the declaration is made
;     :macro Whether the symbol is a macro (true or false)
;     :name The local name of the symbol
;     :ns The namespace of the symbol
;     :tag Expected argument or return type

; Metadata like :ns, :name, :file, and :column are provided automatically
(def x (str "One " "Two " "Three"))
(println (meta #'x))

; Add metadata with ^{<keyword> <value>}

(defn ^{:tag String} piglatin [^{:tag String} s]
  (str (apply str (rest s)) (first s) "ay"))

(assert (= (piglatin "rocky") "ockyray"))
