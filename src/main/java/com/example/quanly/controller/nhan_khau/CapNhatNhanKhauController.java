package com.example.quanly.controller.nhan_khau;

import com.example.quanly.Database;
import com.example.quanly.Popup;
import com.example.quanly.models.NhanKhau;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.LocalDateStringConverter;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class CapNhatNhanKhauController implements Initializable {
    public TextField maNhanKhauTF;
    public TextField hoTenTF;
    public TextField bietDanhTF;
    @FXML
    private DatePicker namSinhDatePicker;
    @FXML
    private ChoiceBox<String> gioiTinhChoiceBox;
    public TextField nguyenQuanTF;
    public TextField danTocTF;
    public TextField tonGiaoTF;
    public TextField quocTichTF;
    public TextField soHoChieuTF;
    public TextField noiThuongTruTF;
    public TextField diaChiHienNayTF;
    public TextField trinhDoHocVanTF;
    public TextField trinhDoChuyenMonTF;
    public TextField bietTiengDanTocTF;
    public TextField trinhDoNgoaiNguTF;
    public TextField ngheNghiepTF;
    public TextField noiLamViecTF;
    public TextField noiSinhTF;
    public TextField tienAnTF;
    public TextField ngayChuyenDenTF;
    public TextField lyDoChuyenDenTF;
    public TextField ngayChuyenDiTF;
    public TextField lyDoChuyenDiTF;
    public TextField diaChiMoiTF;
    public TextField ghiChuTF;

    public Button huyBtn;
    NhanKhau nhanKhauSua;
    public CapNhatNhanKhauController(NhanKhau nhanKhauSua){
        this.nhanKhauSua = nhanKhauSua;
    }
    public void initialize(URL location, ResourceBundle resources) {
        gioiTinhChoiceBox.setItems(FXCollections.observableArrayList("Nam", "Nữ"));
        gioiTinhChoiceBox.setValue(this.nhanKhauSua.getGioiTinh());
        namSinhDatePicker.setValue(nhanKhauSua.getNamSinh());

        maNhanKhauTF.setText(this.nhanKhauSua.getMaNhanKhau());
        hoTenTF.setText(this.nhanKhauSua.getHoTen());
        bietDanhTF.setText(this.nhanKhauSua.getBietDanh());
        nguyenQuanTF.setText(this.nhanKhauSua.getNguyenQuan());
        danTocTF.setText(this.nhanKhauSua.getDanToc());
        tonGiaoTF.setText(this.nhanKhauSua.getTonGiao());
        quocTichTF.setText(this.nhanKhauSua.getQuocTich());
        soHoChieuTF.setText(this.nhanKhauSua.getSoHoChieu());
        noiThuongTruTF.setText(this.nhanKhauSua.getNoiThuongTru());
        diaChiHienNayTF.setText(this.nhanKhauSua.getDiaChiHienNay());
        trinhDoHocVanTF.setText(this.nhanKhauSua.getTrinhDoHocVan());
        trinhDoChuyenMonTF.setText(this.nhanKhauSua.getTrinhDoChuyenMon());
        bietTiengDanTocTF.setText(this.nhanKhauSua.getBietTiengDanToc());
        trinhDoNgoaiNguTF.setText(this.nhanKhauSua.getTrinhDoNgoaiNgu());
        ngheNghiepTF.setText(this.nhanKhauSua.getNgheNghiep());
        noiLamViecTF.setText(this.nhanKhauSua.getNoiLamViec());
        noiSinhTF.setText(this.nhanKhauSua.getNoiSinh());
        tienAnTF.setText(this.nhanKhauSua.getTienAn());
        ngayChuyenDenTF.setText(this.nhanKhauSua.getNgayChuyenDen());
        lyDoChuyenDenTF.setText(this.nhanKhauSua.getLyDoChuyenDen());
        ngayChuyenDiTF.setText(this.nhanKhauSua.getNgayChuyenDi());
        lyDoChuyenDiTF.setText(this.nhanKhauSua.getLyDoChuyenDi());
        diaChiMoiTF.setText(this.nhanKhauSua.getDiaChiMoi());
        ghiChuTF.setText(this.nhanKhauSua.getGhiChu());
    }

    @FXML
    private void onCapNhatBtnClick(){
        String maNhanKhau = maNhanKhauTF.getText();
        String hoTen = hoTenTF.getText();
        String bietDanh = bietDanhTF.getText();
        LocalDate namSinh = namSinhDatePicker.getValue();
        String gioiTinh = gioiTinhChoiceBox.getValue();
        String noiSinh = noiSinhTF.getText();
        String nguyenQuan = nguyenQuanTF.getText();
        String danToc = danTocTF.getText();
        String tonGiao = tonGiaoTF.getText();
        String quocTich = quocTichTF.getText();
        String soHoChieu = soHoChieuTF.getText();
        String noiThuongTru = noiThuongTruTF.getText();
        String diaChiHienNay = diaChiHienNayTF.getText();
        String trinhDoHocVan = trinhDoHocVanTF.getText();
        String trinhDoChuyenMon = trinhDoChuyenMonTF.getText();
        String bietTiengDanToc = bietTiengDanTocTF.getText();
        String trinhDoNgoaiNgu = trinhDoNgoaiNguTF.getText();
        String ngheNghiep = ngheNghiepTF.getText();
        String noiLamViec = noiLamViecTF.getText();
        String tienAn = tienAnTF.getText();
        String ngayChuyenDen = null;
        String lyDoChuyenDen = lyDoChuyenDenTF.getText();
        String ngayChuyenDi = null;
        String lyDoChuyenDi = lyDoChuyenDiTF.getText();
        String diaChiMoi = diaChiMoiTF.getText();
        String ghiChu = ghiChuTF.getText();
        NhanKhau nhanKhauMoi = new NhanKhau(maNhanKhau, hoTen, bietDanh, namSinh, gioiTinh, noiSinh, nguyenQuan,
                danToc, tonGiao, quocTich, soHoChieu, noiThuongTru, diaChiHienNay, trinhDoHocVan, trinhDoChuyenMon,
                bietTiengDanToc, trinhDoNgoaiNgu, ngheNghiep, noiLamViec, tienAn, ngayChuyenDen,
                lyDoChuyenDen, ngayChuyenDi, lyDoChuyenDi, diaChiMoi, ghiChu);

        Database.updateOneNhanhKhau(nhanKhauSua, nhanKhauMoi);

        this.onHuyBtnClick(null);
    }


    public void onHuyBtnClick(ActionEvent actionEvent) {
        Stage stage  = (Stage) huyBtn.getScene().getWindow();
        stage.close();
    }
}
