package com.gildedrose;

public abstract class ItemCategory {
    protected final int MIN_QUALITY = 0;
    protected final int MIN_SELLIN = 0;
    protected final int MAX_QUALITY = 50;

    public abstract void calculateQuantity(Item item);

    protected void reduceSellIn(Item item) {
        item.sellIn--;
    }

    protected void reduceQuality(Item item) {
        if (item.quality > MIN_QUALITY) {
            item.quality--;
        }
    }

    protected void increaseQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality++;
        }
    }
}
