package com.example.quanly.models;

import java.time.LocalDate;

public class DinhChinh {
    private int ID;
    private int idHoKhau;
    private String thongTinThayDoi;
    private String thayDoiTu;
    private String thayDoiThanh;
    private LocalDate ngayThayDoi;
    private int nguoiThayDoi;

    public DinhChinh(int idHoKhau, String thongTinThayDoi, String thayDoiTu, String thayDoiThanh, int nguoiThayDoi) {
        this.idHoKhau = idHoKhau;
        this.thongTinThayDoi = thongTinThayDoi;
        this.thayDoiTu = thayDoiTu;
        this.thayDoiThanh = thayDoiThanh;
        this.ngayThayDoi = LocalDate.now();
        this.nguoiThayDoi = nguoiThayDoi;
    }

    public DinhChinh(int ID, int idHoKhau, String thongTinThayDoi, String thayDoiTu, String thayDoiThanh, LocalDate ngayThayDoi, int nguoiThayDoi) {
        this.ID = ID;
        this.idHoKhau = idHoKhau;
        this.thongTinThayDoi = thongTinThayDoi;
        this.thayDoiTu = thayDoiTu;
        this.thayDoiThanh = thayDoiThanh;
        this.ngayThayDoi = ngayThayDoi;
        this.nguoiThayDoi = nguoiThayDoi;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIdHoKhau() {
        return idHoKhau;
    }

    public void setIdHoKhau(int idHoKhau) {
        this.idHoKhau = idHoKhau;
    }

    public String getThongTinThayDoi() {
        return thongTinThayDoi;
    }

    public void setThongTinThayDoi(String thongTinThayDoi) {
        this.thongTinThayDoi = thongTinThayDoi;
    }

    public String getThayDoiTu() {
        return thayDoiTu;
    }

    public void setThayDoiTu(String thayDoiTu) {
        this.thayDoiTu = thayDoiTu;
    }

    public String getThayDoiThanh() {
        return thayDoiThanh;
    }

    public void setThayDoiThanh(String thayDoiThanh) {
        this.thayDoiThanh = thayDoiThanh;
    }

    public LocalDate getNgayThayDoi() {
        return ngayThayDoi;
    }

    public void setNgayThayDoi(LocalDate ngayThayDoi) {
        this.ngayThayDoi = ngayThayDoi;
    }

    public int getNguoiThayDoi() {
        return nguoiThayDoi;
    }

    public void setNguoiThayDoi(int nguoiThayDoi) {
        this.nguoiThayDoi = nguoiThayDoi;
    }
}
