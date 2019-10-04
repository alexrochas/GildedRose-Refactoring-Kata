(ns gildedrose-refactoring-kata.core-test
  (:require [clojure.test :refer :all]
            [gildedrose-refactoring-kata.core :refer :all]))

(let [items (list (struct-map item :quality 10 :sell_in 10))]
  (deftest quality
    (testing "quality should drop by one every day before expiration"
      (is (= 9 (:quality (first (update_quality items))))))))
