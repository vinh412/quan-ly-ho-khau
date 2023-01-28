package com.example.quanly.models;

public class CachLy {
    private int id;
    private String maCachLy;
    private int idNhanKhau;
    private String thoiGianKhaiBao;
    private String diaDiemCachLy;
    private String tuNgay;
    private String denNgay;
    private String mucDoCachLy;

    public CachLy() {
    }

    public CachLy(int id, String maCachLy, int idNhanKhau, String thoiGianKhaiBao, String diaDiemCachLy, String tuNgay, String denNgay, String mucDoCachLy) {
        this.id = id;
        this.maCachLy = maCachLy;
        this.idNhanKhau = idNhanKhau;
        this.thoiGianKhaiBao = thoiGianKhaiBao;
        this.diaDiemCachLy = diaDiemCachLy;
        this.tuNgay = tuNgay;
        this.denNgay = denNgay;
        this.mucDoCachLy = mucDoCachLy;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getMaCachLy() {
        return maCachLy;
    }

    public void setMaCachLy(String maCachLy) {
        this.maCachLy = maCachLy;
    }

    public int getIdNhanKhau() {
        return idNhanKhau;
    }

    public void setIdNhanKhau(int idNhanKhau) {
        this.idNhanKhau = idNhanKhau;
    }

    public String getThoiGianKhaiBao() {
        return thoiGianKhaiBao;
    }

    public void setThoiGianKhaiBao(String thoiGianKhaiBao) {
        this.thoiGianKhaiBao = thoiGianKhaiBao;
    }

    public String getDiaDiemCachLy() {
        return diaDiemCachLy;
    }

    public void setDiaDiemCachLy(String diaDiemCachLy) {
        this.diaDiemCachLy = diaDiemCachLy;
    }

    public String getTuNgay() {
        return tuNgay;
    }

    public void setTuNgay(String tuNgay) {
        this.tuNgay = tuNgay;
    }

    public String getDenNgay() {
        return denNgay;
    }

    public void setDenNgay(String denNgay) {
        this.denNgay = denNgay;
    }

    public String getMucDoCachLy() {
        return mucDoCachLy;
    }

    public void setMucDoCachLy(String mucDoCachLy) {
        this.mucDoCachLy = mucDoCachLy;
    }
}
