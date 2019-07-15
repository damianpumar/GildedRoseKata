package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GildedRoseShould {

    @Test
    public void quality_never_is_negative() {
        GildedRose gildedRose = new GildedRose(itemsBuilder("foo", 0, 0));
        gildedRose.updateQuality();

        assertTrue(gildedRose.items[0].quality >= 0);
    }

    @Test
    public void increase_quality_when_item_is_Aged_Brie() {
        final int QUALITY = 5;
        GildedRose gildedRose = new GildedRose(itemsBuilder("Aged Brie", 2, QUALITY));
        gildedRose.updateQuality();

        assertEquals(QUALITY + 1, gildedRose.items[0].quality);
    }

    @Test
    public void quality_is_never_more_than_50() {
        GildedRose gildedRose = new GildedRose(itemsBuilder("Aged Brie", 0, 50));
        gildedRose.updateQuality();

        assertTrue(gildedRose.items[0].quality <= 50);
    }

    @Test
    public void sulfuras_item_always_has_quality_80() {
        final int QUALITY = 80;
        GildedRose gildedRose = new GildedRose(itemsBuilder("Sulfuras, Hand of Ragnaros", 0, QUALITY));
        gildedRose.updateQuality();

        assertEquals(QUALITY, gildedRose.items[0].quality);
    }

    @Test
    public void quality_degrades_twice_as_fast_when_sell_By_date_has_passed() {
        final int QUALITY = 10;
        GildedRose gildedRose = new GildedRose(itemsBuilder("foo", 0, QUALITY));
        gildedRose.updateQuality();

        assertEquals(QUALITY - 2, gildedRose.items[0].quality);
    }

    @Test
    public void sellin_and_quality_values_reduce_by_one() {
        final int SELLIN = 2;
        final int QUALITY = 3;
        GildedRose gildedRose = new GildedRose(itemsBuilder("foo", SELLIN, QUALITY));
        gildedRose.updateQuality();

        assertEquals("Quality value", QUALITY - 1, gildedRose.items[0].quality);
        assertEquals("Sellin value", SELLIN - 1, gildedRose.items[0].sellIn);
    }

    @Test
    public void quality_increase_by_two_when_Backstate_Passes_has_10_days_to_sell() {
        final int QUALITY = 8;
        GildedRose gildedRose = new GildedRose(itemsBuilder("Backstage passes to a TAFKAL80ETC concert", 10, QUALITY));
        gildedRose.updateQuality();

        assertEquals(QUALITY + 2, gildedRose.items[0].quality);
    }

    @Test
    public void quality_increase_by_two_when_Backstate_Passes_has_6_days_to_sell() {
        final int QUALITY = 8;
        GildedRose gildedRose = new GildedRose(itemsBuilder("Backstage passes to a TAFKAL80ETC concert", 6, QUALITY));
        gildedRose.updateQuality();

        assertEquals(QUALITY + 2, gildedRose.items[0].quality);
    }

    @Test
    public void quality_increase_by_three_when_Backstate_Passes_has_5_days_to_sell() {
        final int QUALITY = 8;
        GildedRose gildedRose = new GildedRose(itemsBuilder("Backstage passes to a TAFKAL80ETC concert", 5, QUALITY));
        gildedRose.updateQuality();

        assertEquals(QUALITY + 3, gildedRose.items[0].quality);
    }

    @Test
    public void quality_increase_by_three_when_Backstate_Passes_has_1_days_to_sell() {
        final int QUALITY = 8;
        GildedRose gildedRose = new GildedRose(itemsBuilder("Backstage passes to a TAFKAL80ETC concert", 1, QUALITY));
        gildedRose.updateQuality();

        assertEquals(QUALITY + 3, gildedRose.items[0].quality);
    }

    @Test
    public void quality_is_zero_after_the_concert() {
        GildedRose gildedRose = new GildedRose(itemsBuilder("Backstage passes to a TAFKAL80ETC concert", 0, 8));
        gildedRose.updateQuality();

        assertEquals(0, gildedRose.items[0].quality);
    }

    @Test
    public void calculate_and_iterate_for_each_item() {
        Item sulfura = itemBuilder("Sulfuras, Hand of Ragnaros", 0, 80);
        Item backStage = itemBuilder("Backstage passes to a TAFKAL80ETC concert", 0, 8);

        GildedRose gildedRose = new GildedRose(new Item[]{sulfura, backStage});
        gildedRose.updateQuality();

        assertTrue(gildedRose.items[0].quality == 80);

        assertTrue(gildedRose.items[1].quality == 0);
    }

    @Test
    public void degrade_quality_twice_as_fast_as_regular_item() {
        GildedRose gildedRose = new GildedRose(itemsBuilder("Conjured", 2, 8));

        assertEquals(6, gildedRose.items[0].quality);
    }

    private Item[] itemsBuilder(String name, int sellIn, int quality) {
        return new Item[]{itemBuilder(name, sellIn, quality)};
    }

    private Item itemBuilder(String name, int sellIn, int quality) {
        return new Item(name, sellIn, quality);
    }
}
