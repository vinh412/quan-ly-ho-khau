package com.example.quanly.controller.covid;

import com.example.quanly.HelloApplication;
import com.example.quanly.controller.nhan_khau.ChonNhanKhauController;
import com.example.quanly.models.KhaiBaoYTe;
import com.example.quanly.models.NhanKhau;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

public class KhaiBaoYTeController {
    @FXML
    private DialogPane dialogPane;
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
    private NhanKhau selectedNhanKhau;

    public void initialize() {
        dialogPane.lookupButton(ButtonType.OK).setDisable(true);
        camKetCB.setOnAction(event -> {
            if(camKetCB.isSelected() && selectedNhanKhau != null)
                dialogPane.lookupButton(ButtonType.OK).setDisable(false);
            else
                dialogPane.lookupButton(ButtonType.OK).setDisable(true);
        });
    }

    public KhaiBaoYTe getKhaiBaoYTe(){
        boolean tiepXucNguoiBenhKhong = coTiepXucF0RB.isSelected();
        boolean diVeTuVungDichKhong = coDiVeRB.isSelected();
        boolean tiepXucNguoiDiVeTuVungDichKhong = coTiepXucVungDichRB.isSelected();
        String daDenQuocGia = daDenQuocGiaTF.getText();
        boolean sot = sotCB.isSelected();
        boolean ho = hoCB.isSelected();
        boolean khoTho = khoThoCB.isSelected();
        boolean viemPhoi = viemPhoiCB.isSelected();
        boolean dauHong = dauHongCB.isSelected();
        boolean metMoi = metMoiCB.isSelected();
        boolean benhGanManTinh = benhGanManTinhCB.isSelected();
        boolean benhMauManTinh = benhMauManTinhCB.isSelected();
        boolean benhPhoiManTinh = benhPhoiManTinhCB.isSelected();
        boolean benhThanManTinh = benhThanManTinhCB.isSelected();
        boolean benhTimMach = benhTimMachCB.isSelected();
        boolean huyetApCao = huyetApCaoCB.isSelected();
        boolean hivSuyGiamMienDich = hivSuyGiamMienDichCB.isSelected();
        boolean nguoiNhanGhepTang = nguoiNhanGhepTangCB.isSelected();
        boolean tieuDuong = tieuDuongCB.isSelected();
        boolean ungThu = ungThuCB.isSelected();
        boolean coThai = coThaiCB.isSelected();

        return new KhaiBaoYTe(-1, null, selectedNhanKhau.getID(), LocalDate.now().toString(),
                tiepXucNguoiBenhKhong, diVeTuVungDichKhong, tiepXucNguoiDiVeTuVungDichKhong, daDenQuocGia, sot,
                ho, khoTho, viemPhoi, dauHong, metMoi, benhGanManTinh, benhMauManTinh, benhPhoiManTinh, benhThanManTinh,
                benhTimMach, huyetApCao, hivSuyGiamMienDich, nguoiNhanGhepTang, tieuDuong, ungThu, coThai);
    }
    @FXML
    private void onChonNhanKhauBtnClick(){
        try {
            // load the fxml file and create a new popup dialog
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("nhan_khau/chon_nhan_khau.fxml"));
            DialogPane chonNhanKhauDialogPane = fxmlLoader.load();

            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setDialogPane(chonNhanKhauDialogPane);
            dialog.setTitle("Chọn nhân khẩu");

            ChonNhanKhauController chonNhanKhauController = fxmlLoader.getController();
            Optional<ButtonType> clickedButton = dialog.showAndWait();
            if(clickedButton.get() == ButtonType.OK){
                this.selectedNhanKhau = chonNhanKhauController.getSelectedNhanKhau();
                hoTenLB.setText(selectedNhanKhau.getHoTen());
                namSinhLB.setText(selectedNhanKhau.getNamSinh().toString());
                gioiTinhLB.setText(selectedNhanKhau.getGioiTinh());
                diaChiThuongTruLB.setText(selectedNhanKhau.getDiaChiHienNay());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
