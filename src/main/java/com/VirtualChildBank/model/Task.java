package com.VirtualChildBank.model;

public class Task {
    String taskContent;
    double taskPrice;

    public Task(String taskContent, double taskPrice) {
        this.taskContent = taskContent;
        this.taskPrice = taskPrice;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }

    public double getTaskPrice() {
        return taskPrice;
    }

    public void setTaskPrice(double taskPrice) {
        this.taskPrice = taskPrice;
    }
}
