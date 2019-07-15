package com.gildedrose;

public class RegularCategory extends ItemCategory {
    @Override
    public void calculateQuantity(Item item) {
        reduceQuality(item);

        reduceSellIn(item);

        if (item.sellIn < MIN_SELLIN) {
            reduceQuality(item);
        }
    }
}
