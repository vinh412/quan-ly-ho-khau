package com.example.quanly.controller;

import com.example.quanly.HelloApplication;
import com.example.quanly.models.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    public static User currentUser;
    public MainController(User user){
        this.currentUser = user;
    }
    @FXML
    private BorderPane borderPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        onTrangChuBtnClick();
    }
    @FXML
    private void onTrangChuBtnClick(){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("trang_chu.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Node node = null;
        if (root != null) {
            node = root.lookup("#trang_chu_layout");
        }
        borderPane.setCenter(node);
    }
    @FXML
    private void onHoKhauBtnClick(){
        if(currentUser.getRole() == 0) {
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
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("auth.permission.none");
            alert.setContentText("You are not authorized to view this page");
            alert.showAndWait();
        }
    }

    @FXML
    private void onNhanKhauBtnClick(){
        if(currentUser.getRole() == 0) {
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
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("auth.permission.none");
            alert.setContentText("You are not authorized to view this page");
            alert.showAndWait();
        }
    }

    @FXML
    private void onCovidBtnClick(){
        if(currentUser.getRole() == 1) {
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
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("auth.permission.none");
            alert.setContentText("You are not authorized to view this page");
            alert.showAndWait();
        }
    }

    @FXML
    private void onThongKeBtnClick(){
        if(currentUser.getRole() == 0) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("thong_ke/thong_ke.fxml"));
            Parent root = null;
            try {
                root = fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Node node = null;
            if (root != null) {
                node = root.lookup("#thongke_layout");
            }
            borderPane.setCenter(node);
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("auth.permission.none");
            alert.setContentText("You are not authorized to view this page");
            alert.showAndWait();
        }
    }

    @FXML
    private void exitApp(){
        System.exit(0);
    }
}
