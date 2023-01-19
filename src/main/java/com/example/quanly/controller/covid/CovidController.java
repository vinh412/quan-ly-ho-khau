package com.example.quanly.controller.covid;

import com.example.quanly.HelloApplication;
import com.example.quanly.Popup;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

import java.io.IOException;

public class CovidController {
    @FXML
    private void onKhaiBaoYTeBtnClick(){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("covid/khai_bao_y_te.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Node node = null;
        if (root != null) {
            node = root.lookup("#khai_bao_y_te_layout");
        }
        Popup popup = new Popup();
        popup.setLayout(node);
        popup.setTitle("Khai báo y tế");
        popup.show();
        System.out.println("Khai bao y te clicked");
    }

    @FXML
    private void onGhiNhanThongTinCachLyBtnClick(){

    }

    @FXML
    private void onThongKeKhaiBaoYTeBtnClick(){

    }

    @FXML
    private void onThongKeCachLyBtnClick(){

    }
}