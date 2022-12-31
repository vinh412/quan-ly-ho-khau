package com.example.quanly.controller;

import com.example.quanly.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MainController {
    @FXML
    private BorderPane borderPane;

    @FXML
    private void onHokhauButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hokhau.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Node node = root.lookup("#hokhauLayout");
        borderPane.setCenter(node);
    }

    @FXML
    private void onNhankhauButtonClick() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("nhankhau.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Node node = root.lookup("#nhankhauLayout");
        borderPane.setCenter(node);
    }

    @FXML
    private void onCovidButtonClick() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("covid.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Node node = root.lookup("#covidLayout");
        borderPane.setCenter(node);
    }

}
