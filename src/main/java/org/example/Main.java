package org.example;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws Exception {
            List<Tovar> tovars = List.of(
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
            );

            List<Prodavez> prodavezs = List.of(
                    new Prodavez(1, "Дмитрий"),
                    new Prodavez(2, "Олег")
            );


            DataProcessor<Tovar> dataProcessor = new DataProcessor<>();

            List<Tovar> filteredList = dataProcessor.filterByZena(15, 25, tovars);
            Optional<Tovar> SearchResults = dataProcessor.findByZena(11, tovars);
            System.out.println("Сортировка:");
            for (Tovar item : filteredList) {
                item.print();
            }
            System.out.println("Поиск:");
            SearchResults.ifPresent(Tovar::print);
            System.out.println("----------------------");
        }
    }
