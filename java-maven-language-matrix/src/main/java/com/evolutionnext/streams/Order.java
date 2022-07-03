package com.evolutionnext.streams;

import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class Order {

    private final String firstName;
    private final String lastName;
    private final String city;
    private final String state;
    private final List<OrderItem> orderItems;

    public Order(String firstName, String lastName, String city, String state) {
        this(firstName, lastName, city, state, List.of());
    }

    public Order(String firstName, String lastName,
                 String city, String state,
                 List<OrderItem> orderItems) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.state = state;
        this.orderItems = orderItems;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Order addOrderItems(List<OrderItem> orderItems) {
        return new Order(firstName, lastName, city, state, orderItems);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return firstName.equals(order.firstName) &&
            lastName.equals(order.lastName) &&
            city.equals(order.city) &&
            state.equals(order.state) &&
            orderItems.equals(order.orderItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, city, state, orderItems);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Order.class.getSimpleName() + "[", "]")
            .add("firstName='" + firstName + "'")
            .add("lastName='" + lastName + "'")
            .add("city='" + city + "'")
            .add("state='" + state + "'")
            .add("orderItems=" + orderItems)
            .toString();
    }
}
