package com.gildedrose;

public class RegularCategory {
    protected final int MIN_QUALITY = 0;
    protected final int MIN_SELLIN = 0;
    protected final int MAX_QUALITY = 50;

    public void calculateQuality(Item item) {
        reduceQuality(item);

        reduceSellIn(item);

        if (item.sellIn < MIN_SELLIN) {
            reduceQuality(item);
        }
    }

    protected void reduceSellIn(Item item) {
        item.sellIn--;
    }

    protected void increaseQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality++;
        }
    }

    protected void reduceQuality(Item item) {
        if (item.quality > MIN_QUALITY) {
            item.quality--;
        }
    }
}
