; `do` evaluates all of the expression provided but 
; yields the last expression;
(def x 
  (do
     (println "This should be printed as a side effect, while x gets assigned to 1 * 2 * 3")
     (apply * [1 2 3])
  )
)

(assert (= x 6))

; `do` also marks where a side effect will be performed.  This mimics
; the idea presented by Haskell. It is also great to perform a unit of work
(defn is-odd? [number]
  (if
    (not= (mod number 2) 0)
    (do
       (println (str "found an odd number of " number))
       true
    )
    false
  )
)


(assert (= (is-odd? 3) true))
(assert (= (is-odd? 4) false))

