package com.VirtualChildBank.controller;

import com.VirtualChildBank.model.Transaction;
import com.VirtualChildBank.service.UserService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import java.time.format.DateTimeFormatter;
import javafx.beans.property.SimpleStringProperty;

import static com.VirtualChildBank.VirtualChildBankApp.close;
import static com.VirtualChildBank.VirtualChildBankApp.goBack;

public class transactionController {

    @FXML
    private TableView<Transaction> transactionTableView;
    @FXML
    private TableColumn<Transaction, String> accountIdColumn;
    @FXML
    private TableColumn<Transaction, Double> amountColumn;
    @FXML
    private TableColumn<Transaction, String> timeColumn;
    @FXML
    private TableColumn<Transaction, String> typeColumn;

    private UserService userService;



    @FXML
    public void initialize() {
        System.out.println("Initializing transaction controller.");
        accountIdColumn.setCellValueFactory(new PropertyValueFactory<>("accountId"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        timeColumn.setCellValueFactory(cellData -> new SimpleStringProperty(
                cellData.getValue().getTimestamp().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        userService = new UserService();
        // 调用loadTransactions以测试是否有数据问题
        loadTransactions();
    }

    private void loadTransactions() {
        if (userService != null && userService.getCurrentUser() != null) {
            System.out.println("Loading transactions...");
            if (!userService.getCurrentUser().getTransactions().isEmpty()) {
                transactionTableView.setItems(FXCollections.observableArrayList(userService.getCurrentUser().getTransactions()));
                System.out.println("Transactions loaded: " + userService.getCurrentUser().getTransactions().size());
            } else {
                System.out.println("No transactions to display.");
            }
        } else {
            System.out.println("UserService or currentUser is null.");
        }
    }

    @FXML
    void onBackAction(MouseEvent event) {
        goBack();
    }

    @FXML
    void onCloseAction(MouseEvent event) {
        close();
    }
}
