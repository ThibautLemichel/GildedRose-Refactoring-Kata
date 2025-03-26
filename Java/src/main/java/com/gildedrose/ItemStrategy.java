package com.gildedrose;

public interface ItemStrategy {
    void updateQuality(Item item);
    void updateSellIn(Item item);
    void handleExpired(Item item);
}
