package com.example.quanly.controller.covid;

import com.example.quanly.models.KhaiBaoYTe;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class KhaiBaoYTeController {
    @FXML
    private Button chonNhanKhauBtn;
    @FXML
    private Label hoTenLB, namSinhLB, gioiTinhLB, diaChiThuongTruLB;
    @FXML
    private RadioButton coTiepXucF0RB, khongTiepXucF0RB, coDiVeRB, khongDiVeRB, coTiepXucVungDichRB, khongTiepXucVungDichRB;
    @FXML
    private TextField daDenQuocGiaTF;
    @FXML
    private CheckBox sotCB, hoCB, khoThoCB, viemPhoiCB, dauHongCB, metMoiCB;
    @FXML
    private CheckBox benhGanManTinhCB, benhMauManTinhCB, benhPhoiManTinhCB, benhThanManTinhCB, benhTimMachCB,
            huyetApCaoCB, hivSuyGiamMienDichCB, nguoiNhanGhepTangCB, tieuDuongCB, ungThuCB, coThaiCB;
    @FXML
    private CheckBox camKetCB;

    public void initialize() {

    }

    public KhaiBaoYTe getKhaiBaoYTe(){
        return new KhaiBaoYTe();
    }
}
