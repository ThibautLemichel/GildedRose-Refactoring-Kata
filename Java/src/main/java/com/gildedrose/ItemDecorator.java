package com.gildedrose;

public abstract class ItemDecorator extends Item {
    protected Item item;

    public ItemDecorator(Item item) {
        super(item.name, item.sellIn, item.quality);
        this.item = item;
    }

    @Override
    public abstract void updateQuality();
}
