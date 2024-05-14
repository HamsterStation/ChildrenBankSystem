package com.VirtualChildBank.model;

import java.time.LocalDateTime;

public class Transaction {
    private String accountId; // 账户ID
    private double amount; // 交易金额
    private LocalDateTime timestamp; // 交易时间
    private String type; // 交易类型，如 "deposit" 或 "withdraw"

    public Transaction(String accountId, double amount, String type) {
        this.accountId = accountId;
        this.amount = amount;
        this.timestamp = LocalDateTime.now(); // 获取当前时间
        this.type = type;
    }
    public Transaction() {
    }

    // Getter 和 Setter 方法
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
