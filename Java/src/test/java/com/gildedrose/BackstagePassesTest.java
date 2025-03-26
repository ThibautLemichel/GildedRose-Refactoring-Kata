package com.gildedrose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

class BackstagePassesTest {

    private GildedRose app;
    private Item[] items;

    @BeforeEach
    void setUp() {
        items = new Item[]{};
        app = new GildedRose(items);
    }

    @ParameterizedTest
    @MethodSource("backstagePassesProvider")
    void testBackstagePassesQuality(String name, int sellIn, int quality, int expectedQuality) {
        items = new Item[]{ new Item(name, sellIn, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertEquals(expectedQuality, items[0].quality);
    }

    static Stream<Object[]> backstagePassesProvider() {
        return Stream.of(
            // Quality increases by 3 when SellIn is 5 days or less
            new Object[]{"Backstage passes to a TAFKAL80ETC concert", 5, 20, 23},
            // Quality increases by 2 when SellIn is 10 days or less
            new Object[]{"Backstage passes to a TAFKAL80ETC concert", 10, 20, 22},
            // Quality increases by 1 when SellIn is more than 10 days
            new Object[]{"Backstage passes to a TAFKAL80ETC concert", 15, 20, 21},
            // Quality drops to 0 after the concert
            new Object[]{"Backstage passes to a TAFKAL80ETC concert", -1, 20, 0},
            // Quality should never exceed 50
            new Object[]{"Backstage passes to a TAFKAL80ETC concert", 5, 48, 50},
            new Object[]{"Backstage passes to a TAFKAL80ETC concert", 10, 49, 50},
            new Object[]{"Backstage passes to a TAFKAL80ETC concert", 11, 50, 50}
        );
    }
}
