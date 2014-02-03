; By default all clojure binding are in the #'user namespace

; Resolve returns the var (See vars/Vars.clj) or class that a symbol will resolve
; to.

(def x 101)

(assert (= (resolve 'x) #'user/x))

; Switch namespaces

(in-ns 'foo-ns)

; The #'user namespace had this automatically, but since we are using
; a different namespace, we have to declare 'use

(clojure.core/use 'clojure.core)

; println would not work if we didn't declare that we wanted to use `clojure.core.
; 'x is nil since we are in a different namespace

(assert (= (resolve 'x) nil))

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
