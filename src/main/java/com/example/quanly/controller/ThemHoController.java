package com.example.quanly.controller;

import com.example.quanly.Database;
import com.example.quanly.Popup;
import com.example.quanly.models.HoKhau;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ThemHoController {

    public TextField maHoKhauTF;
    public TextField maKhuVucTF;
    public TextField diaChiTF;
    public TextField hoTenChuHoTF;
    public TextField soCMTChuHoTF;
    public TextField ngayLapTF;
    public AnchorPane themhoLayout;

    public void onThemhoButtonClick(){
        String maHoKhau = maHoKhauTF.getText();
        String maKhuVuc = maKhuVucTF.getText();
        String diaChi = diaChiTF.getText();
        String hoTenChuHo = hoTenChuHoTF.getText();
        String soCMTChuHo = soCMTChuHoTF.getText();
        String ngayLap = ngayLapTF.getText();

        Database.connect();
        HoKhau hoKhauMoi = new HoKhau(maHoKhau, maKhuVuc, diaChi, ngayLap, null, null);
        Database.insertHoKhau(hoKhauMoi);
        Database.close();

        Popup.close();
    }

    public void onHuyButtonClick(){
        Popup.close();
    }
}
