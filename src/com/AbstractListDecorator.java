package com;

import java.util.List;

public abstract class AbstractListDecorator<T> {
    protected List<T> list;

    public abstract boolean add(T arg);

    public AbstractListDecorator(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {

        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
