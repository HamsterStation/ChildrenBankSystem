package com.VirtualChildBank.controller;

import com.VirtualChildBank.model.Task;
import com.VirtualChildBank.service.UserService;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import static com.VirtualChildBank.VirtualChildBankApp.*;

public class viewTasksController {
    @FXML private Text content1, content2, content3, content4, content5, content6;
    @FXML private Text price1, price2, price3, price4, price5, price6;
    @FXML private ResourceBundle resources;
    @FXML private URL location;

    private UserService userService = new UserService();  // 假设UserService已经被正确初始化

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
        updateTaskViews(userService.getCurrentUser().getTasks());
    }

    private void updateTaskViews(List<Task> tasks) {
        if (tasks.size() > 0) {
            content1.setText(tasks.get(0).getTaskContent());
            price1.setText(String.format("%.2f", tasks.get(0).getTaskPrice()));
        }
        if (tasks.size() > 1) {
            content2.setText(tasks.get(1).getTaskContent());
            price2.setText(String.format("%.2f", tasks.get(1).getTaskPrice()));
        }
        if (tasks.size() > 2) {
            content3.setText(tasks.get(2).getTaskContent());
            price3.setText(String.format("%.2f", tasks.get(2).getTaskPrice()));
        }
        if (tasks.size() > 3) {
            content4.setText(tasks.get(3).getTaskContent());
            price4.setText(String.format("%.2f", tasks.get(3).getTaskPrice()));
        }
        if (tasks.size() > 4) {
            content5.setText(tasks.get(4).getTaskContent());
            price5.setText(String.format("%.2f", tasks.get(4).getTaskPrice()));
        }
        if (tasks.size() > 5) {
            content6.setText(tasks.get(5).getTaskContent());
            price6.setText(String.format("%.2f", tasks.get(5).getTaskPrice()));
        }
    }
}
