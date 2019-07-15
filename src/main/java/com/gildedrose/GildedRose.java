package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : this.items) {
            if (!isAgedBrie(item) && !isBackStage(item)) {
                if (!isSulfuras(item)) {
                    reduceQuality(item);
                }
            } else {
                if (item.quality < 50) {
                    increaseQuality(item);

                    if (isBackStage(item)) {
                        if (item.sellIn < 11) {
                            increaseQuality(item);
                        }

                        if (item.sellIn < 6) {
                            increaseQuality(item);
                        }
                    }
                }
            }

            if (!isSulfuras(item)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!isAgedBrie(item)) {
                    if (!isBackStage(item)) {
                        if (!isSulfuras(item)) {
                            reduceQuality(item);
                        }
                    } else {
                        item.quality = item.quality - item.quality;
                    }
                } else {
                    increaseQuality(item);
                }
            }
        }

    }

    private void reduceQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
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