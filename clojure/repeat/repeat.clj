; A repeat returns a `Seq` (see sequences/sequences.clj) and is used to repeat 
; a character

; A repeat of 5 characters (see characters/characters.clj)
(assert (= (repeat 5 \x) '(\x \x \x \x \x)))

; Since a repeat returns a sequence, all sequence functions are applicable, like count
(assert (= (count (repeat 5 1)) 5))

; When given a single item, repeat becomes a lazy infinite sequence and like all 
; inifinite sequences it needs a function to keep it from going on into infinity

(assert (= (take 3 (repeat 5)) '(5 5 5)))
