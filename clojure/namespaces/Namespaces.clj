; By default all clojure binding are in the #'user namespace

; Resolve returns the var (See vars/Vars.clj) or class that a symbol will resolve
; to.

(def x 101)

(assert (= (resolve 'x) #'user/x))

; Switch namespaces

(in-ns 'foons)

; The #'user namespace had this automatically, but since we are using
; a different namespace, we have to declare 'use

(clojure.core/use 'clojure.core) 

; println would not work if we didn't declare that we wanted to use `clojure.core.
; 'x is nil since we are in a different namespace

(assert (= (resolve 'x) nil))

; Declaring x in the #'foons namespace

(def x 102)

; Should resolve since we declared another x in another namespace

(assert (= (resolve 'x) #'foons/x)) 

; When switching to a new namespace the java.lang package will automatically be available
; Therefore this next statement can be shortened

(assert (= (. java.lang.Math abs -40) 40))

; to

(assert (= (. Math abs -40) 40))
