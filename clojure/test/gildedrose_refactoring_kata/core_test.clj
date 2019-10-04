(ns gildedrose-refactoring-kata.core-test
  (:require [clojure.test :refer :all]
            [gildedrose-refactoring-kata.core :refer :all]))

(deftest update_quality_test
  (testing "quality should drop by one every day before expiration"
    (is (= 9 (:quality (first (update_quality (list (struct-map item :quality 10 :sell_in 10))))))))
  (testing "quality should drop twice as fast if expired"
    (is (= 8 (:quality (first (update_quality (list (struct-map item :quality 10 :sell_in -4)))))))))