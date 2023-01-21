package com.example.quanly.controller.nhan_khau;

import com.example.quanly.Database;
import com.example.quanly.models.GiayTamTru;
import com.example.quanly.models.GiayTamVang;
import com.example.quanly.models.NhanKhau;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.nio.Buffer;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class TamTruController implements Initializable {
    @FXML
    private TextField hoTenTF;
    @FXML
    private TextField maGiayTF;
    @FXML
    private TextField diaChiThuongTruTF;
    @FXML
    private TextField diaChiTamTruTF;
    @FXML
    private TextField lyDoTF;
    @FXML
    private DatePicker tuNgay;
    @FXML
    private DatePicker denNgay;
    @FXML
    private Button huyBtn;
    private NhanKhau nhanKhau;

    public TamTruController(NhanKhau nhanKhau){
        this.nhanKhau = nhanKhau;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.hoTenTF.setText(this.nhanKhau.getHoTen());
    }
    @FXML
    private void onXacNhanBtnClick(){
        String maGiay = this.maGiayTF.getText();
        String diaChiThuongTru = this.diaChiThuongTruTF.getText();
        String diaChiTamTru = this.diaChiTamTruTF.getText();
        LocalDate tuNgay = this.tuNgay.getValue();
        LocalDate denNgay = this.denNgay.getValue();
        String lyDo = this.lyDoTF.getText();
        GiayTamTru giayTamTru = new GiayTamTru(this.nhanKhau, maGiay, diaChiThuongTru, diaChiTamTru, "", tuNgay, denNgay, lyDo);
        Database.insertOneGiayTamTru(giayTamTru);
        this.onHuyBtnClick();
    }

    @FXML
    private void onHuyBtnClick(){
        Stage stage  = (Stage) huyBtn.getScene().getWindow();
        stage.close();
    }


}
