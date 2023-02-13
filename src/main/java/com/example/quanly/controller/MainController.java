package com.example.quanly.controller;

import com.example.quanly.HelloApplication;
import com.example.quanly.models.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
    @FXML
    private Toggle trangChuToggleBtn;
    @FXML
    private Toggle hoKhauToggleBtn;
    @FXML
    private Toggle nhanKhauToggleBtn;
    @FXML
    private Toggle covidToggleBtn;
    @FXML
    private Toggle thongKeToggleBtn;
    private boolean check(){
        return !trangChuToggleBtn.isSelected() && !hoKhauToggleBtn.isSelected() && !nhanKhauToggleBtn.isSelected() && !covidToggleBtn.isSelected() && !thongKeToggleBtn.isSelected();

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ToggleGroup toggleGroup = new ToggleGroup();
        trangChuToggleBtn.setToggleGroup(toggleGroup);
        hoKhauToggleBtn.setToggleGroup(toggleGroup);
        nhanKhauToggleBtn.setToggleGroup(toggleGroup);
        covidToggleBtn.setToggleGroup(toggleGroup);
        thongKeToggleBtn.setToggleGroup(toggleGroup);

        trangChuToggleBtn.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                onTrangChuBtnClick();
            }
            if(check()){
                trangChuToggleBtn.setSelected(true);
            }
        });
        hoKhauToggleBtn.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                onHoKhauBtnClick();
            }
            if(check()){
                hoKhauToggleBtn.setSelected(true);
            }
        });
        nhanKhauToggleBtn.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                onNhanKhauBtnClick();
            }
            if(check()){
                nhanKhauToggleBtn.setSelected(true);
            }
        });
        covidToggleBtn.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                onCovidBtnClick();
            }
            if(check()){
                covidToggleBtn.setSelected(true);
            }
        });
        thongKeToggleBtn.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue){
                onThongKeBtnClick();
            }
            if(check()){
                thongKeToggleBtn.setSelected(true);
            }
        });

        trangChuToggleBtn.setSelected(true);
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
//            hoKhauToggleBtn.setSelected(false);
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
//            nhanKhauToggleBtn.setSelected(false);
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
                node = root.lookup("#borderPane");
            }
            borderPane.setCenter(node);
        }else{
//            covidToggleBtn.setSelected(false);
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
                node = root.lookup("#borderPane");
            }
            borderPane.setCenter(node);
        }else{
//            thongKeToggleBtn.setSelected(false);
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("auth.permission.none");
            alert.setContentText("You are not authorized to view this page");
            alert.showAndWait();
        }
    }
    @FXML
    private void onLogoutBtnClick() throws IOException {
        System.out.println("logout");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) borderPane.getScene().getWindow();
        stage.close();

        Stage appStage = new Stage();
        appStage.resizableProperty().setValue(false);
        appStage.setScene(scene);
        appStage.setTitle("Đăng nhập");
        appStage.show();
    }
}
