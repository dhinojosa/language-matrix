package com.evolutionnext.httpclient;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.StringJoiner;

public class Fruit {
    private String name;
    private String description;

    @JsonCreator
    public Fruit(@JsonProperty("name")String name, @JsonProperty("description")String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return Objects.equals(name, fruit.name) &&
            Objects.equals(description, fruit.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Fruit.class.getSimpleName() + "[", "]")
            .add("name='" + name + "'")
            .add("description='" + description + "'")
            .toString();
    }
}
