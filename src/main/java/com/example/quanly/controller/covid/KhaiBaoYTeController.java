package com.example.quanly.controller.covid;

import com.example.quanly.Database;
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

        return new KhaiBaoYTe(null, selectedNhanKhau.getID(), LocalDate.now().toString(),
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

    public void showKhaiBaoYTe(KhaiBaoYTe khaiBaoYTe){
        NhanKhau nhanKhau = Database.findNhanKhau("ID", khaiBaoYTe.getIdNhanKhau()).get(0);
        if(nhanKhau != null){
            this.selectedNhanKhau = nhanKhau;
            this.hoTenLB.setText(nhanKhau.getHoTen());
            this.namSinhLB.setText(nhanKhau.getNamSinh().toString());
            gioiTinhLB.setText(nhanKhau.getGioiTinh());
            diaChiThuongTruLB.setText(nhanKhau.getDiaChiHienNay());
        }
        if(khaiBaoYTe.isTiepXucVoiNguoiBenhKhong()) {
            coTiepXucF0RB.setSelected(true);
            khongTiepXucF0RB.setSelected(false);
        }
        else{
            coTiepXucF0RB.setSelected(true);
            khongTiepXucF0RB.setSelected(false);
        }
        if(khaiBaoYTe.isDiVeTuVungDichKhong()) {
            coDiVeRB.setSelected(true);
            khongDiVeRB.setSelected(false);
        }
        else{
            coDiVeRB.setSelected(true);
            khongDiVeRB.setSelected(false);
        }
        if(khaiBaoYTe.isTiepXucVoiNguoiDiVeTuVungDichKhong()) {
            coTiepXucVungDichRB.setSelected(true);
            khongTiepXucVungDichRB.setSelected(false);
        }
        else{
            coTiepXucVungDichRB.setSelected(true);
            khongTiepXucVungDichRB.setSelected(false);
        }
        daDenQuocGiaTF.setText(khaiBaoYTe.getDaDenQuocGia());
        if(khaiBaoYTe.isSot())
            sotCB.setSelected(true);
        else
            sotCB.setSelected(false);
        if(khaiBaoYTe.isHo())
            hoCB.setSelected(true);
        else
            hoCB.setSelected(false);
        if(khaiBaoYTe.isKhoTho())
            khoThoCB.setSelected(true);
        else
            khoThoCB.setSelected(false);
        if(khaiBaoYTe.isViemPhoi())
            viemPhoiCB.setSelected(true);
        else
            viemPhoiCB.setSelected(false);
        if(khaiBaoYTe.isDauHong())
            dauHongCB.setSelected(true);
        else
            dauHongCB.setSelected(false);
        if(khaiBaoYTe.isMetMoi())
            metMoiCB.setSelected(true);
        else
            metMoiCB.setSelected(false);
        if(khaiBaoYTe.isBenhGanManTinh())
            benhGanManTinhCB.setSelected(true);
        else
            benhGanManTinhCB.setSelected(false);
        if(khaiBaoYTe.isBenhMauManTinh())
            benhMauManTinhCB.setSelected(true);
        else
            benhMauManTinhCB.setSelected(false);
        if(khaiBaoYTe.isBenhPhoiManTinh())
            benhPhoiManTinhCB.setSelected(true);
        else
            benhPhoiManTinhCB.setSelected(false);
        if(khaiBaoYTe.isBenhThanManTinh())
            benhThanManTinhCB.setSelected(true);
        else
            benhThanManTinhCB.setSelected(false);
        if(khaiBaoYTe.isBenhTimMach())
            benhTimMachCB.setSelected(true);
        else
            benhTimMachCB.setSelected(false);
        if(khaiBaoYTe.isHuyetApCao())
            huyetApCaoCB.setSelected(true);
        else
            huyetApCaoCB.setSelected(false);
        if(khaiBaoYTe.isHivSuyGiamMienDich())
            hivSuyGiamMienDichCB.setSelected(true);
        else
            hivSuyGiamMienDichCB.setSelected(false);
        if(khaiBaoYTe.isNguoiNhanGhepTang())
            nguoiNhanGhepTangCB.setSelected(true);
        else
            nguoiNhanGhepTangCB.setSelected(false);
        if(khaiBaoYTe.isTieuDuong())
            tieuDuongCB.setSelected(true);
        else
            tieuDuongCB.setSelected(false);
        if(khaiBaoYTe.isUngThu())
            ungThuCB.setSelected(true);
        else
            ungThuCB.setSelected(false);
        if(khaiBaoYTe.isCoThai())
            coThaiCB.setSelected(true);
        else
            coThaiCB.setSelected(false);
        camKetCB.setSelected(true);
        chonNhanKhauBtn.setVisible(false);
        coTiepXucF0RB.setDisable(true);
        khongTiepXucF0RB.setDisable(true);
        coDiVeRB.setDisable(true);
        khongDiVeRB.setDisable(true);
        coTiepXucVungDichRB.setDisable(true);
        khongTiepXucVungDichRB.setDisable(true);
        daDenQuocGiaTF.setDisable(true);

        sotCB.setDisable(true);
        hoCB.setDisable(true);
        khoThoCB.setDisable(true);
        viemPhoiCB.setDisable(true);
        dauHongCB.setDisable(true);
        metMoiCB.setDisable(true);

        benhGanManTinhCB.setDisable(true);
        benhMauManTinhCB.setDisable(true);
        benhPhoiManTinhCB.setDisable(true);
        benhThanManTinhCB.setDisable(true);
        benhTimMachCB.setDisable(true);
        huyetApCaoCB.setDisable(true);
        hivSuyGiamMienDichCB.setDisable(true);
        nguoiNhanGhepTangCB.setDisable(true);
        tieuDuongCB.setDisable(true);
        ungThuCB.setDisable(true);
        coThaiCB.setDisable(true);

        camKetCB.setDisable(true);

    }
}
