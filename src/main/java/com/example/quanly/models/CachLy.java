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
    private boolean daTestCovidChua;
    private String hinhThucTest;
    private int soLanTest;
    private String thoiDiemTest;
    private String ketQuaCacLanTest;

    public CachLy() {
    }

    public CachLy(int id, String maCachLy, int idNhanKhau, String thoiGianKhaiBao, String diaDiemCachLy, String tuNgay, String denNgay, String mucDoCachLy, boolean daTestCovidChua, String hinhThucTest, int soLanTest, String thoiDiemTest, String ketQuaCacLanTest) {
        this.id = id;
        this.maCachLy = maCachLy;
        this.idNhanKhau = idNhanKhau;
        this.thoiGianKhaiBao = thoiGianKhaiBao;
        this.diaDiemCachLy = diaDiemCachLy;
        this.tuNgay = tuNgay;
        this.denNgay = denNgay;
        this.mucDoCachLy = mucDoCachLy;
        this.daTestCovidChua = daTestCovidChua;
        this.hinhThucTest = hinhThucTest;
        this.soLanTest = soLanTest;
        this.thoiDiemTest = thoiDiemTest;
        this.ketQuaCacLanTest = ketQuaCacLanTest;
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

    public boolean isDaTestCovidChua() {
        return daTestCovidChua;
    }

    public void setDaTestCovidChua(boolean daTestCovidChua) {
        this.daTestCovidChua = daTestCovidChua;
    }

    public String getHinhThucTest() {
        return hinhThucTest;
    }

    public void setHinhThucTest(String hinhThucTest) {
        this.hinhThucTest = hinhThucTest;
    }

    public int getSoLanTest() {
        return soLanTest;
    }

    public void setSoLanTest(int soLanTest) {
        this.soLanTest = soLanTest;
    }

    public String getThoiDiemTest() {
        return thoiDiemTest;
    }

    public void setThoiDiemTest(String thoiDiemTest) {
        this.thoiDiemTest = thoiDiemTest;
    }

    public String getKetQuaCacLanTest() {
        return ketQuaCacLanTest;
    }

    public void setKetQuaCacLanTest(String ketQuaCacLanTest) {
        this.ketQuaCacLanTest = ketQuaCacLanTest;
    }
}
