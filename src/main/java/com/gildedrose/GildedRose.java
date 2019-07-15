package com.gildedrose;

class GildedRose {
    public static final int MIN_QUALITY = 0;
    private final int MAX_QUALITY = 50;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : this.items) {
            if (isSulfuras(item)) {
                continue;
            }

            if (!isAgedBrie(item) && !isBackStage(item)) {
                reduceQuality(item);
            } else {
                if (item.quality < MAX_QUALITY) {
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

            item.sellIn = item.sellIn - 1;

            if (item.sellIn < 0) {
                if (!isAgedBrie(item)) {
                    if (!isBackStage(item)) {
                        reduceQuality(item);
                    } else {
                        item.quality = MIN_QUALITY;
                    }
                } else {
                    increaseQuality(item);
                }
            }
        }
    }

    private void reduceQuality(Item item) {
        if (item.quality > MIN_QUALITY) {
            item.quality--;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
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