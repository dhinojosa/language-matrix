package com.evolutionnext.generics.subclassing;

public class MySafeNode<T> extends Node<T> {

    public MySafeNode(T data) {
        super(data);
    }

    public void setData(T data) {
        if (data == null) throw new NullPointerException("data is null");
        super.setData(data);
    }
}
