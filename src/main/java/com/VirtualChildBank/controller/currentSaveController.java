package com.VirtualChildBank.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.VirtualChildBank.model.Account;
import com.VirtualChildBank.model.Transaction;
import com.VirtualChildBank.service.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import static com.VirtualChildBank.VirtualChildBankApp.*;

public class currentSaveController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField currentSaveMoney;

    private Account selectedAccount; // 新增字段

    private UserService userService = new UserService();

    public void setAccount(Account account) {
        this.selectedAccount = account;
    }



    @FXML
    void onBackAction(MouseEvent event) {
        goBack();
    }

    @FXML
    void onCloseAction(MouseEvent event) {
        close();
    }

    @FXML
    void onSaveCurrentMoneyAction(MouseEvent event) {
        try {
            double amount = Double.parseDouble(currentSaveMoney.getText());
            if (selectedAccount != null) {
                selectedAccount.setBalance(selectedAccount.getBalance() + amount);
                Transaction transaction = new Transaction(selectedAccount.getAccountId(), amount, "deposit");
                userService.getCurrentUser().addTransaction(transaction);
                userService.updateUserAndRecalculateBalance(userService.getCurrentUser()); // 更新用户信息并重新计算总余额
                System.out.println("Money saved successfully. New Balance: " + selectedAccount.getBalance() + ", Total Balance: " + userService.getCurrentUser().getTotalBalance());
                changeView("/fxml/succeedToSave.fxml");
            } else {
                System.out.println("No account selected");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount");
        }
    }


    @FXML
    void initialize() {
        // 其他初始化代码
    }
}
