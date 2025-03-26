package com.gildedrose;

public class DefaultItemStrategy implements ItemStrategy {
    @Override
    public void updateQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    @Override
    public void updateSellIn(Item item) {
        item.sellIn--;
    }

    @Override
    public void handleExpired(Item item) {
        if (item.sellIn < 0 && item.quality > 0) {
            item.quality--;
        }
    }
}
