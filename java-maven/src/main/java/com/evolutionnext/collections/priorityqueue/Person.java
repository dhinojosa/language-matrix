package com.evolutionnext.collections.priorityqueue;

import java.util.Objects;

record Person(String firstName, String lastName){
    Person {
        Objects.requireNonNull(firstName, "Requires firstName");
        Objects.requireNonNull(lastName, "Requires lastName");
    }
}
