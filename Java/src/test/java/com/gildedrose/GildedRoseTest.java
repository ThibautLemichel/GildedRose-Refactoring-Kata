package com.gildedrose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

public class GildedRoseTest {

    private GildedRose app;
    private Item[] items;

    @BeforeEach
    void setUp() {
        items = new Item[]{};
        app = new GildedRose(items);
    }

    @ParameterizedTest
    @MethodSource("itemProvider")
    void updateQualityDifferentItemsReturnsExpectedQuality(String name, int sellIn, int quality, int expectedQuality) {
        items = new Item[]{ new Item(name, sellIn, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertEquals(expectedQuality, items[0].quality);
    }

    static Stream<Object[]> itemProvider() {
        return Stream.of(
            // Legendary item: Quality should never decrease
            new Object[]{"Sulfuras, Hand of Ragnaros", 10, 35, 35},
            new Object[]{"Sulfuras, Hand of Ragnaros", 5, 80, 80},
            // Aged Brie: Quality increases with age
            new Object[]{"Aged Brie", 5, 20, 21},
            // Aged Brie: Quality should never exceed 50
            new Object[]{"Aged Brie", 5, 50, 50},
            // Backstage passes: Quality increases by 3 when SellIn is 5 days or less
            new Object[]{"Backstage passes to a TAFKAL80ETC concert", 5, 20, 23},
            // Backstage passes: Quality increases by 2 when SellIn is 10 days or less
            new Object[]{"Backstage passes to a TAFKAL80ETC concert", 10, 20, 22},
            // Backstage passes: Quality increases by 1 when SellIn is more than 10 days
            new Object[]{"Backstage passes to a TAFKAL80ETC concert", 15, 20, 21},
            // Backstage passes: Quality drops to 0 after the concert
            new Object[]{"Backstage passes to a TAFKAL80ETC concert", -1, 20, 0},
            // Backstage passes: Quality should never exceed 50
            new Object[]{"Backstage passes to a TAFKAL80ETC concert", 5, 48, 50},
            new Object[]{"Backstage passes to a TAFKAL80ETC concert", 10, 49, 50},
            new Object[]{"Backstage passes to a TAFKAL80ETC concert", 11, 50, 50},
            // Generic item: Quality degrades twice as fast after SellIn has passed
            new Object[]{"+5 Dexterity Vest", -1, 20, 18},
            // Generic item: Quality decreases by 1 when SellIn is positive
            new Object[]{"+5 Dexterity Vest", 5, 20, 19},
            // Generic item: Quality should never be negative
            new Object[]{"Elixir of the Mongoose", 5, 0, 0},
            // Conjured item: Quality degrades twice as fast
            new Object[]{"Conjured Mana Cake", 5, 20, 18},
            new Object[]{"Conjured Mana Cake", -1, 20, 16}

        );
    }
}
