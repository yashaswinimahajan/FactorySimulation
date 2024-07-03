package com.Factory;
import java.util.Deque;
import java.util.LinkedList;

	public class StageQueue {
	    private Deque<Item> deque;

	    public StageQueue() {
	        this.deque = new LinkedList<>();
	    }

	    public void addItem(Item item) {
	        deque.add(item);
	    }

	    public Item removeItem() {
	        return deque.poll();
	    }

	    public boolean isEmpty() {
	        return deque.isEmpty();
	    }
	}










