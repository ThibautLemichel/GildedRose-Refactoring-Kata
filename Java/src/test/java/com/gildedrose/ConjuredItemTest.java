package com.gildedrose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

class ConjuredItemTest {

    private GildedRose app;
    private Item[] items;

    @BeforeEach
    void setUp() {
        items = new Item[]{};
        app = new GildedRose(items);
    }

    @ParameterizedTest
    @MethodSource("conjuredItemsProvider")
    void testConjuredItemsQuality(String name, int sellIn, int quality, int expectedQuality) {
        items = new Item[]{ new AgedBrie(name, sellIn, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertEquals(expectedQuality, items[0].quality);
    }

    static Stream<Object[]> conjuredItemsProvider() {
        return Stream.of(
            // Conjured item: Quality degrades twice as fast
            new Object[]{"Conjured Mana Cake", 5, 20, 18},
            new Object[]{"Conjured Mana Cake", -1, 20, 16}
        );
    }
}
