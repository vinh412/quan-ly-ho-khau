package com.example.quanly.controller.nhan_khau;

import com.example.quanly.Database;
import com.example.quanly.models.GiayKhaiTu;
import com.example.quanly.models.GiayTamTru;
import com.example.quanly.models.NhanKhau;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class KhaiTuController implements Initializable {
    @FXML
    private TextField maGiayTF;
    @FXML
    private TextField hoTenTF;
    @FXML
    private DatePicker ngayKhai;
    @FXML
    private DatePicker ngayChet;
    @FXML
    private TextField lyDoTF;
    @FXML
    private Button huyBtn;
    private NhanKhau nhanKhau;
    public KhaiTuController(NhanKhau nhanKhau){
        this.nhanKhau = nhanKhau;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.hoTenTF.setText(this.nhanKhau.getHoTen());
        this.ngayKhai.setValue(LocalDate.now());

        this.ngayKhai.setOnMouseClicked(e -> {
            if(!this.ngayKhai.isEditable())
                this.ngayKhai.hide();
        });
    }
    @FXML
    private void onXacNhanBtnClick(){
        String maGiay = this.maGiayTF.getText();
        LocalDate ngayKhai = this.ngayKhai.getValue();
        LocalDate ngayChet = this.ngayChet.getValue();
        String lyDo = this.lyDoTF.getText();
        GiayKhaiTu giayKhaiTu = new GiayKhaiTu(this.nhanKhau, maGiay, 33, ngayKhai, ngayChet, lyDo);
        Database.insertOneGiayKhaiTu(giayKhaiTu);
        this.onHuyBtnClick();
    }

    @FXML
    private void onHuyBtnClick(){
        Stage stage  = (Stage) huyBtn.getScene().getWindow();
        stage.close();
    }


}
