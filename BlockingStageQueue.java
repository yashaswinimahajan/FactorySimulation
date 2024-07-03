package com.Factory;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

	public class BlockingStageQueue {
	    private BlockingDeque<Item> blockingDeque;

	    public BlockingStageQueue() {
	        this.blockingDeque = new LinkedBlockingDeque<>();
	    }

	    public void addItem(Item item) throws InterruptedException {
	        blockingDeque.put(item);
	    }

	    public Item removeItem() throws InterruptedException {
	        return blockingDeque.take();
	    }

	    public boolean isEmpty() {
	        return blockingDeque.isEmpty();
	    }
	}





