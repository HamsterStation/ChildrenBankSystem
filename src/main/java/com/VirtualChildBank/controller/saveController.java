package com.VirtualChildBank.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import com.VirtualChildBank.model.Account;
import com.VirtualChildBank.model.User;
import com.VirtualChildBank.service.UserService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import static com.VirtualChildBank.VirtualChildBankApp.*;

public class saveController {
    @FXML
    private TableView<Account> accountTableView;
    @FXML
    private TableColumn<Account, String> accountIdColumn;
    @FXML
    private TableColumn<Account, Double> balanceColumn;
    @FXML
    private TableColumn<Account, String> accountTypeColumn;

    private UserService userService = new UserService();
    private Account selectedAccount; // 新增存储选中的账户

    @FXML
    public void initialize() {
        accountIdColumn.setCellValueFactory(new PropertyValueFactory<>("accountId"));
        balanceColumn.setCellValueFactory(new PropertyValueFactory<>("balance"));
        accountTypeColumn.setCellValueFactory(new PropertyValueFactory<>("accountType"));

        User currentUser = userService.getCurrentUser();
        if (currentUser != null) {
            accountTableView.setItems(FXCollections.observableList(currentUser.getAccounts()));
        }

        accountTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                selectedAccount = newSelection;
            }
        });
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
    void onSelectAction(MouseEvent event) {
        Account selectedAccount = accountTableView.getSelectionModel().getSelectedItem();
        if (selectedAccount != null) {
            // 根据账户类型决定加载哪个FXML文件
            String fxmlPath = selectedAccount.getAccountType().equals("saving") ? "/fxml/savingSave.fxml" : "/fxml/currentSave.fxml";
            try {
                // 调用重载的changeView方法并获取控制器
                Object controller = changeView(fxmlPath, true);

                // 假设控制器有一个方法setAccount来设置账户信息
                if (controller instanceof savingSaveController && "saving".equals(selectedAccount.getAccountType())) {
                    ((savingSaveController) controller).setAccount(selectedAccount);
                } else if (controller instanceof currentSaveController && "current".equals(selectedAccount.getAccountType())) {
                    ((currentSaveController) controller).setAccount(selectedAccount);
                }

            } catch (Exception e) {
                e.printStackTrace(); // 打印错误信息
                System.out.println("Failed to load the view.");
            }
        } else {
            System.out.println("No account selected.");
        }
    }




}
