(ns gildedrose-refactoring-kata.core)

(def item (create-struct :name :quality :sell_in))

(defn update_quality
  "update quality in list of items"
  [items]
  (map #(
    (comp 
      (if (and (not (= (:name %) "Aged Brie")) (not (= (:name %) "Backstage passes to a TAFKAL80ETC concert"))) (
                  if (> (:quality %) 0) (
                    if (not (= (:name %) "Sulfuras, Hand of Ragnaros")) (update % :quality dec) (%)
                  ) (%)
                ) (
                  if (< (:quality %) 50) (
                    do (
                      (update % :quality inc)
                      (if (= (:name %) "Backstage passes to a TAFKAL80ETC concert") (
                        do (
                          (if (< (:sell_in %) 11) 
                            (if (< (:quality %) 50) (update % :quality inc) %) %)
                          (if (< (:sell_in %) 6) 
                            (if (< (:quality %) 50) (update % :quality inc) %) %)
                        )
                      ))
                    )
                  ) (%)
                )
      )
      (if (not (= (:name %) "Sulfuras, Hand of Ragnaros")) (update % :sell_in inc) %)
      (if (< (:sell_in %) 0) (
        if (and (not (= (:name %) "Aged Brie")) (not (= (:name %) "Backstage passes to a TAFKAL80ETC concert"))) (
          if (> (:quality %) 0) (
            if (not (= (:name %) "Sulfuras, Hand of Ragnaros")) (update % :quality dec) %
          ) (%)
        ) (if (< (:quality %) 50) (update % :quality inc) (%))) %
      )
    ) %))items)
