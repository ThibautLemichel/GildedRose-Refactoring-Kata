package com.gildedrose;

public class AgedBrieStrategy implements ItemStrategy {
    @Override
    public void updateQuality(Item item) {
        increaseQuality(item);
    }

    @Override
    public void updateSellIn(Item item) {
        item.sellIn--;
    }

    @Override
    public void handleExpired(Item item) {
        if (item.sellIn < 0) {
            increaseQuality(item);
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }
}
