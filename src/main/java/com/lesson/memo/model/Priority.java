package com.lesson.memo.model;

public enum Priority {
	HIGH("高"),
    MEDIUM("中"),
    LOW("低");
	private String displayName;

    Priority(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
