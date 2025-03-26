package com.gildedrose;

public class BackstagePasses extends Item {
    public BackstagePasses(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (sellIn > 10) {
            quality += 2;
        } else if (sellIn > 5) {
            quality += 3;
        } else if (sellIn >= 0) {
            quality += 4;
        } else {
            quality = 0;
        }
        if (quality > 50) {
            quality = 50;
        }
        sellIn--;
    }
}
