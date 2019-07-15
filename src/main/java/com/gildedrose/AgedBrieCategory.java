package com.gildedrose;

public class AgedBrieCategory extends ItemCategory {
    @Override
    public void calculateQuantity(Item item) {
        increaseQuality(item);

        reduceSellIn(item);

        if (item.sellIn < MIN_SELLIN) {
            increaseQuality(item);
        }
    }
}
