package com.VirtualChildBank.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.VirtualChildBank.model.Task;
import com.VirtualChildBank.model.User;
import com.VirtualChildBank.service.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import static com.VirtualChildBank.VirtualChildBankApp.*;

public class setTasksController {
    @FXML
    private TextField taskTextField;

    @FXML
    private TextField taskpriceTextField;

    @FXML
    private ResourceBundle resources;

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
    void onSetTaskAction(MouseEvent event) {
        String taskContent = taskTextField.getText();
        double taskPrice;
        try {
            taskPrice = Double.parseDouble(taskpriceTextField.getText());
        } catch (NumberFormatException e) {
            changeView("/fxml/failToSetGoal.fxml");
            return;
        }

        Task newTask = new Task(taskContent, taskPrice);
        UserService userService = new UserService();
        User currentUser = userService.getCurrentUser();
        currentUser.getTasks().add(newTask);
        userService.updateUser(currentUser);  // 更新用户数据
        changeView("/fxml/succeedToSetGoal.fxml"); // 跳转到任务设置成功的页面

    }

    @FXML
    void initialize() {
        UserService userService = new UserService();
    }

}
