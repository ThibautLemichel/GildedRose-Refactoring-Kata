package com.gildedrose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

class DefaultItemTest {

    private GildedRose app;
    private Item[] items;

    @BeforeEach
    void setUp() {
        items = new Item[]{};
        app = new GildedRose(items);
    }

    @ParameterizedTest
    @MethodSource("defaultItemsProvider")
    void testDefaultItemsQuality(String name, int sellIn, int quality, int expectedQuality) {
        items = new Item[]{ new DefaultItem(name, sellIn, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertEquals(expectedQuality, items[0].quality);
    }

    static Stream<Object[]> defaultItemsProvider() {
        return Stream.of(
            // Generic item: Quality degrades twice as fast after SellIn has passed
            new Object[]{"+5 Dexterity Vest", -1, 20, 18},
            // Generic item: Quality decreases by 1 when SellIn is positive
            new Object[]{"+5 Dexterity Vest", 5, 20, 19},
            // Generic item: Quality should never be negative
            new Object[]{"Elixir of the Mongoose", 5, 0, 0}
        );
    }
}
