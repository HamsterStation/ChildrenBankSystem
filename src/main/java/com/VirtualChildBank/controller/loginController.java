package com.VirtualChildBank.controller;

import com.VirtualChildBank.service.UserService;
import com.VirtualChildBank.util.StringUtil;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import static com.VirtualChildBank.VirtualChildBankApp.*;

public class loginController {
    @FXML
    private PasswordField password;

    @FXML
    private TextField userId;

    private UserService userService;

    public loginController() {
        this.userService = new UserService();
    }

    @FXML
    void onBackAction(MouseEvent event) {
        //goBack();
    }
    @FXML
    void onHelpAction(MouseEvent event) {
        changeView("/fxml/help.fxml");
    }

    @FXML
    void onIntroductionAction(MouseEvent event) {
        changeView("/fxml/introduction.fxml");
    }

    @FXML
    void onChildLoginAction(MouseEvent event) {
        String userIdText = this.userId.getText();
        String passwordText = this.password.getText();
        //这里判断
        if(StringUtil.PasswordisValid(passwordText)){
            if(userService.authenticate(userIdText, passwordText)) {
                changeView("/fxml/childMain.fxml");
            }else{
                changeView("/fxml/failToLogin.fxml");
            }
        }else{
            changeView("/fxml/failToLogin.fxml");
        }
    }

    @FXML
    void onCloseAction(MouseEvent event) {
        close();
    }

    @FXML
    void onParentLoginAction(MouseEvent event) {
        //获取了用户名和密码
        String userIdText = this.userId.getText();
        String passwordText = this.password.getText();
        //这里判断
        if(StringUtil.PasswordisValid(passwordText)){
            if(userService.authenticate(userIdText, passwordText)) {
                changeView("/fxml/parentsMain.fxml");
            }else{
                changeView("/fxml/failToLogin.fxml");
            }
        }else{
            changeView("/fxml/failToLogin.fxml");
        }
    }

    @FXML
    void onRegistionAction(MouseEvent event) {
        changeView("/fxml/userRegister.fxml");
    }

    void initialize() {
       userService = new UserService();
    }
}
