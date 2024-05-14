package com.VirtualChildBank.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private String goal;
    private List<Account> accounts;
    private List<Task> tasks;
    private double totalBalance;
    private List<Transaction> transactions;


    public User(String username, String password) {
        this.username = username; 
        this.password = password;
        this.accounts = new ArrayList<>();
        this.goal = "";
        this.tasks = new ArrayList<>();
        this.totalBalance =0.0;
        this.transactions = new ArrayList<>();
    }

    public User(String username, String password, List<Account> accounts, String goal, List<Task> tasks, Double totalBalance, List<Transaction> transactions) {
        this.username = username;
        this.password = password;
        this.accounts = accounts != null ? new ArrayList<>(accounts) : new ArrayList<>();
        this.goal = goal;
        this.tasks = tasks != null ? new ArrayList<>(tasks) : new ArrayList<>();
        this.totalBalance = totalBalance != null ? totalBalance : 0.0;
        this.transactions = transactions != null ? new ArrayList<>(transactions) : new ArrayList<>();
        calculateTotalBalance();  // 初始化时计算总余额
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }


    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public  double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(Double totalBalance) {
        this.totalBalance = totalBalance;
    }
    // 计算并更新总余额
    public void calculateTotalBalance() {
        totalBalance = 0.0;  // 重置总余额
        for (Account account : accounts) {
            totalBalance += account.getBalance();
        }
    }
}
