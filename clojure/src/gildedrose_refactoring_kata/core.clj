(ns gildedrose-refactoring-kata.core)

(def item (create-struct :quality :sell_in))

(defn update_quality
  "update quality in list of items"
  [items]
  (map #(if (< (:sell_in %) 0) 
      (update % :quality - 2)
      (update % :quality dec)
    ) items))
