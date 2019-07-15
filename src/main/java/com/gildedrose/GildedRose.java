package com.gildedrose;

class GildedRose {
    public static final int MIN_QUALITY = 0;
    public static final int MIN_SELLIN = 0;
    private final int MAX_QUALITY = 50;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : this.items) {
            if (isSulfuras(item)) {
                continue;
            } else if (isBackStage(item)) {
                increaseBackStageQuality(item);
            } else if (isAgedBrie(item)) {
                increaseAgedBrieQuality(item);
            } else {
                increaseRegularQuality(item);
            }
        }
    }

    private void increaseAgedBrieQuality(Item item) {
        increaseQuality(item);

        reduceSellIn(item);

        if (item.sellIn < MIN_SELLIN) {
            increaseQuality(item);
        }
    }

    private void increaseBackStageQuality(Item item) {
        if (item.sellIn < 11) {
            increaseQuality(item);
        }

        if (item.sellIn < 6) {
            increaseQuality(item);
        }

        increaseQuality(item);

        reduceSellIn(item);

        if (item.sellIn < MIN_SELLIN) {
            item.quality = MIN_QUALITY;
        }
    }

    private void increaseRegularQuality(Item item) {
        reduceQuality(item);

        reduceSellIn(item);

        if (item.sellIn < MIN_SELLIN) {
            reduceQuality(item);
        }
    }

    private void reduceSellIn(Item item) {
        item.sellIn--;
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