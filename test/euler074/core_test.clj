(ns euler074.core-test
  (:use euler074.core)
  (:use midje.sweet))

(fact "midje seems to work"
  (+ 1 2) => 3)

(fact
  (non-repeating-terms 145) => #{145}
  (provided
    (integer-to-list 145) => '(1 4 5)
    (sum-of-factorials '(1 4 5)) => 145))

(fact
  (non-repeating-terms 540) => #{540 145}
  (provided
   (integer-to-list 540) => '(5 4 0)
   (integer-to-list 145) => '(1 4 5)))

(fact
 (non-repeating-terms 78) => #{78 45360 871 45361})

(fact
  (sum-of-factorials '(1 4 5)) => 145
  (sum-of-factorials '(6 9)) => 363600)

(fact
  (factorial 0) => 1
  (factorial 1) => 1
  (factorial 2) => 2
  (factorial 3) => 6
  (factorial 9) => 362880)

(fact
 (integer-to-list 145) => '(1 4 5)
 (integer-to-list 540) => '(5 4 0)
 (integer-to-list 7) => '(7))

(fact
 (euler074 1 1) => 1
 (euler074 2 1) => 2)

