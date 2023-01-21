package com.example.quanly.models;

import java.time.LocalDate;

public class GiayTamVang {
    private int ID;
    private int idNhanKhau;
    private String maGiayTamVang;
    private String noiTamtru;
    private LocalDate tuNgay;
    private LocalDate denNgay;
    private String lyDo;
    private NhanKhau nhanKhau;
    // construct object with data from database
    public GiayTamVang(int ID, int idNhanKhau, String maGiayTamVang, String noiTamtru, LocalDate tuNgay, LocalDate denNgay, String lyDo){
        this.ID = ID;
        this.idNhanKhau = idNhanKhau;
        this.maGiayTamVang = maGiayTamVang;
        this.noiTamtru = noiTamtru;
        this.tuNgay = tuNgay;
        this.denNgay = denNgay;
        this.lyDo = lyDo;
    }
    // construct object with data from application
    public GiayTamVang(NhanKhau nhanKhau, String maGiayTamVang, String noiTamtru, LocalDate tuNgay, LocalDate denNgay, String lyDo){
        this.nhanKhau = nhanKhau;
        this.maGiayTamVang = maGiayTamVang;
        this.noiTamtru = noiTamtru;
        this.tuNgay = tuNgay;
        this.denNgay = denNgay;
        this.lyDo = lyDo;
        this.idNhanKhau = this.nhanKhau.getID();
    }

    public NhanKhau getNhanKhau() {
        return nhanKhau;
    }

    public void setNhanKhau(NhanKhau nhanKhau) {
        this.nhanKhau = nhanKhau;
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

    public String getMaGiayTamVang() {
        return maGiayTamVang;
    }

    public void setMaGiayTamVang(String maGiayTamVang) {
        this.maGiayTamVang = maGiayTamVang;
    }

    public String getNoiTamtru() {
        return noiTamtru;
    }

    public void setNoiTamtru(String noiTamtru) {
        this.noiTamtru = noiTamtru;
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
}
