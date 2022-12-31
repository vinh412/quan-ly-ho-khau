package com.example.quanly;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Popup {
    private static Stage stage;
    private static Node node;

    public static void setLayout(Node node){
        Popup.node = node;
        Group root = new Group(Popup.node);
        Scene scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
    }

    public static void setTitle(String title){
        stage.setTitle(title);
    }
    public static void show(){
        stage.show();
    }
    public static void close(){
        stage.close();
    }
}
