package com.xyzcorp;

import java.util.ArrayList;
import java.util.List;

public class Functions {

    public static <T> List<T> myFilter(List<T> list, MyPredicate<T> predicate) {
        ArrayList<T> result = new ArrayList<T>();
        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static <T, R> List<R> myMap(List<T> list, MyFunction<T, R> function) {
        ArrayList<R> result = new ArrayList<R>();
        for (T item : list) {
            result.add(function.apply(item));
        }
        return result;
    }

    public static <T, R> void myForEach(List<T> list, MyConsumer<T> consumer) {
        for (T item : list) {
            consumer.consume(item);
        }
    }

    public static <T> List<T> flatten(List<List<T>> list) {
        List<T> result = new ArrayList<T>();
        for (List<T> innerList : list) {
            for (T item : innerList) {
                result.add(item);
            }
        }
        return result;
    }

    public static <T, R> List<R> myFlatMap(List<T> list, MyFunction<T, List<R>> function) {
        List<List<R>> result = new ArrayList<>();
        for (T item : list) {
            result.add(function.apply(item));
        }
        return flatten(result);
    }

    public static <T> List<T> myGenerate(MySupplier<T> supplier, int count) {
        ArrayList<T> list = new ArrayList<>();
        while (count > 0) {
            list.add(supplier.get());
            count--;
        }
        return list;
    }
}
