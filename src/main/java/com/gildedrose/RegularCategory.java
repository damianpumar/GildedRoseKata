package com.gildedrose;

public class RegularCategory extends ItemCategory {
    @Override
    public void calculateQuality(Item item) {
        reduceQuality(item);

        reduceSellIn(item);

        if (item.sellIn < MIN_SELLIN) {
            reduceQuality(item);
        }
    }

    private void reduceQuality(Item item) {
        if (item.quality > MIN_QUALITY) {
            item.quality--;
        }
    }
}
