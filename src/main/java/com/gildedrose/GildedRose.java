package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : this.items) {
            if (isSulfuras(item)) continue;

            RegularCategory regularCategory;

            if (isBackStage(item)) {
                regularCategory = new BackStageCategory();
            } else if (isAgedBrie(item)) {
                regularCategory = new AgedBrieCategory();
            } else if (isConjured(item)) {
                regularCategory = new ConjuredCategory();
            } else {
                regularCategory = new RegularCategory();
            }

            regularCategory.calculateQuality(item);
        }
    }

    private boolean isConjured(Item item) {
        return item.name.equals("Conjured");
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private boolean isBackStage(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }
}