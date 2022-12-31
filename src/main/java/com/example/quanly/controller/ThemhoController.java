package com.example.quanly.controller;

import com.example.quanly.Database;
import com.example.quanly.Popup;
import com.example.quanly.models.HoKhau;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ThemhoController {

    public TextField soHoKhauTF;
    public TextField hoTenChuHoTF;
    public TextField soNhaTF;
    public TextField duongTF;
    public TextField xaTF;
    public TextField huyenTF;
    public AnchorPane themhoLayout;

    public void onThemhoButtonClick(){
        String soHoKhau = soHoKhauTF.getText();
        String hoTenChuHo = hoTenChuHoTF.getText();
        String soNha = soNhaTF.getText();
        String duong = duongTF.getText();
        String xa = xaTF.getText();
        String huyen = huyenTF.getText();

        Database.connect();
        HoKhau hoKhauMoi = new HoKhau(soHoKhau,hoTenChuHo,soNha,duong,xa,huyen);
        Database.insertOne(hoKhauMoi);
        Database.close();

        Popup.close();
    }

    public void onHuyButtonClick(){
        Popup.close();
    }
}
