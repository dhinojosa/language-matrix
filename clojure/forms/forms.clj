; Chunks of data read by the clojure reader.

; A number is a form, see number/Numbers.clj
(println 22)
(println 44.3)

; A Vector is a form, see vector/Vector.clj
(println [1 2 3])

; A List is a form see list/Lists.clj
(println 1 2 3)

; A List with a function is also a form, see function/Functions.clj
; Having the + in the beginning is prefix notation
(println (+ 1 2 4))

;A boolean is a form, see boolean/Booleans.clj
(println true)
(println false)

;A character is a form, see character/Characters.clj
(println \b)

;A symbol is a form, see symbol/symbols.clj
(println java.lang.String)
; TODO: (println user/foo) fix this

;A Nil is a form, see nil/Nils.clj
(println nil)

;A Keyword is a form, see keyword/Keywords.clj
(println :bob)

;A Map is a form, see map/Maps.clj
(println {:name "Cesar" :age 50})

;A Set is a form, sett set/Sets.clj
(println #{"Abe", "Ray", "Ann", "Lisa"})
