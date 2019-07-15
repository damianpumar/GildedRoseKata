package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : this.items) {
            if (isSulfuras(item)) continue;

            ItemCategory itemCategory;

            if (isBackStage(item)) {
                itemCategory = new BackStageCategory();
            } else if (isAgedBrie(item)) {
                itemCategory = new AgedBrieCategory();
            } else {
                itemCategory = new RegularCategory();
            }

            itemCategory.calculateQuality(item);
        }
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