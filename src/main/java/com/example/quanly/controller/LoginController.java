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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.temporal.Temporal;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField usernameTF;
    @FXML
    private TextField passwordTF;
    @FXML
    private Button loginBtn;
    @FXML
    private Label emptyUsrLabel, emptyPwdLabel, accessRefusedLabel;
    public void onLoginBtnClick(ActionEvent actionEvent) throws IOException {
        String username = usernameTF.getText();
        String password = passwordTF.getText();
        if(username == null || username.trim().equals("")){
            emptyUsrLabel.setVisible(true);
            return ;
        }
        if(password == null || password.trim().equals("")){
            emptyPwdLabel.setVisible(true);
            return ;
        }
        User user = Database.findUser(username, password);
        if(user == null){
            accessRefusedLabel.setVisible(true);
        }else{
            accessRefusedLabel.setVisible(false);
            //
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main.fxml"));
            fxmlLoader.setController(new MainController(user));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) loginBtn.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        emptyUsrLabel.setVisible(false);
        emptyPwdLabel.setVisible(false);
        accessRefusedLabel.setVisible(false);

        usernameTF.textProperty().addListener((observable, oldValue, newValue) -> {
            emptyUsrLabel.setVisible(false);
        });

        passwordTF.textProperty().addListener((observable, oldValue, newValue) -> {
            emptyPwdLabel.setVisible(false);
        });
    }
}
