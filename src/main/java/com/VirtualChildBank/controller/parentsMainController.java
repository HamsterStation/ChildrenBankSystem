package com.VirtualChildBank.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import static com.VirtualChildBank.VirtualChildBankApp.*;

public class parentsMainController {

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
    void onDetectReportAction(MouseEvent event) {
        changeView("/fxml/report.fxml");
    }

    @FXML
    void onDetectTransactionAction(MouseEvent event) {
        changeView("/fxml/transaction.fxml");
    }

    @FXML
    void onRegisterAction(MouseEvent event) {
        changeView("/fxml/accountRegister.fxml");
    }

    @FXML
    void onSetTasksAction(MouseEvent event) {
        changeView("/fxml/setTasks.fxml");
    }

    @FXML
    void initialize() {

    }

}
