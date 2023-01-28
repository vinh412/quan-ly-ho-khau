package com.example.quanly.models;

public class ThanhVienTrongHo {
    private NhanKhau thanhVien;
    private NhanKhau chuHo;
    private String quanHeVoiChuHo;
    public ThanhVienTrongHo(NhanKhau chuHo, NhanKhau thanhVien, String quanHeVoiChuHo){
        this.chuHo = chuHo;
        this.thanhVien = thanhVien;
        this.quanHeVoiChuHo = quanHeVoiChuHo;
    }

    public NhanKhau getThanhVien() {
        return thanhVien;
    }

    public void setThanhVien(NhanKhau thanhVien) {
        this.thanhVien = thanhVien;
    }

    public NhanKhau getChuHo() {
        return chuHo;
    }

    public void setChuHo(NhanKhau chuHo) {
        this.chuHo = chuHo;
    }

    public String getQuanHeVoiChuHo() {
        return quanHeVoiChuHo;
    }

    public void setQuanHeVoiChuHo(String quanHeVoiChuHo) {
        this.quanHeVoiChuHo = quanHeVoiChuHo;
    }
}
