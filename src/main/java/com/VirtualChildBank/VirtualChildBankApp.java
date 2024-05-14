package com.VirtualChildBank;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Stack;
import java.util.function.Consumer;

public class VirtualChildBankApp extends Application {

    private static Stage stage;
    private static Stack<Scene> sceneHistory = new Stack<>();

    @Override
    public void start(Stage stage) throws Exception {
        VirtualChildBankApp.stage = stage;
        stage.setTitle("Virtual Child Bank");
        changeView("/fxml/login.fxml");
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.getIcons().add(new Image("/image/icon.jpg"));
        stage.setFullScreenExitHint("");
        stage.show();
    }

    public static void changeView(String fxml) {
        try {
            Parent root = FXMLLoader.load(VirtualChildBankApp.class.getResource(fxml));
            Scene currentScene = new Scene(root);
            sceneHistory.push(stage.getScene()); // 在改变场景之前先存储
            stage.setScene(currentScene);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T changeView(String fxml, boolean returnController) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(VirtualChildBankApp.class.getResource(fxml));
            Parent root = loader.load();
            Scene currentScene = new Scene(root);
            sceneHistory.push(stage.getScene()); // 在改变场景之前先存储
            stage.setScene(currentScene);
            if (returnController) {
                return loader.getController();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }



    public static void goBack() {
        if (!sceneHistory.isEmpty()) {
            stage.setScene(sceneHistory.pop()); // 返回之前的场景
        }
    }

    public static void close(){
    stage.close();
}

    public static void main(String[] args) {
        launch(args);
    }
}
