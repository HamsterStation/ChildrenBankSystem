package com.VirtualChildBank.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.VirtualChildBank.service.UserService;
import com.VirtualChildBank.util.StringUtil;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import static com.VirtualChildBank.VirtualChildBankApp.*;

public class userRegisterController {

    @FXML private TextField usernameField;
    @FXML private TextField passwordField;

    private UserService userService;

    public userRegisterController() {
        this.userService = new UserService();
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
        String username = usernameField.getText();
        String password = passwordField.getText();
        userService.registerUser(username, password);
        if(StringUtil.PasswordisValid(password)){
            changeView("/fxml/succeedToRegister.fxml");
        }else{
            changeView("/fxml/failToRegister.fxml");
        }
    }

    @FXML
    void initialize() {
        userService = new UserService();
    }

}
