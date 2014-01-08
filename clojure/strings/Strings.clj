(println "Standard String") ; printing a regular string

(println "Multiline String without needing 
         any extra characters") ; nothing else special required

; The result is "s is"
; `.substring` is a method on java.lang.String
(println(.substring "This is Clojure" 3 7))
