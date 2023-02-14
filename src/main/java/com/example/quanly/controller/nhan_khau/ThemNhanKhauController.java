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

import java.net.URL;
import java.sql.Date;
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
    public TextField soCmtTF;
    public Button huyBtn;
    public void initialize(URL location, ResourceBundle resources) {
        gioiTinhChoiceBox.setItems(FXCollections.observableArrayList("Nam", "Nữ"));
        gioiTinhChoiceBox.setValue("Nam");
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
    public void onXacNhanBtnClick(){
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

        Database.insertOneNhanKhau(nhanKhauMoi);

        }


    public void onHuyBtnClick(ActionEvent actionEvent) {
        Stage stage  = (Stage) huyBtn.getScene().getWindow();
        stage.close();
    }

    public void showThongTinNhanKhau(NhanKhau nhanKhau){
        maNhanKhauTF.setText(nhanKhau.getMaNhanKhau());
        hoTenTF.setText(nhanKhau.getHoTen());
        bietDanhTF.setText(nhanKhau.getBietDanh());
        namSinhDatePicker.setValue(nhanKhau.getNamSinh());
        gioiTinhChoiceBox.setValue(nhanKhau.getGioiTinh());
        nguyenQuanTF.setText(nhanKhau.getNguyenQuan());
        danTocTF.setText(nhanKhau.getDanToc());
        tonGiaoTF.setText(nhanKhau.getTonGiao());
        quocTichTF.setText(nhanKhau.getQuocTich());
        soHoChieuTF.setText(nhanKhau.getSoHoChieu());
        noiThuongTruTF.setText(nhanKhau.getNoiThuongTru());
        diaChiHienNayTF.setText(nhanKhau.getDiaChiHienNay());
        trinhDoHocVanTF.setText(nhanKhau.getTrinhDoHocVan());
        trinhDoChuyenMonTF.setText(nhanKhau.getTrinhDoChuyenMon());
        bietTiengDanTocTF.setText(nhanKhau.getBietTiengDanToc());
        trinhDoNgoaiNguTF.setText(nhanKhau.getTrinhDoNgoaiNgu());
        ngheNghiepTF.setText(nhanKhau.getNgheNghiep());
        noiLamViecTF.setText(nhanKhau.getNoiLamViec());
        noiSinhTF.setText(nhanKhau.getNoiSinh());
        tienAnTF.setText(nhanKhau.getTienAn());
        ngayChuyenDenTF.setText(nhanKhau.getNgayChuyenDen());
        lyDoChuyenDenTF.setText(nhanKhau.getLyDoChuyenDen());
        ngayChuyenDiTF.setText(nhanKhau.getNgayChuyenDi());
        lyDoChuyenDiTF.setText(nhanKhau.getLyDoChuyenDi());
        diaChiMoiTF.setText(nhanKhau.getDiaChiMoi());
        ghiChuTF.setText(nhanKhau.getGhiChu());

        maNhanKhauTF.setDisable(true);
        hoTenTF.setDisable(true);
        bietDanhTF.setDisable(true);
        namSinhDatePicker.setDisable(true);
        gioiTinhChoiceBox.setDisable(true);
        nguyenQuanTF.setDisable(true);
        danTocTF.setDisable(true);
        tonGiaoTF.setDisable(true);
        quocTichTF.setDisable(true);
        soHoChieuTF.setDisable(true);
        noiThuongTruTF.setDisable(true);
        diaChiHienNayTF.setDisable(true);
        trinhDoHocVanTF.setDisable(true);
        trinhDoChuyenMonTF.setDisable(true);
        bietTiengDanTocTF.setDisable(true);
        trinhDoNgoaiNguTF.setDisable(true);
        ngheNghiepTF.setDisable(true);
        noiLamViecTF.setDisable(true);
        noiSinhTF.setDisable(true);
        tienAnTF.setDisable(true);
        ngayChuyenDenTF.setDisable(true);
        lyDoChuyenDenTF.setDisable(true);
        ngayChuyenDiTF.setDisable(true);
        lyDoChuyenDiTF.setDisable(true);
        diaChiMoiTF.setDisable(true);
        ghiChuTF.setDisable(true);
        soCmtTF.setDisable(true);
    }
}
