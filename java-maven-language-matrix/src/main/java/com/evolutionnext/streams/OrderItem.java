package com.evolutionnext.streams;

import java.util.Objects;
import java.util.StringJoiner;

public class OrderItem {
    private final int quantity;
    private final Product product;
    private final Order order;

    public OrderItem(int quantity, Product product, Order order) {
        this.quantity = quantity;
        this.product = product;
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return quantity == orderItem.quantity &&
            product.equals(orderItem.product) &&
            order.equals(orderItem.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, product, order);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OrderItem.class.getSimpleName() + "[",
            "]")
            .add("quantity=" + quantity)
            .add("product=" + product)
            .add("order=" + order)
            .toString();
    }
}
