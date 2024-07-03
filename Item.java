package com.Factory;

public class Item {
	private String itemId;
    private int stage;
    private int priority;
    private String description;

    public Item(String itemId, int stage, int priority, String description) {
        this.itemId = itemId;
        this.stage = stage;
        this.priority = priority;
        this.description = description;
    }

    public String getItemId() {
        return itemId;
    }

    public int getStage() {
        return stage;
    }

    public int getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId='" + itemId + '\'' +
                ", stage=" + stage +
                ", priority=" + priority +
                ", description='" + description + '\'' +
                '}';
    }
}









