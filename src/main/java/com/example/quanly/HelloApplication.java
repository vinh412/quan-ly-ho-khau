package com.example.quanly;

import com.example.quanly.controller.ho_khau.HoKhauController;
import com.example.quanly.models.HoKhau;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Quan Ly Ho khau");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Database.connect();
        launch();
        Database.close();
    }
}