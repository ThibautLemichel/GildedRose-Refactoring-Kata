package com.gildedrose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

class AgedBrieTest {

    private GildedRose app;
    private Item[] items;

    @BeforeEach
    void setUp() {
        items = new Item[]{};
        app = new GildedRose(items);
    }

    @ParameterizedTest
    @MethodSource("agedBrieProvider")
    void testAgedBrieQuality(String name, int sellIn, int quality, int expectedQuality) {
        items = new Item[]{ new AgedBrie(name, sellIn, quality) };
        app = new GildedRose(items);

        app.updateQuality();

        assertEquals(expectedQuality, items[0].quality);
    }

    static Stream<Object[]> agedBrieProvider() {
        return Stream.of(
            // Aged Brie: Quality increases with age
            new Object[]{"Aged Brie", 5, 20, 21},
            // Aged Brie: Quality should never exceed 50
            new Object[]{"Aged Brie", 5, 50, 50}
        );
    }
}
