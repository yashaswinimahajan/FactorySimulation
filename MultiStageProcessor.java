package com.Factory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

	public class MultiStageProcessor {
	    private static final int NUM_STAGES = 3;
	    private final ExecutorService executorService;
	    private final PriorityBlockingQueue<Item>[] stages;
	    private final AtomicInteger itemsProcessed;

	    public MultiStageProcessor() {
	        this.executorService = Executors.newFixedThreadPool(NUM_STAGES);
	        this.stages = new PriorityBlockingQueue[NUM_STAGES];
	        this.itemsProcessed = new AtomicInteger(0);
	        for (int i = 0; i < NUM_STAGES; i++) {
	            stages[i] = new PriorityBlockingQueue<>(10, (a, b) -> Integer.compare(b.getPriority(), a.getPriority()));
	        }
	    }

	    public void addItem(Item item) {
	        stages[0].add(item);
	    }

	    public void startProcessing() {
	        for (int i = 0; i < NUM_STAGES; i++) {
	            int stageIndex = i;
	            executorService.submit(() -> {
	                while (true) {
	                    try {
	                        Item item = stages[stageIndex].take();
	                        processItem(item, stageIndex);
	                        if (stageIndex < NUM_STAGES - 1) {
	                            item.setStage(stageIndex + 1);
	                            stages[stageIndex + 1].put(item);
	                        } else {
	                            itemsProcessed.incrementAndGet();
	                        }
	                    } catch (InterruptedException e) {
	                        Thread.currentThread().interrupt();
	                    }
	                }
	            });
	        }
	    }

	    private void processItem(Item item, int stageIndex) {
	        System.out.println("Processing item " + item.getItemId() + " at stage " + stageIndex);
	        // Simulate processing time
	        try {
	            Thread.sleep(100);
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	    }

	    public int getItemsProcessed() {
	        return itemsProcessed.get();
	    }

	    public void shutdown() {
	        executorService.shutdown();
	    }
	}






