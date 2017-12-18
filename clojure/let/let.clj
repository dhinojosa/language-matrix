;Let creates a lexical scope of bindings
;
(assert (= (let [x 5
                 y 9]
                 x + y)) 14)

;x and y cannot be referred to outside of the local scope binding
