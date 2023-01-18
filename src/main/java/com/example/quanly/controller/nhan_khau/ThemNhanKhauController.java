package com.example.quanly.controller.nhan_khau;

import com.example.quanly.Database;
import com.example.quanly.Popup;
import com.example.quanly.models.NhanKhau;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ThemNhanKhauController implements Initializable {
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

    public void initialize(URL location, ResourceBundle resources) {
        gioiTinhChoiceBox.setItems(FXCollections.observableArrayList("Nam", "Nữ"));
        namSinhDatePicker.setValue(LocalDate.now());

        // Converter
        StringConverter<LocalDate> converter = new StringConverter<>() {
            final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            @Override
            public String toString(LocalDate date) {
                if(date != null)
                    return dateTimeFormatter.format(date);
                else
                    return "";
            }

            @Override
            public LocalDate fromString(String string) {
                if(string != null && !string.isEmpty())
                    return LocalDate.parse(string, dateTimeFormatter);
                else
                    return null;
            }
        };
        namSinhDatePicker.setConverter(converter);
        namSinhDatePicker.setPromptText("yyyy-MM-dd");
    }

    @FXML
    private void onXacNhanBtnClick(){
        String maNhanKhau = maNhanKhauTF.getText();
        String hoTen = hoTenTF.getText();
        String bietDanh = bietDanhTF.getText();
        String namSinh = namSinhDatePicker.getValue().toString();
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
        Database.connect();
        Database.insertNhanKhau(nhanKhauMoi);
        Database.close();

        Popup.close();
    }

    @FXML
    private void onHuyBtnClick(){
        Popup.close();
    }
}
