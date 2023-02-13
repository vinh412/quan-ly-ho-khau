package com.example.quanly.models;

import com.example.quanly.Database;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class GiayTamTru {
    private int ID;
    private int idNhanKhau;
    private String maGiayTamTru;
    private String diaChiThuongTru;
    private String diaChiTamTru;
    private String soDienThoaiNguoiDangKy;
    private LocalDate tuNgay;
    private LocalDate denNgay;
    private String lyDo;
    private NhanKhau nhanKhau;
    // nhan khau properties
    private String hoTen;
    private LocalDate namSinh;

    public String getHoTen() {
        return this.nhanKhau.getHoTen();
    }
    public LocalDate getNamSinh() {
        return this.nhanKhau.getNamSinh();
    }
    // construct object with data from database

    public GiayTamTru(int ID, int idNhanKhau, String maGiayTamtru, String diaChiThuongTru, String diaChiTamTru, String soDienThoaiNguoiDangKy, LocalDate tuNgay, LocalDate denNgay, String lyDo) {
        this.ID = ID;
        this.idNhanKhau = idNhanKhau;
        this.maGiayTamTru = maGiayTamtru;
        this.diaChiThuongTru = diaChiThuongTru;
        this.diaChiTamTru = diaChiTamTru;
        this.soDienThoaiNguoiDangKy = soDienThoaiNguoiDangKy;
        this.tuNgay = tuNgay;
        this.denNgay = denNgay;
        this.lyDo = lyDo;
        ArrayList<NhanKhau> nhanKhauArrayList = Database.findNhanKhau("ID", idNhanKhau);
        this.nhanKhau = nhanKhauArrayList.get(0);
    }

    // construct object with data from application
    public GiayTamTru(NhanKhau nhanKhau, String maGiayTamtru, String diaChiThuongTru, String diaChiTamTru, String soDienThoaiNguoiDangKy, LocalDate tuNgay, LocalDate denNgay, String lyDo) {
        this.nhanKhau = nhanKhau;
        this.maGiayTamTru = maGiayTamtru;
        this.diaChiThuongTru = diaChiThuongTru;
        this.diaChiTamTru = diaChiTamTru;
        this.soDienThoaiNguoiDangKy = soDienThoaiNguoiDangKy;
        this.tuNgay = tuNgay;
        this.denNgay = denNgay;
        this.lyDo = lyDo;
    }

    public String getDiaChiThuongTru() {
        return diaChiThuongTru;
    }

    public void setDiaChiThuongTru(String diaChiThuongTru) {
        this.diaChiThuongTru = diaChiThuongTru;
    }

    public String getDiaChiTamTru() {
        return diaChiTamTru;
    }

    public void setDiaChiTamTru(String diaChiTamTru) {
        this.diaChiTamTru = diaChiTamTru;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIdNhanKhau() {
        return idNhanKhau;
    }

    public void setIdNhanKhau(int idNhanKhau) {
        this.idNhanKhau = idNhanKhau;
    }

    public String getMaGiayTamTru() {
        return maGiayTamTru;
    }

    public void setMaGiayTamTru(String maGiayTamtru) {
        this.maGiayTamTru = maGiayTamtru;
    }

    public String getSoDienThoaiNguoiDangKy() {
        return soDienThoaiNguoiDangKy;
    }

    public void setSoDienThoaiNguoiDangKy(String soDienThoaiNguoiDangKy) {
        this.soDienThoaiNguoiDangKy = soDienThoaiNguoiDangKy;
    }

    public LocalDate getTuNgay() {
        return tuNgay;
    }

    public void setTuNgay(LocalDate tuNgay) {
        this.tuNgay = tuNgay;
    }

    public LocalDate getDenNgay() {
        return denNgay;
    }

    public void setDenNgay(LocalDate denNgay) {
        this.denNgay = denNgay;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public NhanKhau getNhanKhau() {
        return nhanKhau;
    }

    public void setNhanKhau(NhanKhau nhanKhau) {
        this.nhanKhau = nhanKhau;
    }


}
