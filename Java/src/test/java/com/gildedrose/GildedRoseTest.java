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
            new Object[]{"Sulfuras, Hand of Ragnaros", 10, 35, 35},
            new Object[]{"Sulfuras, Hand of Ragnaros", 5, 80, 80}
        );
    }
}
