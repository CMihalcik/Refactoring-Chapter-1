(ns test.statement
  (:import [bad.robot.refactoring.chapter1.rentables Movie])
  (:use
    [clojure.test])
  (:import (bad.robot.refactoring.chapter1.rentables ChildrensMovie RegularMovie NewReleaseMovie)
           (bad.robot.refactoring.chapter1 Rental Customer Movie)))

; build movies
(def chilrens-movie (ChildrensMovie. "children's movie"))
(def regular-movie (RegularMovie. "regular movie"))
(def new-release-movie (NewReleaseMovie. "new release movie"))

; build rentals
(def childrens-rental (Rental. chilrens-movie 3))
(def regular-rental (Rental. regular-movie 5))
(def new-release-rental (Rental. new-release-movie 5))


; build a customer with one rental of each movie
(def cusomer-with-one-of-each-rental
  (do
    (let [c (Customer. "Customer renting one of each type of movie")]
      (.addRental c childrens-rental)
      (.addRental c regular-rental)
      (.addRental c new-release-rental)
      c)))

; build a customer no rentals
(def cusomer-with-no-rentals (Customer. "Customer with no rentals"))

; produce statement
(def one-of-each-statement (. cusomer-with-one-of-each-rental statement))
(def no-rentals-statement (. cusomer-with-no-rentals statement))

(def one-of-each-statement-expected-result "Rental record for Customer renting one of each type of movie
	children's movie	1.5
	regular movie	6.5
	new release movie	6.5
Amount owed is 14.5
You earned 4 frequent renter points")

(def no-rentals-statement-expected-result "Rental record for Customer with no rentals
Amount owed is 0.0
You earned 0 frequent renter points")

(deftest test-statements
  (is (= one-of-each-statement one-of-each-statement-expected-result))
  (is (= no-rentals-statement no-rentals-statement-expected-result)))

(run-tests)