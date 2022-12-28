package org.example;

import java.util.List;
import java.util.Optional;

public class DataProcessor<T extends Tovar>{
    public List<T> filterByZena(int min, int max, List<T> list) throws Exception{

        if (max<min) throw new Exception("Максимальное значение меньше минимального");
        return list.stream()
                .filter(item -> item.zena > min && item.zena < max)
                .sorted((a, b) -> {
                    return Integer.compare((int) a.zena, (int) b.zena);
                })
                .limit(5)
                .toList();
    }

    public Optional<T> findByZena(Integer zena, List<T> list) {
        return list.stream()
                .filter(item -> item.zena == zena).findFirst();
    }
}

