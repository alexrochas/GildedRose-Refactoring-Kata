(ns gildedrose-refactoring-kata.core)

(def item (create-struct :quality :sell_in))

(defn update_quality
  "update quality of a list of items"
  [items]
  (map #(update % :quality dec) items))
