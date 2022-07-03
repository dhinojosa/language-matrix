package com.evolutionnext.functions;

import java.util.ArrayList;
import java.util.List;

public class Functions {

    public static <T> List<T> myFilter(List<T> list, MyPredicate<T> myPredicate) {
        ArrayList<T> result = new ArrayList<>();
        for (T t : list) {
            if (myPredicate.test(t)) result.add(t);
        }
        return result;
    }

    public static <T, R> List<R> myMap(List<T> list, MyFunction<T, R> myFunction) {
        ArrayList<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(myFunction.apply(t));
        }
        return result;
    }

    public static <T, R> List<R> myFlatMap(List<T> list, MyFunction<T, List<R>> myFunction) {
        ArrayList<R> result = new ArrayList<>();
        for (T t : list) {
            List<R> application = myFunction.apply(t);
            result.addAll(application);
        }
        return result;
    }

    public static <T> void myForEach(List<T> list, MyConsumer<T> myConsumer) {
        for (T t : list) {
            myConsumer.accept(t);
        }
    }

    public static <T> List<T> myGenerate(MySupplier<T> supplier, int count) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(supplier.get());
        }
        return result;
    }


}












