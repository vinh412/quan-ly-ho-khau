package com.example.quanly.controller.ho_khau;

import com.example.quanly.HelloApplication;
import com.example.quanly.Popup;
import com.example.quanly.controller.MainController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HoKhauController implements Initializable {

    @FXML
    private Button themHoBtn;
    @FXML
    private Button suaHoBtn;
    @FXML
    private Button xoaHoBtn;
    @FXML
    private Button timKiemBtn;
    @FXML
    private TextField SearchTextField;
    @FXML
    private ComboBox comboBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        themHoBtn.setOnMouseClicked(event -> {
            //them ho
            System.out.println("Them ho clicked");
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ho_khau/them_ho.fxml"));
            Parent root = null;
            try {
                root = (Parent) fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Node node = null;
            if (root != null) {
                node = root.lookup("#them_ho_layout");
            }
            Popup.setLayout(node);
            Popup.setTitle("Thêm hộ khẩu mới");
            Popup.show();
        });

        suaHoBtn.setOnMouseClicked(event -> {
            //sua ho
            System.out.println("Sua ho clicked");
        });

        xoaHoBtn.setOnMouseClicked(event -> {
            //xoa ho
            System.out.println("Xoa ho clicked");
        });

        timKiemBtn.setOnMouseClicked(event -> {
            //tim kiem
            System.out.println("Tim kiem clicked");
        });
    }
}
