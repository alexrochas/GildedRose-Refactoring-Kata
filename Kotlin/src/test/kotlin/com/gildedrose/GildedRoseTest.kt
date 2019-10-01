package com.gildedrose

import org.junit.Assert.*
import org.junit.Test

class GildedRoseTest {

    @Test
    fun `quality should reduce by one every day before expire`() {
        val items = arrayOf<Item>(Item("foo", 4, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].quality)
    }

    @Test
    fun `quality should reduce twice as fast when past sell in`() {
        val items = arrayOf<Item>(Item("foo", -2, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(8, app.items[0].quality)
    }

    @Test
    fun `quality should not be negative`() {
        val items = arrayOf<Item>(Item("foo", -2, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun `Sulfuras don't need SellIn and don't decrease quality with time`() {
        val items = arrayOf<Item>(Item("Sulfuras, Hand of Ragnaros", -999, 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(80, app.items[0].quality)
    }

    @Test
    fun `Backstage Passes should rise it's quality by 2 if SellIn is equal or lower than 10 days`() {
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 9, 20))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(22, app.items[0].quality)
    }

    @Test
    fun `Backstage Passes should rise it's quality by 3 if SellIn is equal or lower than 5 days`() {
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 4, 20))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(23, app.items[0].quality)
    }

    @Test
    fun `Backstage Passes should drops quality to 0 if expired`() {
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", -4, 20))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun `Items conjured drop quality twice as fast`() {
         val items = arrayOf<Item>(Item("Conjured item", 5, 19))
         val app = GildedRose(items)
         app.updateQuality()
         assertEquals(17, app.items[0].quality)
    }
}


