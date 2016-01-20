; By default all clojure binding are in the #'user namespace

; Resolve returns the var (See vars/Vars.clj) or class that a symbol will resolve
; to
(def x 101)

; #'user/x is the name space and the var. The hash alone # is called the
; dispatch macro. The dispatch macro causes the reader to use a reader
; macro from another table, indexed by the character following

; The hash with the tick is called a var-quote and it obtains the var
; for an item. Therefore: #'x => (var x).

(assert (= (resolve 'x) #'user/x))
(assert (= (resolve 'x) (var user/x)))

;To display the current namespace use the *ns* variable. Any variable wrapped
; in asterisk is dynamically bounded meaning it is meant to be mutable. For
; example *ns* is the default namespace which happens to be user
(println *ns*)

;ns-interns will display all vars that are bound, and delivered as a map
(println (ns-interns *ns*))

(assert (= (map? (ns-interns *ns*)) true))

; Switch namespaces, we are now in foo-ns
(in-ns 'foo-ns)

; println would not work if we didn't declare that we wanted to use
; `clojure.core. The following will error out, since we are in a different
; namespace

;(println "foo")

; The #'user namespace had this automatically, but since we are using
; a different namespace, we have to declare 'use.
(clojure.core/use 'clojure.core)

; Now we should be able to println
(println "foo")

; 'x is nil since we are in a different namespace
(assert (= (resolve 'x) nil))

; but we can always refer to vars in a separate namespace using the fully
; qualified name
(println user/x)




; Declaring x in the #'foons namespace

(def x 102)

; Should resolve since we declared another x in another namespace

(assert (= (resolve 'x) #'foo-ns/x)) 

; When switching to a new namespace the java.lang package 
; will automatically be available
; Therefore this next statement can be shortened

(assert (= (. java.lang.Math abs -40) 40))

; to

(assert (= (. Math abs -40) 40))

; When you require a Java package you must import, 
; import is only required for Java classes
(import '(java.net URL))
(def cnn (new URL "http://www.cnn.com"))
(assert (= (.getHost cnn) "www.cnn.com"))

; To bring in a var from another namespace, you must use the 
; fully qualified name or map
; the name onto the new namespace
;
; IMPORTANT: When you require a library, clojure will look for a file named
; in this next example as clojure/set.clj in the CLASSPATH
(require 'clojure.set)
(assert (= (clojure.set/difference
              #{:eggs :milk :ranch-dressing} 
              #{:milk :bell-peppers :eggs})) #{:ranch-dressing})

; To bring in a var and create an alias you can use the :as keyword

(require '[clojure.set :as cs])
(assert (= (cs/union
              #{:eggs :milk :ranch-dressing} 
              #{:milk :bell-peppers :eggs})) #{:eggs :milk})

; This is how to declare a namespace to use while adding all clojure requirements
; and java imports

(ns bar-ns
  (:require [clojure.test :as ct])
  (:import (java.io.File)))

(ct/is (= 4 (+ 2 2)))
(assert (instance? java.io.File (new java.io.File "~/bob.txt")))

(def j 10)
(assert (= (resolve 'j) #'bar-ns/j)) ; check to ensure that it is indeed 
                                     ; in the bar-ns namespace
