package com.gildedrose;

public class ItemFactory {
    public static Item createItem(String name, int sellIn, int quality) {
        Item item = null;
        switch (name) {
            case "Aged Brie":
                item = new AgedBrie(name, sellIn, quality);
            case "Sulfuras, Hand of Ragnaros":
                item = new LegendaryItem(name, sellIn, quality);
            case "Backstage passes to a TAFKAL80ETC concert":
                item = new BackstagePasses(name, sellIn, quality);
            case "Backstage passes to a GALA concert":
                item = new BackstagePasses(name, sellIn, quality);
            default:
                item = new DefaultItem(name, sellIn, quality);
        }
        if (name.startsWith("Conjured")) {
            item = new ConjuredItemDecorator(item);
        }
        return item;
    }
}
