package com.Factory;
import java.util.ArrayDeque;

public class SimpleStageQueue {
    private ArrayDeque<Item> arrayDeque;

    public SimpleStageQueue() {
        this.arrayDeque = new ArrayDeque<>();
    }

    public void addItem(Item item) {
        arrayDeque.add(item);
    }

    public Item removeItem() {
        return arrayDeque.poll();
    }

    public boolean isEmpty() {
        return arrayDeque.isEmpty();
    }
}















