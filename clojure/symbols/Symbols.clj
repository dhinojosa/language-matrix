; Symbols are identifiers, name
; They evaluate to the values held by var
; Begin with a non-numeric and can contain *, +, !, -, _, and ?
; The slash (/) is reserved to separate namespace
; The period (.) is used to seprate class name `java.util.Set`or namespace\

; From http://http://stackoverflow.com/questions/2320348/symbols-in-clojure
; In Common Lisp, a "symbol" is a location in memory, a place where data
; can be stored. The "value" of a symbol is the data stored at that location in memory.

; In Clojure, a "symbol" is just a name. It has no value.

; When the Clojure compiler encounters a symbol, it tries to resolve it as

; * a Java class name (if the symbol contains a dot)
; * a local (as with "let" or function parameters)
; * a Var in the current Namespace
; * a Var referred from another Namespace

;The Var represents a storage location.

;There are good reasons why Clojure separates Vars from Symbols.
; First, it avoids the annoyance of Common Lisp's
; automatically-interned symbols, which can "pollute"
; a package with unwanted symbols.

;Secondly, Clojure Vars have special semantics with regard to concurrency.
; A Var has a exactly one "root binding" visible to all threads.
; (When you type "def" you are setting the root binding of a Var.)
; Changes to a Var made within a thread (using "set!" or "binding")
; are visible only to that thread and its children.


; `str` is a Symbol
(println (str "One" "Two" "Three" "A" "Clock"))

; creating a method
(defn adder 
  [x y]
  (+ x y))

; adder is now a symbol
(println (adder 3 5))
