; Keywords evaluate themselves and are used as 
;   accessors for the values they name
; Keywords must begin with a colon
; They cannot contain a '.' or name classes

; The {} denotes a Map
; Keep in mind that the current workspace is user

(def customer {:name "ACME Inc." :city "Tucson, AZ"})

(assert (= (:name customer) "ACME Inc."))

; A Keyword that begins with two colons is resolved 
; in the current namespace so as to avoid any conflicts
(def baseball-team {::name "Orioles" :city "Baltimore"})

; Jumping into another workspace, see namespaces/Namespaces.clj
(in-ns 'other-ns)

; Using clojure core since it doesn't come automatically with new namespaces
(clojure.core/use 'clojure.core)

; :name is not tied to a namespace so this will work, since the customer
; in the user workspace also used :name
(assert (= (:name user/customer) "ACME Inc."))

; ::name is a keyword tied to the namespace, therefore this will be nil since
;   ::name inside of the other-ns namespace is different that the ::name in the
;   user namespace
(assert (= (::name user/baseball-team) nil))

; Since we are using the fully qualified ::user/name we can now refer to the
; baseball team
(assert (= (::user/name user/baseball-team) "Orioles"))
