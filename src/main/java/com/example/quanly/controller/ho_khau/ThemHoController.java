package com.example.quanly.controller.ho_khau;

import com.example.quanly.Database;
import com.example.quanly.Popup;
import com.example.quanly.models.HoKhau;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ThemHoController {

    public TextField maHoKhauTF;
    public TextField maKhuVucTF;
    public TextField diaChiTF;
    public TextField hoTenChuHoTF;
    public TextField soCMTChuHoTF;
    public TextField ngayLapTF;

    @FXML
    private void onXacNhanBtnClicked(){
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

    @FXML
    private void onHuyBtnClicked(){
        Popup.close();
    }
}
