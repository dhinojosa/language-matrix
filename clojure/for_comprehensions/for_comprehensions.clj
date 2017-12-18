; Copyright (c) 2017 Hinojosa, Daniel <dhinojosa@evolutionnext.com>
; Author: Hinojosa, Daniel <dhinojosa@evolutionnext.com>
;
; Permission is hereby granted, free of charge, to any person obtaining a copy of
; this software and associated documentation files (the "Software"), to deal in
; the Software without restriction, including without limitation the rights to
; use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
; the Software, and to permit persons to whom the Software is furnished to do so,
; subject to the following conditions:
;
; The above copyright notice and this permission notice shall be included in all
; copies or substantial portions of the Software.
;
; THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
; IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
; FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
; COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
; IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
; CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

; Clojure does not have a for loop.  What clojure has like all 
; functional languages is a for comprehension which 
; takes a (binding vector) pair and returns a 
; sequence of expressions

; This simple case is a map
(def a (for [x [1 2 3 4]] (+ x 1)))

(assert (= a [2 3 4 5]))

; This simple case take two collection bindings and add them
; this is almost similar to a nested for loop.

(def b (for [x [1 2 3 4] y [5 6 7 8]] (+ x y)))

(assert (= b [6 7 8 9 7 8 9 10 8 9 10 11 9 10 11 12]))
