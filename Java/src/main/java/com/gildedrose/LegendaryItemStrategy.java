package com.gildedrose;

public class LegendaryItemStrategy implements ItemStrategy {
    @Override
    public void updateQuality(Item item) {
        // Sulfuras never decreases in quality
    }

    @Override
    public void updateSellIn(Item item) {
        // Sulfuras never decreases in sellIn
    }

    @Override
    public void handleExpired(Item item) {
        // Sulfuras never expires
    }
}
