package com.example.quanly.controller.thong_ke;

import com.example.quanly.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ThongKeController implements Initializable {
    @FXML
    private BorderPane borderPane;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FXMLLoader fxmlLoader_center = new FXMLLoader(HelloApplication.class.getResource("thong_ke/thong_ke_nhan_khau.fxml"));
        Parent root_center = null;
        try {
            root_center = fxmlLoader_center.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Node node_center = null;
        if (root_center != null) {
            node_center = root_center.lookup("#thongke_layout");
        }
        borderPane.setCenter(node_center);
    }

    public void onTKNhanKhauClick(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader_center = new FXMLLoader(HelloApplication.class.getResource("thong_ke/thong_ke_nhan_khau.fxml"));
        Parent root_center = null;
        try {
            root_center = fxmlLoader_center.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Node node_center = null;
        if (root_center != null) {
            node_center = root_center.lookup("#thongke_layout");
        }
        borderPane.setCenter(node_center);
    }

    public void onTKTamTruBtnClick(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader_center = new FXMLLoader(HelloApplication.class.getResource("thong_ke/thong_ke_tam_tru.fxml"));
        Parent root_center = null;
        try {
            root_center = fxmlLoader_center.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Node node_center = null;
        if (root_center != null) {
            node_center = root_center.lookup("#thongke_layout");
        }
        borderPane.setCenter(node_center);
    }

    public void onTKTamVangClick(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader_center = new FXMLLoader(HelloApplication.class.getResource("thong_ke/thong_ke_tam_vang.fxml"));
        Parent root_center = null;
        try {
            root_center = fxmlLoader_center.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Node node_center = null;
        if (root_center != null) {
            node_center = root_center.lookup("#thongke_layout");
        }
        borderPane.setCenter(node_center);
    }
}
