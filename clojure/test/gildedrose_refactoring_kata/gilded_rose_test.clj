(ns gildedrose-refactoring-kata.gilded-rose-test
  (:require [clojure.test :refer :all]
            [gildedrose-refactoring-kata.gilded_rose :refer :all]
            [gildedrose-refactoring-kata.item :refer :all]))

(deftest update_quality_test
  (testing "quality should drop by one every day before expiration"
    (is (= 9 (:quality (first (update_quality (list (struct-map item :name "Item 1" :quality 10 :sell_in 10))))))))
  (testing "quality should not be negative"
    (is (= 0 (:quality (first (update_quality (list (struct-map item :name "Item 2" :quality 0 :sell_in 10))))))))
  (testing "aged brie should rise it's quality instead of drop"
    (is (= 5 (:quality (first (update_quality (list (struct-map item :name "Aged Brie" :quality 4 :sell_in 10))))))))
  (testing "quality should drop twice as fast if expired"
    (is (= 8 (:quality (first (update_quality (list (struct-map item :name "Item 3" :quality 10 :sell_in -4)))))))))

