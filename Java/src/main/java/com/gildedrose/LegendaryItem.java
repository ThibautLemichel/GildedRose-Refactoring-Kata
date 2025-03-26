package com.gildedrose;

public class LegendaryItem extends Item {
    public LegendaryItem(int sellIn, int quality) {
        super("Sulfuras, Hand of Ragnaros", sellIn, quality);
    }

    @Override
    public void updateQuality() {
        // Legendary items do not change in quality
    }
}
