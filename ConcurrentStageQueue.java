package com.Factory;
import java.util.concurrent.ConcurrentLinkedDeque;

	public class ConcurrentStageQueue {
	    private ConcurrentLinkedDeque<Item> concurrentDeque;

	    public ConcurrentStageQueue() {
	        this.concurrentDeque = new ConcurrentLinkedDeque<>();
	    }

	    public void addItem(Item item) {
	        concurrentDeque.add(item);
	    }

	    public Item removeItem() {
	        return concurrentDeque.poll();
	    }

	    public boolean isEmpty() {
	        return concurrentDeque.isEmpty();
	    }
	}



