package com.example.quanly.controller;

import com.example.quanly.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private BorderPane borderPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    @FXML
    private void onHoKhauBtnClick(){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ho_khau/ho_khau.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Node node = null;
        if (root != null) {
            node = root.lookup("#ho_khau_layout");
        }
        borderPane.setCenter(node);
    }

    @FXML
    private void onNhanKhauBtnClick(){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("nhan_khau/nhan_khau.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Node node = null;
        if (root != null) {
            node = root.lookup("#nhan_khau_layout");
        }
        borderPane.setCenter(node);
    }

    @FXML
    private void onCovidBtnClick(){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("covid/covid.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Node node = null;
        if (root != null) {
            node = root.lookup("#covid_layout");
        }
        borderPane.setCenter(node);
    }

    @FXML
    private void onThongKeBtnClick(){
        System.out.println("Thong ke button clicked");
    }
}
