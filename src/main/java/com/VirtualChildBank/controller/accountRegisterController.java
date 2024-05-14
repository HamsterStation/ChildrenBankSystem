package com.VirtualChildBank.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.VirtualChildBank.model.Account;
import com.VirtualChildBank.model.User;
import com.VirtualChildBank.service.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import static com.VirtualChildBank.VirtualChildBankApp.*;
import com.VirtualChildBank.util.StringUtil;



public class accountRegisterController {
    @FXML
    private TextField accountIdField;

    @FXML
    private CheckBox currentCheckBox;

    @FXML
    private CheckBox savingCheckBox;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    private UserService userService; // UserService实例

    public accountRegisterController() {
        userService = new UserService(); // 初始化UserService
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
    void onRegisterAction(MouseEvent event) {
        User currentUser = userService.getCurrentUser();

        if (currentUser != null) {
            String accountId = accountIdField.getText();
            String accountType = savingCheckBox.isSelected() ? "saving" : "current";
            double initialBalance = 0; // 初始余额可以根据需要设置或从UI获取
            if (StringUtil.accountIdisValid(accountId)) {
                Account newAccount = new Account(accountId, accountType, initialBalance);
                currentUser.addAccount(newAccount);
                userService.updateUser(currentUser); // 更新用户信息，包括新账户

                // 反馈成功并跳转到注册成功页面
                changeView("/fxml/succeedToRegister.fxml");
            } else {
                changeView("/fxml/failToRegister.fxml");
            }
        }

    }

    @FXML
    void initialize() {

    }

}
