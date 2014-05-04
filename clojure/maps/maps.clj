; Map is created with braces where the key and value are alternated

(def national-league {:reds "Cincinnati Reds", :dodgers "Los Angeles Dodgers",
                      :braves "Atlanta Braves", :astros "Houston Astros", 
                      :expos nil})

; Map though doesn't need commas

(def national-league {:reds "Cincinnati Reds" :dodgers "Los Angeles Dodgers"
                      :braves "Atlanta Braves" :astros "Houston Astros"
                      :expos nil})

; One way to grab the value using a key is with the function `get`

(assert (= (get national-league :reds) "Cincinnati Reds"))

; An alternate way is to just to use a map as a function

(assert (= (national-league :dodgers) "Los Angeles Dodgers"))

; Another alternate way to get the value is by using a key symbol as a functions

(assert (= (:astros national-league) "Houston Astros"))

; The default implementation of a map is a HashMap
; The period and getName is used to retrieve the class name,
; see java_interop/java_interop.clj for details

(assert (. (class national-league) getName) "clojure.lang.PersistentHashMap")

; Looking up a key that is not there will return `nil` (which represents nothing)

(assert (= (:diamondbacks national-league) nil))

; Unfortunately you can have a value of `nil` in a map and it would be ambiguous 
; since it can either mean it is not in the map, or the value is actually `nil`

(assert (= (:expos national-league) nil)) ; nil is actually not a value

; A better function to call is contains?

(assert (contains? national-league :expos))
(assert (not (contains? national-league :diamondbacks)))

; Another strategy that can be used is to use a third argument as what gets returned
; if the key is not found

(assert (get national-league :diamondbacks :not-found) :not-found) 

; `assoc` adds another key-value pair to a map

(assert (:padres 
           (assoc national-league :padres "San Diego Padres")
           "San Diego Padres"))

; important to note that maps as well as other collections are immutable!

(assert (not (contains? national-league :padres))) ; the original map did not change

; `dissoc` removes a key-value pair from a map
(assert (not (contains? (dissoc national-league :reds) :reds)))

; `select-keys` returns a new map with only the keys passed in
(assert (count (select-keys national-league [:reds :astros])) 2)

; `merge` combines two maps

(def more-national-league {:cardinals "St. Louis Cardinals" :cubs "Chicago Cubs"
                           :mets "New York Mets" :pirates "Pittsburgh Pirates"})

(assert (= (count (merge national-league more-national-league)) 9))

; merge though will always to differ to the right hand argument if there are
; duplicates

(def more-national-league {:cardinals "St. Louis Cardinals" :cubs "Chicago Cubs"
                           :mets "New York Mets" :pirates "Pittsburgh Pirates"
                           :expos "Montreal Expos"})

(assert (= (:expos (merge national-league more-national-league)) "Montreal Expos"))

; merge-with is much like merge but will apply a function to all the values
;

(def more-national-league {:cardinals "St. Louis Cardinals" :cubs "Chicago Cubs"
                           :mets "New York Mets" :pirates "Pittsburgh Pirates"
                           :expos "Montreal Expos" :giants "San Francisco Giants"})

(def national-football-conference {:cardinals "Arizona Cardinals" 
                                   :49ers "San Francisco 49ers"
                                   :giants "New York Giants"
                                   :cowboys "Dallas Cowboys"})

(assert (= (:cardinals (merge-with concat more-national-league
                                          national-football-conference)
                       ["St. Louis Cardinals" "Arizona Cardinals"])))

; a "nested associative structure" is a structure like maps, vectors or lists 
; inside of a map vector or list, where as an element
; can be retrieved using a key or index

(def major-league-baseball-championships
  {:american-league {:red-sox 8
                     :yankees 27
                     :athletics 9
                     :tigers 4
                     :orioles 3}

   :national-league {:giants 7
                     :cardinals 11
                     :reds 5
                     :pirates 5
                     :dodgers 6}})

; to dig into a nested associative structure like a map you can use `get-in`

(assert (get-in major-league-baseball-championships [:national-league :reds]) 5)

; to change the number of championships for the athletics, you can use assoc-in and it returns a new copy.

(assert (get-in (assoc-in major-league-baseball-championships [:american-league :athletics] 10) [:american-league :athletics]) 10)

; a "nested associative structure can be a map of lists" and assoc-in can be used with the index
; it we wanted to see who is in first place in the american league central we can call get-in

(def major-league-baseball-standings
  {:american-league {:east    [:yankees :orioles :red-sox :rays :blue-jays]
                     :central [:tigers :royals :white-sox :twins :indians]
                     :west    [:athletics :rangers :angels :mariners :astros]}
   :national-league {:east    [:braves :nationals :mets :marlins :phillies]
                     :central [:brewers :cardinals :reds :cubs :pirates]
                     :west    [:giants :rockies :dodgers :padres :diamondbacks]}})

(assert (get-in major-league-baseball-standings [:american-league :central 0]) :tigers)
