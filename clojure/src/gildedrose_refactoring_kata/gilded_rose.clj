(ns gildedrose-refactoring-kata.gilded_rose
  (:require [gildedrose-refactoring-kata.item :refer :all]))

(defn update_quality
  "update quality in list of items"
  [items]
  (map #((comp
          (fn [item] (if (and (not (= (:name item) "Aged Brie")) (not (= (:name item) "Backstage passes to a TAFKAL80ETC concert")))
                       (if (> (:quality item) 0)
                         (if (not (= (:name item) "Sulfuras, Hand of Ragnaros")) (update item :quality dec) (item))
                         item)
                       (if (< (:quality item) 50)
                         ((comp
                           (fn [x] (update x :quality inc))
                           (fn [x] (if (= (:name x) "Backstage passes to a TAFKAL80ETC concert")
                                     ((comp
                                       (fn [y] (if (< (:sell_in y) 11)
                                                 (if (< (:quality y) 50) (update y :quality inc) y)
                                                 y))
                                       (fn [y] (if (< (:sell_in y) 6)
                                                 (if (< (:quality y) 50) (update y :quality inc) y)
                                                 y)))
                                      x)
                                     x)))
                          item)
                         item)))
          (fn [item] (if (not (= (:name item) "Sulfuras, Hand of Ragnaros")) (update item :sell_in dec) item))
          (fn [item] (if (< (:sell_in item) 0)
                       (if (not (= (:name item) "Aged Brie"))
                         (if (and (not (= (:name item) "Aged Brie")) (not (= (:name item) "Backstage passes to a TAFKAL80ETC concert")))
                           (if (> (:quality item) 0)
                             (if (not (= (:name item) "Sulfuras, Hand of Ragnaros"))
                               (update item :quality dec)
                               item)
                             item)
                           (if (< (:quality item) 50)
                             (update item :quality inc)
                             item))
                         item)
                       item)))
         %)
       items))