package com.example.quanly.models;

import java.time.LocalDate;

public class HoKhau {
    private String maHoKhau;
    private String maKhuVuc;
    private String diaChi;
    private String ngayLap;
    private String ngayChuyenDi;
    private String lyDoChuyen;
    private String idChuHo;
    private String nguoiThucHien;
    private NhanKhau chuHo;

    // construct `ho_khau` from data in database
    public HoKhau(String maHoKhau, String idChuHo, String maKhuVuc, String diaChi, String ngayLap, String ngayChuyenDi, String lyDoChuyen){
        this.maHoKhau = maHoKhau;
        this.maKhuVuc = maKhuVuc;
        this.diaChi = diaChi;
        this.ngayLap = ngayLap;
        this.ngayChuyenDi = ngayChuyenDi;
        this.lyDoChuyen = lyDoChuyen;
        this.idChuHo = idChuHo;
    }
    // construct `ho_khau` from application
    public HoKhau(String maHoKhau, NhanKhau chuHo, String maKhuVuc, String diaChi, String ngayChuyenDi, String lyDoChuyen){
        this.maHoKhau = maHoKhau;
        this.maKhuVuc = maKhuVuc;
        this.diaChi = diaChi;
        this.ngayLap = LocalDate.now().toString();
        this.ngayChuyenDi = ngayChuyenDi;
        this.lyDoChuyen = lyDoChuyen;
        this.idChuHo = String.valueOf(chuHo.getID());
        this.chuHo = chuHo;
    }

    public NhanKhau getChuHo() {
        return chuHo;
    }

    public void setChuHo(NhanKhau chuHo) {
        this.chuHo = chuHo;
    }

    public String getNguoiThucHien() {
        return nguoiThucHien;
    }

    public void setNguoiThucHien(String nguoiThucHien) {
        this.nguoiThucHien = nguoiThucHien;
    }

    public String getIdChuHo() {
        return idChuHo;
    }

    public void setIdChuHo(String idChuHo) {
        this.idChuHo = idChuHo;
    }

    public String getMaHoKhau() {
        return maHoKhau;
    }

    public void setMaHoKhau(String maHoKhau) {
        this.maHoKhau = maHoKhau;
    }

    public String getMaKhuVuc() {
        return maKhuVuc;
    }

    public void setMaKhuVuc(String maKhuVuc) {
        this.maKhuVuc = maKhuVuc;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getNgayChuyenDi() {
        return ngayChuyenDi;
    }

    public void setNgayChuyenDi(String ngayChuyenDi) {
        this.ngayChuyenDi = ngayChuyenDi;
    }

    public String getLyDoChuyen() {
        return lyDoChuyen;
    }

    public void setLyDoChuyen(String lyDoChuyen) {
        this.lyDoChuyen = lyDoChuyen;
    }
}

