package com.VirtualChildBank.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import static com.VirtualChildBank.VirtualChildBankApp.*;
import com.VirtualChildBank.model.User;
import com.VirtualChildBank.service.UserService; // 确保能够调用 UserService

public class showBalanceController {

    @FXML
    private Text savingGoalText;

    @FXML
    private Text totalBalanceText;

    private UserService userService; // 添加 UserService

    @FXML
    void onBackAction(MouseEvent event) {
        goBack();
    }

    @FXML
    void onCloseAction(MouseEvent event) {
        close();
    }

    @FXML
    void initialize() {
        userService = new UserService(); // 初始化 UserService
        User currentUser = userService.getCurrentUser(); // 获取当前用户
        if (currentUser != null) {
            // 设置余额和储蓄目标到文本控件
            totalBalanceText.setText(String.format("%.2f", currentUser.getTotalBalance())); // 格式化双精度数值为字符串
            savingGoalText.setText(currentUser.getGoal()); // 目标可能需要检查是否为null
        }
    }
}
