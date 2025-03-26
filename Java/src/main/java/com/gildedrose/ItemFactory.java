package com.gildedrose;

public class ItemFactory {
    public static Item createItem(String name, int sellIn, int quality) {
        switch (name) {
            case "Aged Brie":
                return new AgedBrie(name, sellIn, quality);
            case "Sulfuras, Hand of Ragnaros":
                return new LegendaryItem(name, sellIn, quality);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new BackstagePasses(name, sellIn, quality);
            case "Backstage passes to a GALA concert":
                return new BackstagePasses(name, sellIn, quality);
            default:
                return new DefaultItem(name, sellIn, quality);
        }
    }
}
