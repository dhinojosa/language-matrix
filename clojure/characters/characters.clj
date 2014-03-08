; Characters are denoted by a backslash
; Should print b
(println \b)

; To determine the class of the the character or any other object
; use the class method
; should println `java.lang.Character`
(println (class \b))

; Character with unicode;
; Should println ö
(println \u00F6)

; Character with octal
; Should println !
(println \o41)

; Special named characters include
; \space
; \newline
; \formfeed
; \return
; \backspace
; \tab
;
; str is a method that creates a string from it's arguments
(println (str "It was the best of times" \newline "It was the worst of times"))
