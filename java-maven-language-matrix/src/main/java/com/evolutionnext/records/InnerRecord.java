package com.evolutionnext.records;

import java.util.List;

public class InnerRecord {

    public static void main(String[] args) {
        record Car(String make, String model, List<String> features){}
        List<Car> cars = List.of(
            new Car("Ford", "Focus", List.of()),
            new Car("Mercedes Benz", "G-Class", List.of("Expensive"))
        );

        cars.stream().map(c -> c.model).forEach(System.out::println);
    }
}
