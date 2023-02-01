package com.example.quanly.controller;

import com.example.quanly.Database;
import com.example.quanly.HelloApplication;
import com.example.quanly.models.GiayTamTru;
import com.example.quanly.models.HoKhau;
import com.example.quanly.models.NhanKhau;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;
import java.util.ArrayList;

public class TrangChuController {
    @FXML
    private Label tongHoKhauLB;
    @FXML
    private Label tongNhanKhauLB;
    @FXML
    private Label tongTamTruLB;
    @FXML
    private Label tongTamVangLB;
    public void initialize(){
        ArrayList<HoKhau> hoKhauArrayList = Database.findHoKhau("*","");
        tongHoKhauLB.setText(hoKhauArrayList.size()+"");
        ArrayList<NhanKhau> nhanKhauArrayList = Database.findNhanKhau("*","");
        tongNhanKhauLB.setText(nhanKhauArrayList.size()+"");
        //ArrayList<GiayTamTru> tamTruArrayList = Database.("*","");
        //tongHoKhauLB.setText(hoKhauArrayList.size()+"");
        //ArrayList<HoKhau> hoKhauArrayList = Database.findHoKhau("*","");
        //tongHoKhauLB.setText(hoKhauArrayList.size()+"");
    }
}
