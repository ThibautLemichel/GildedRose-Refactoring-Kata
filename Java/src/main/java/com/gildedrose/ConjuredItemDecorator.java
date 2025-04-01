package com.gildedrose;

public class ConjuredItemDecorator extends ItemDecorator{
    public ConjuredItemDecorator(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        item.updateQuality();
        item.updateQuality();
        this.quality = item.quality;
        this.sellIn = item.sellIn;
    }
}
