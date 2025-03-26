package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

class GildedRose {
    Item[] items;
    private Map<String, ItemStrategy> strategies;

    public GildedRose(Item[] items) {
        this.items = items;
        strategies = new HashMap<>();
        strategies.put("Aged Brie", new AgedBrieStrategy());
        strategies.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassesStrategy());
        strategies.put("Sulfuras, Hand of Ragnaros", new LegendaryItemStrategy());
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemStrategy strategy = strategies.getOrDefault(item.name, new DefaultItemStrategy());
            strategy.updateQuality(item);
            strategy.updateSellIn(item);
            strategy.handleExpired(item);
        }
    }
}
