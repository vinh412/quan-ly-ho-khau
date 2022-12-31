package com.example.quanly.controller;

import com.example.quanly.HelloApplication;
import com.example.quanly.Popup;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class HokhauController {
    @FXML
    private TextField SearchTextField;

    @FXML
    private ComboBox comboBox;

    @FXML
    private void onThemhoButtonClick() throws IOException {
        //them ho
        System.out.println("Them ho clicked");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("themho.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Node node = root.lookup("#themhoLayout");
        Popup.setLayout(node);
        Popup.setTitle("Thêm hộ khẩu mới");
        Popup.show();
    }

    @FXML
    private void onSuahoButtonClick(){
        //sua ho
        System.out.println("Sua ho clicked");
    }

    @FXML
    private void onXoahoButtonClick(){
        //xoa ho
        System.out.println("Xoa ho clicked");
    }

    @FXML
    private void onTimkiemButtonClick(){
        //tim kiem
        System.out.println("Tim kiem clicked");
    }
}
