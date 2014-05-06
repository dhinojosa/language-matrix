; Refs (see refs/refs.clj) supports coordinated, synchronous change 
; of multiple locations 
;
; Agents provide independent, asynchronous change of individual locations
; Prefer immutability for item being stored

; Setting up an initial state
(def counter (agent 0))

; `send` sends a `inc` function to run on a separate thread pool
(send counter inc)

; use `deref` or `@` to dereference the agent
(assert (= (deref counter) 1))

; `send` a custom function that add 2 to change the counter asynchronously
(send counter #(+ % 2))

; using `@` to obtain the value of the agent
(assert (= @counter 3))

; using a validator for the agent, the agent still needs to be validated
(def counter (agent 1 :validator odd?))

; send a function that commits a valid change of the agent, otherwise you will
; receive an `IllegalStateException`
(send counter #(+ % 2))

; attempting to send the counter a function that would cause the agent to be invalid
(try 
  (send counter #(+ % 3))
  (catch IllegalStateException e 
    (str "caught IllegalArgumentException: " (.getMessage e))))

; once a failure occurs the agent will need to be made useable again by using `clear-agent-errors`

(clear-agent-errors counter)

; waiting for any agents to complete the actions sent with `await` and `await-for`
; `await-for` will allow you to specify the number of milliseconds it should wait.
; `await` will wait forever.

(send counter #(+ % 2))

(await counter)

(send counter #(+ % 2))

(await-for 3000 counter)

; send-off will send a function off to an agent in a separate thread pool that will possibly block
; these can be used inside a transaction and is used often as a follow up side effect after
; updating an agent

(def log-agent (agent (System/out)))

(send-off log-agent #(.println % "One Message"))

(shutdown-agents) ; Shuts down agents before terminating the JVM
