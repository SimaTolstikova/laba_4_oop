package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class DataProcessorTest {
    private final DataProcessor<Tovar> dataProcessor = new DataProcessor<>();
    private final List<Tovar> tovars = new ArrayList<>(Arrays.asList(
            new Tovar(1, 1, 15),
            new Tovar(2, 2.3, 13.3),
            new Tovar(3, 4.0, 18.1),
            new Tovar(4, 0.1, 11.0),
            new Tovar(5, 5.5, 67.0),
            new Tovar(6, 10.0, 23.0),
            new Tovar(7, 213.0, 11.1),
            new Tovar(8, 2.0, 18.1),
            new Tovar(9, 3.4, 12.1),
            new Tovar(10, 0.1, 23.3),
            new Present(11, 20),
            new Present(12, 356)
    ));

    @DisplayName("Проверка фильтрации")
    @org.junit.jupiter.api.Test
    void filterByZena() throws Exception {
        List<Tovar> filteredList = dataProcessor.filterByZena(15, 25,tovars);

        assertEquals(4, filteredList.size());
        assertEquals(18.1, filteredList.get(0).zena);
        assertEquals(18.1, filteredList.get(1).zena);
        assertEquals(23, filteredList.get(2).zena);
        assertEquals(23.3, filteredList.get(3).zena);
    }

    @DisplayName("Проверка поиска")
    @org.junit.jupiter.api.Test
    void findByZena() {
        var searchResultFalse = dataProcessor.findByZena(5, tovars);
        var searchResultTrue = dataProcessor.findByZena(23, tovars);
        Optional<Tovar> searchResultEmpty = dataProcessor.findByZena(5, new ArrayList<>());

        assertFalse(searchResultEmpty.isPresent());
        assertFalse(searchResultFalse.isPresent());
        assertTrue(searchResultTrue.isPresent());
        assertEquals(6, searchResultTrue.get().indif);
    }
    @Test
    void filterException() {
        assertThrows(Exception.class, () -> dataProcessor.filterByZena(30, 10, tovars));
    }
}