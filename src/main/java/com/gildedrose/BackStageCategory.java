package com.gildedrose;

public class BackStageCategory extends ItemCategory {
    private final int SIX = 6;
    private final int ELEVEN = 11;

    @Override
    public void calculateQuality(Item item) {
        if (item.sellIn < ELEVEN) {
            increaseQuality(item);
        }

        if (item.sellIn < SIX) {
            increaseQuality(item);
        }

        increaseQuality(item);

        reduceSellIn(item);

        if (item.sellIn < MIN_SELLIN) {
            item.quality = MIN_QUALITY;
        }
    }
}
