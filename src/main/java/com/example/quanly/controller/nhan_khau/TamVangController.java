package com.example.quanly.controller.nhan_khau;

import com.example.quanly.Database;
import com.example.quanly.models.GiayTamVang;
import com.example.quanly.models.NhanKhau;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;

public class TamVangController implements Initializable {
    @FXML
    private TextField hoTenTF;
    @FXML
    private Button huyBtn;
    @FXML
    private Button xacNhanBtn;
    @FXML
    private TextField maGiayTF;
    @FXML
    private TextField noiTamTruTF;
    @FXML
    private DatePicker tuNgay;
    @FXML
    private DatePicker denNgay;
    @FXML
    private TextField lyDoTF;
    private NhanKhau nhanKhau;
    public TamVangController(NhanKhau nhanKhau){
        this.nhanKhau = nhanKhau;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.hoTenTF.setText(nhanKhau.getHoTen());

    }
    @FXML
    private void onXacNhanBtnClick(){
        String maGiay = this.maGiayTF.getText();
        String noiTamTru = this.noiTamTruTF.getText();
        LocalDate tuNgay = this.tuNgay.getValue();
        LocalDate denNgay = this.denNgay.getValue();
        String lyDo = this.lyDoTF.getText();
        GiayTamVang giayTamVang = new GiayTamVang(this.nhanKhau, maGiay, noiTamTru, tuNgay, denNgay, lyDo);
        Database.insertOneGiayTamVang(giayTamVang);
        this.onHuyBtnClick();
    }
    @FXML
    public void onHuyBtnClick(){
        Stage stage  = (Stage) huyBtn.getScene().getWindow();
        stage.close();
    }
}
