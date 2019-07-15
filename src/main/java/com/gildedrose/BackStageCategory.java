package com.gildedrose;

public class BackStageCategory extends ItemCategory {
    @Override
    public void calculateQuantity(Item item) {
        if (item.sellIn < 11) {
            increaseQuality(item);
        }

        if (item.sellIn < 6) {
            increaseQuality(item);
        }

        increaseQuality(item);

        reduceSellIn(item);

        if (item.sellIn < MIN_SELLIN) {
            item.quality = MIN_QUALITY;
        }
    }
}
