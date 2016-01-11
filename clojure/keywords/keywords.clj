; Keywords evaluate themselves and are used as 
;   accessors for the values they name
; Keywords must begin with a colon
; They cannot contain a '.' or name classes

(def customer {:name "ACME Inc." :city "Tucson, AZ"})

(println (:name customer))

; A Keyword that begins with two colons is resolved 
; in the current namespace

