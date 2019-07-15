package com.gildedrose;

public abstract class ItemCategory {
    protected final int MIN_QUALITY = 0;
    protected final int MIN_SELLIN = 0;
    protected final int MAX_QUALITY = 50;

    public abstract void calculateQuality(Item item);

    protected void reduceSellIn(Item item) {
        item.sellIn--;
    }

    protected void increaseQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality++;
        }
    }
}
