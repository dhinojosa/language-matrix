; Refs (see refs/refs.clj) supports coordinated, synchronous change of multiple locations 
; Agents provide independent, asynchronous change of individual locations
; Prefer immutability for item being stored
;
(def counter (agent 0))

(send counter inc)

(assert (= (deref counter) 1))

(send counter #(+ % 2))

(assert (= @counter 3))

(shutdown-agents) ; Shuts down agents before terminating the JVM
