package com.gildedrose;

public class AgedBrieCategory extends RegularCategory {
    @Override
    public void calculateQuality(Item item) {
        increaseQuality(item);

        reduceSellIn(item);

        if (item.sellIn < MIN_SELLIN) {
            increaseQuality(item);
        }
    }
}
