package com.VirtualChildBank.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import static com.VirtualChildBank.VirtualChildBankApp.*;

public class childMainController {


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
        changeView("/fxml/accountRegister.fxml");
    }

    @FXML
    void onDetectBalanceAction(MouseEvent event) {
        changeView("/fxml/showBalance.fxml");
    }

    @FXML
    void onDetectTasksAction(MouseEvent event) {
        changeView("/fxml/viewTasks.fxml");
    }

    @FXML
    void onDetectTransactionAction(MouseEvent event) {
        changeView("/fxml/transaction.fxml");
    }


    @FXML
    void onSavingAction(MouseEvent event) {
        changeView("/fxml/save.fxml");
    }

    @FXML
    void onSetSavingGoalAction(MouseEvent event) {
        changeView("/fxml/setSavingGoal.fxml");
    }

    @FXML
    void onWithdrawingAction(MouseEvent event) {
        changeView("/fxml/withdraw.fxml");
    }
    @FXML
    void initialize() {

    }

}
