(comment defn defines a method
hello is the name of the method
[name] is the argument, dynamically typed
println is another method call that will println out the name)

(defn hello [name]
  (println "Hello,", name))

; calling the hello method
; all evaluations are lazy
(hello "Super Suave")
