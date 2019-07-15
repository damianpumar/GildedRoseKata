package com.gildedrose;

public class ConjuredCategory extends RegularCategory {
    @Override
    public void calculateQuality(Item item) {
        reduceQuality(item);

        super.calculateQuality(item);
    }
}
