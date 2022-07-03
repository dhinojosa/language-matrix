package com.evolutionnext.streams;

import java.util.Objects;
import java.util.StringJoiner;

public class Product {

    private final String name;
    private final Integer price;

    public Product(String name, Integer price) {
        Objects.requireNonNull(name, "Name is null");
        Objects.requireNonNull(name, "Name is null");
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name) &&
            price.equals(product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Product.class.getSimpleName() + "[", "]")
            .add("name='" + name + "'")
            .add("price=" + price)
            .toString();
    }
}
