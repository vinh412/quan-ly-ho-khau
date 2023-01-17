package com.example.quanly.controller.nhan_khau;

import com.example.quanly.HelloApplication;
import com.example.quanly.Popup;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NhanKhauController implements Initializable {
    @FXML
    private Button themNhanKhauBtn;
    @FXML
    private Button xoaNhanKhauBtn;
    @FXML
    private Button capNhatNhanKhauBtn;
    @FXML
    private Button timKiemBtn;
    @FXML
    private Button tamVangBtn;
    @FXML
    private Button tamTruBtn;
    @FXML
    private Button khaiTuBtn;
    @FXML
    private TextField searchTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void onThemNhanKhauBtnClicked(){
        //them nhan khau
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("nhan_khau/them_nhan_khau.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Node node = null;
        if (root != null) {
            node = root.lookup("#them_nhan_khau_layout");
        }
        Popup.setLayout(node);
        Popup.setTitle("Thêm nhân khẩu mới");
        Popup.show();
        System.out.println("Them nhan khau clicked");
    }

    @FXML
    private void onXoaNhanKhauBtnClicked(){
        //xoa nhan khau
        System.out.println("Xoa nhan khau clicked");
    }

    @FXML
    private void onCapNhatNhanKhauBtnClicked(){
        //cap nhat nhan khau
        System.out.println("Cap nhat nhan khau clicked");
    }

    @FXML
    private void onDKTamTruBtnClicked(){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("nhan_khau/tam_tru.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Node node = null;
        if (root != null) {
            node = root.lookup("#tam_tru_layout");
        }
        Popup.setLayout(node);
        Popup.setTitle("Đăng ký tạm trú");
        Popup.show();
    }

    @FXML
    private void onDKTamVangBtnClicked(){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("nhan_khau/tam_vang.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Node node = null;
        if (root != null) {
            node = root.lookup("#tam_vang_layout");
        }
        Popup.setLayout(node);
        Popup.setTitle("Đăng ký tạm vắng");
        Popup.show();
    }

    @FXML
    private void onKhaiTuBtnClicked(){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("nhan_khau/khai_tu.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Node node = null;
        if (root != null) {
            node = root.lookup("#khai_tu_layout");
        }
        Popup.setLayout(node);
        Popup.setTitle("Khai tử");
        Popup.show();
    }

    @FXML
    private void onTimKiemBtnClicked(){
        //tim kiem
        System.out.println("Tim kiem clicked");
    }

}
