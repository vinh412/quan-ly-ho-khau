package com.example.quanly;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Popup {
    private Stage stage;
    private Node node;
    private static int id = 0;
    private int popupId;
    private static ArrayList<Popup> popupArrayList = new ArrayList<>();
    public Popup(){
        this.popupId = Popup.id;
        Popup.id ++;
        popupArrayList.add(this);
    }
    public void setLayout(Node node){
        this.node = node;
        Group root = new Group(this.node);
        Scene scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
    }

    public void setTitle(String title){
        stage.setTitle(title);
    }
    public void show(){
        stage.show();
    }
    public void close(){
        for(int i=0;i<Popup.popupArrayList.size();i++){
            if(Popup.popupArrayList.get(i).popupId<=this.popupId){
                Popup.popupArrayList.get(i).stage.close();
            }
        }
    }
}
