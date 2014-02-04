; if statement, if the evaluation is true it will return 
; the first statement, if it is false, it will return `nil`

(defn is-odd-with-nil? [number]
  (if (not= (mod number 2) 0) true))

(assert (= (is-odd-with-nil? 3) true))
(assert (= (is-odd-with-nil? 4) nil))

; if return `nil` is not your thing you can include the `else` part
(defn is-odd? [number]
  (if (not= (mod number 2) 0) true false))

(assert (= (is-odd? 3) true))
(assert (= (is-odd? 4) false))
