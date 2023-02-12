package com.example.quanly.controller;

import com.example.quanly.Database;
import com.example.quanly.HelloApplication;
import com.example.quanly.models.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.time.temporal.Temporal;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    double x,y = 0;
    @FXML
    public TextField usernameTF;
    @FXML
    public TextField passwordTF;
    @FXML
    public Button loginBtn;
    @FXML
    public Label accessRefusedLabel;
    public void onLoginBtnClick() throws IOException {
        String username = usernameTF.getText();
        String password = passwordTF.getText();
        if(username == null || username.trim().equals("")){
            accessRefusedLabel.setVisible(true);
            accessRefusedLabel.setText("Chưa nhập user name!!!");
            return ;
        }
        if(password == null || password.trim().equals("")){
            accessRefusedLabel.setVisible(true);
            accessRefusedLabel.setText("Chưa nhập password!!!");
            return ;
        }
        User user = Database.findUser(username, password);
        if(user == null){
            accessRefusedLabel.setVisible(true);
            accessRefusedLabel.setText("Sai username hoặc password!!!");
        }else{
            accessRefusedLabel.setVisible(false);
            //
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main.fxml"));
            fxmlLoader.setController(new MainController(user));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) loginBtn.getScene().getWindow();
            stage.close();

            Stage appStage = new Stage();
            appStage.resizableProperty().setValue(false);
            appStage.setScene(scene);
            appStage.setTitle("Quản Lý Hộ Khẩu");
            appStage.show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        accessRefusedLabel.setVisible(false);
    }

    public void onCancelBtnClick(ActionEvent event) {
        System.exit(0);
    }
}
