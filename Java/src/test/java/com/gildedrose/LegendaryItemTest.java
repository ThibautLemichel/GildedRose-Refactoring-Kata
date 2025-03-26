package com.gildedrose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

class LegendaryItemTest {

    private GildedRose app;
    private Item[] items;

    @BeforeEach
    void setUp() {
        items = new Item[]{};
        app = new GildedRose(items);
    }

    @ParameterizedTest
    @MethodSource("legendaryItemsProvider")
    void testLegendaryItemQuality(String name, int sellIn, int quality, int expectedQuality) {
        items = new Item[]{ new Item(name, sellIn, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertEquals(expectedQuality, items[0].quality);
        // For legendary items like "Sulfuras", the sellIn should also remain the same:
        assertEquals(sellIn, items[0].sellIn);
    }

    static Stream<Object[]> legendaryItemsProvider() {
        return Stream.of(
            // Legendary item: Quality should never decrease
            new Object[]{"Sulfuras, Hand of Ragnaros", 10, 35, 35},
            new Object[]{"Sulfuras, Hand of Ragnaros", 5, 80, 80}
        );
    }
}
