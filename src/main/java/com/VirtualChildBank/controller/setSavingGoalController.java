package com.VirtualChildBank.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.VirtualChildBank.model.User;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import static com.VirtualChildBank.VirtualChildBankApp.*;
import com.VirtualChildBank.service.UserService;
import javafx.scene.control.TextField;


public class setSavingGoalController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private TextField goalTextField;

    @FXML
    private URL location;

    @FXML
    void onBackAction(MouseEvent event) {
        goBack();
    }

    @FXML
    void onCloseAction(MouseEvent event) {
        close();
    }

    @FXML
    void onSetGoalAction(MouseEvent event) {
        String goal = goalTextField.getText();
        if (goal != null && !goal.isEmpty()) {
            UserService userService = new UserService();
            User currentUser = userService.getCurrentUser();
            if (currentUser != null) {
                currentUser.setGoal(goal);
                userService.updateUser(currentUser);
                changeView("/fxml/succeedToSetGoal.fxml"); // 成功设置后的视图
            } else {
                changeView("/fxml/failToSetGoal.fxml");
            }
        } else {
            changeView("/fxml/failToSetGoal.fxml");
        }
    }

    @FXML
    void initialize() {
        UserService userService = new UserService();
        User currentUser = userService.getCurrentUser();
    }

}
