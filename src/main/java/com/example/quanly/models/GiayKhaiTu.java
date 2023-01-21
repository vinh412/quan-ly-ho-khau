package com.example.quanly.models;

import java.time.LocalDate;

public class GiayKhaiTu {
    private int ID;
    private String soGiayKhaiTu;
    private int idNguoiKhai;
    private int idNguoiChet;
    private LocalDate ngayKhai;
    private LocalDate ngayChet;
    private String lyDoChet;
    private NhanKhau nhanKhau;
    // construct object with data from database

    public GiayKhaiTu(int ID, String soGiayKhaiTu, int idNguoiKhai, int idNguoiChet, LocalDate ngayKhai, LocalDate ngayChet, String lyDoChet) {
        this.ID = ID;
        this.soGiayKhaiTu = soGiayKhaiTu;
        this.idNguoiKhai = idNguoiKhai;
        this.idNguoiChet = idNguoiChet;
        this.ngayKhai = ngayKhai;
        this.ngayChet = ngayChet;
        this.lyDoChet = lyDoChet;
    }
    // construct object with data from application
    public GiayKhaiTu(NhanKhau nhanKhau, String soGiayKhaiTu, int idNguoiKhai, LocalDate ngayKhai, LocalDate ngayChet, String lyDoChet) {
        this.nhanKhau = nhanKhau;
        this.soGiayKhaiTu = soGiayKhaiTu;
        this.idNguoiKhai = idNguoiKhai;
        this.idNguoiChet = this.nhanKhau.getID();
        this.ngayKhai = ngayKhai;
        this.ngayChet = ngayChet;
        this.lyDoChet = lyDoChet;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSoGiayKhaiTu() {
        return soGiayKhaiTu;
    }

    public void setSoGiayKhaiTu(String soGiayKhaiTu) {
        this.soGiayKhaiTu = soGiayKhaiTu;
    }

    public int getIdNguoiKhai() {
        return idNguoiKhai;
    }

    public void setIdNguoiKhai(int idNguoiKhai) {
        this.idNguoiKhai = idNguoiKhai;
    }

    public int getIdNguoiChet() {
        return idNguoiChet;
    }

    public void setIdNguoiChet(int idNguoiChet) {
        this.idNguoiChet = idNguoiChet;
    }

    public LocalDate getNgayKhai() {
        return ngayKhai;
    }

    public void setNgayKhai(LocalDate ngayKhai) {
        this.ngayKhai = ngayKhai;
    }

    public LocalDate getNgayChet() {
        return ngayChet;
    }

    public void setNgayChet(LocalDate ngayChet) {
        this.ngayChet = ngayChet;
    }

    public String getLyDoChet() {
        return lyDoChet;
    }

    public void setLyDoChet(String lyDoChet) {
        this.lyDoChet = lyDoChet;
    }

    public NhanKhau getNhanKhau() {
        return nhanKhau;
    }

    public void setNhanKhau(NhanKhau nhanKhau) {
        this.nhanKhau = nhanKhau;
    }
}
