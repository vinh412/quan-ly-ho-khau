package com.example.quanly.controller;

import com.example.quanly.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private BorderPane borderPane;

    @FXML
    private Button hoKhauBtn;
    @FXML
    private Button nhanKhauBtn;
    @FXML
    private Button covidBtn;
    @FXML
    private Button thongKeBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        hoKhauBtn.setOnMouseClicked(event ->{
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ho_khau.fxml"));
            Parent root = null;
            try {
                root = fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Node node = null;
            if (root != null) {
                node = root.lookup("#hokhauLayout");
            }
            borderPane.setCenter(node);
        });

        nhanKhauBtn.setOnMouseClicked(event -> {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("nhan_khau.fxml"));
            Parent root = null;
            try {
                root = fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Node node = null;
            if (root != null) {
                node = root.lookup("#nhankhauLayout");
            }
            borderPane.setCenter(node);
        });

        covidBtn.setOnMouseClicked(event -> {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("covid.fxml"));
            Parent root = null;
            try {
                root = fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Node node = null;
            if (root != null) {
                node = root.lookup("#covidLayout");
            }
            borderPane.setCenter(node);
        });
    }
}
