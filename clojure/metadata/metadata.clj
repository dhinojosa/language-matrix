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
; This will return a map of the metadata associated with the symbol or collection
;
; For example, the metadata for str is:
; {:added 1.0, :ns #<Namespace clojure.core>, :name str, :file clojure/core.clj, :static true, 
;  :column 1, :line 511, :tag java.lang.String, :arglists ([] [x] [x & ys]), 
;  :doc With no args, returns the empty string. With one arg x, returns
;   x.toString().  (str nil) returns the empty string. With more than
;   x.t  one arg, returns the concatenation of the str values of the args.}
;
;
(assert (= (:file (meta #'str) "clojure.core/str")))

; Explicit call with clojure.core
(assert (= (:added (meta #'clojure.core/str) 1.0))) 

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

; Metadata like :ns, :name, :file, :tag, :line, :doc, :arglists
; and :column are provided automatically

(def x (str "One " "Two " "Three"))

; x above renders the metadata of:
; {:ns #<Namespace user>, :name x, :file /home/danno/development/language-matrix/clojure/metadata/metadata.clj, :column 1, :line 43}
(assert (:name (meta #'x) "x"))


; Add your custom metadata with ^{<keyword> <value>}
(defn ^{:tag String} piglatin [^{:tag String} s]
  (str (apply str (rest s)) (first s) "ay"))

; The above generates a metadata of:
; {:ns #<Namespace user>, :name piglatin, 
;  :file /home/danno/development/language-matrix/clojure/metadata/metadata.clj, 
;  :column 1, :line 54, :tag java.lang.String, :arglists ([s])}
;
; Therefore:
(assert (:tag (meta #'piglatin) "String"))
(assert (= (piglatin "rocky") "ockyray"))


; Creating :tag metadata can be used in the short form ^<classname>
(defn ^String piglatin-2 [^String s]
  (str (apply str (rest s)) (first s) "ay"))

(println (meta #'piglatin-2)) ; verify it on the console

; If you so care to, you can place the metadata information at the end
(defn piglatin-3 [s]
  (str (apply str (rest s)) (first s) "ay") 
  {:tag String})

(println (meta #'piglatin-2)) ; verify it on the console

