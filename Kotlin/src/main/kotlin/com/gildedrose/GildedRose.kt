package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() = items.forEach { item ->
        item.takeIf { it.name != "Sulfuras, Hand of Ragnaros" }?.apply { sellIn -= 1 }

        when {
            item.name.startsWith("Conjured") -> item.decreaseQualityBy(2)
            item.sellIn < 0 && item.name == "Backstage passes to a TAFKAL80ETC concert" -> item.quality = 0
            item.name == "Backstage passes to a TAFKAL80ETC concert" && item.sellIn < 6 -> item.increaseQualityBy(3)
            item.name == "Backstage passes to a TAFKAL80ETC concert" && item.sellIn < 11 -> item.increaseQualityBy(2)
            item.name == "Backstage passes to a TAFKAL80ETC concert" -> item.increaseQualityBy(1)
            item.name == "Aged Brie" -> item.increaseQualityBy(1)
            item.name == "Sulfuras, Hand of Ragnaros" -> item.quality = item.quality
            item.sellIn < 0 -> item.decreaseQualityBy(2)
            else -> item.decreaseQualityBy(1)
        }
    }
}

fun Item.decreaseQualityBy(decreaseFactor: Int) {
    this.quality.takeIf { decreaseFactor > 0 && (this.quality - decreaseFactor) >= 0 }
            ?.also {
                this.quality -= decreaseFactor
            }
}

fun Item.increaseQualityBy(increaseFactor: Int) {
    this.quality.takeIf { increaseFactor > 0 && (this.quality + increaseFactor) <= 50 }
            ?.also {
                this.quality += increaseFactor
            }
}
