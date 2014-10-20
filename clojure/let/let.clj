;Let creates a lexical scope of bindings

(println (let [x 5
               y 9] (+ x y)))

(assert (= (let [x 5
                 y 9]
                 (+ x y)) 14))

; x and y cannot be referred to outside of the local scope binding
;
(def x 10)

(defn add-x [y] (+ x y))

(println (let [x 6] (add-x 5)))

(def ^:dynamic x′ 10)

(defn add-x′ [y′] (+ x′ y′))

(println (binding [x′ 6] (add-x′ 5)))
