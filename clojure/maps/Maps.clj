; Literal maps are surrounded by curly braces

(def capitals {"Texas"      "Austin"
               "New Mexico" "Santa Fe"
               "Arizona"    "Phoenix"
               "Colorado"   "Denver"
               "Utah"       "Salt Lake City"})

; Maps can contain commas to separate the entries
(def comma-delim-capitals {"Texas"      "Austin",
                           "New Mexico" "Santa Fe",
                           "Arizona"    "Phoenix",
                           "Colorado"   "Denver",
                           "Utah"       "Salt Lake City"})

; Maps are functions themselves, if you pass the key 
; as a parameter it will return the value, if the value 
; is not found then a nil is returned

(assert (= (capitals "Texas") "Austin"))
(assert (= (comma-delim-capitals "Utah") "Salt Lake City"))
(assert (= (capitals "Puerto Rico") nil))

; The get function provides some added functionality to
; retrieve values
(assert (= (get capitals "Texas") "Austin"))
(assert (= (get capitals "Austria") nil))

; The get function has an alternative in case the key is not found

(assert (= (get capitals "Singapore" "Not Found") "Not Found"))

; Typically keywords are used as keys instead, which are immutable identifiers
; See keywords/Keywords.clj for more infomration.

(def keyword-capitals {:Texas      "Austin"
                       :NewMexico  "Santa Fe"
                       :Arizona    "Phoenix"
                       :Colorado   "Denver"
                       :Utah       "Salt Lake City"})

(assert (= (get keyword-capitals :Texas) "Austin"))
(assert (= (get keyword-capitals "Texas") nil))
(assert (= (get keyword-capitals "Austria") nil))
(assert (= (get keyword-capitals :Austria) nil))

; Keywords can be used as functions and used to retreive values from a 
; map with keyword keys

(assert (= (:Arizona keyword-capitals) "Phoenix"))
