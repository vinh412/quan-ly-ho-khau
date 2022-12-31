package com.example.quanly.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class NhankhauController {
    @FXML
    private TextField searchTextField;

    @FXML
    private void onThemnhankhauButtonClick(){
        //them ho
        System.out.println("Them nhan khau clicked");
    }

    @FXML
    private void onXoanhankhauButtonClick(){
        //sua ho
        System.out.println("Xoa nhan khau clicked");
    }

    @FXML
    private void onCapnhatnhankhauButtonClick(){
        //xoa ho
        System.out.println("Cap nhat nhan khau clicked");
    }

    @FXML
    private void onTimkiemButtonClick(){
        //tim kiem
        System.out.println("Tim kiem clicked");
    }
}
