package com.example.quanly.models;

public class KhaiBaoYTe {
    private int id;
    private String maPhieuKhaiBaoYTe;
    private int idNhanKhau;
    private String thoiGianKhaiBao;
    private boolean tiepXucVoiNguoiBenhKhong;
    private boolean diVeTuVungDichKhong;
    private boolean tiepXucVoiNguoiDiVeTuVungDichKhong;
    private String daDenQuocGia;
    private boolean sot;
    private boolean ho;
    private boolean khoTho;
    private boolean viemPhoi;
    private boolean dauHong;
    private boolean metMoi;
    private boolean benhGanManTinh;
    private boolean benhMauManTinh;
    private boolean benhPhoiManTinh;
    private boolean benhThanManTinh;
    private boolean benhTimMach;
    private boolean huyetApCao;
    private boolean hivSuyGiamMienDich;
    private boolean nguoiNhanGhepTang;
    private boolean tieuDuong;
    private boolean ungThu;
    private boolean coThai;

    public KhaiBaoYTe() {
    }
    public KhaiBaoYTe(int id, String maPhieuKhaiBaoYTe, int idNhanKhau, String ngayKhaiBao,
                      boolean tiepXucVoiNguoiBenhKhong, boolean diVeTuVungDichKhong,
                      boolean tiepXucVoiNguoiDiVeTuVungDichKhong, String daDenQuocGia, boolean sot, boolean ho,
                      boolean khoTho, boolean viemPhoi, boolean dauHong, boolean metMoi, boolean benhGanManTinh,
                      boolean benhMauManTinh, boolean benhPhoiManTinh, boolean benhThanManTinh,
                      boolean benhTimMach, boolean huyetApCao, boolean hivSuyGiamMienDich,
                      boolean nguoiNhanGhepTang, boolean tieuDuong, boolean ungThu, boolean coThai) {
        this.id = id;
        this.maPhieuKhaiBaoYTe = maPhieuKhaiBaoYTe;
        this.idNhanKhau = idNhanKhau;
        this.thoiGianKhaiBao = ngayKhaiBao;
        this.tiepXucVoiNguoiBenhKhong = tiepXucVoiNguoiBenhKhong;
        this.diVeTuVungDichKhong = diVeTuVungDichKhong;
        this.tiepXucVoiNguoiDiVeTuVungDichKhong = tiepXucVoiNguoiDiVeTuVungDichKhong;
        this.daDenQuocGia = daDenQuocGia;
        this.sot = sot;
        this.ho = ho;
        this.khoTho = khoTho;
        this.viemPhoi = viemPhoi;
        this.dauHong = dauHong;
        this.metMoi = metMoi;
        this.benhGanManTinh = benhGanManTinh;
        this.benhMauManTinh = benhMauManTinh;
        this.benhPhoiManTinh = benhPhoiManTinh;
        this.benhThanManTinh = benhThanManTinh;
        this.benhTimMach = benhTimMach;
        this.huyetApCao = huyetApCao;
        this.hivSuyGiamMienDich = hivSuyGiamMienDich;
        this.nguoiNhanGhepTang = nguoiNhanGhepTang;
        this.tieuDuong = tieuDuong;
        this.ungThu = ungThu;
        this.coThai = coThai;
    }
    public KhaiBaoYTe(String maPhieuKhaiBaoYTe, int idNhanKhau, String ngayKhaiBao,
                      boolean tiepXucVoiNguoiBenhKhong, boolean diVeTuVungDichKhong,
                      boolean tiepXucVoiNguoiDiVeTuVungDichKhong, String daDenQuocGia, boolean sot, boolean ho,
                      boolean khoTho, boolean viemPhoi, boolean dauHong, boolean metMoi, boolean benhGanManTinh,
                      boolean benhMauManTinh, boolean benhPhoiManTinh, boolean benhThanManTinh,
                      boolean benhTimMach, boolean huyetApCao, boolean hivSuyGiamMienDich,
                      boolean nguoiNhanGhepTang, boolean tieuDuong, boolean ungThu, boolean coThai){
        this.maPhieuKhaiBaoYTe = maPhieuKhaiBaoYTe;
        this.idNhanKhau = idNhanKhau;
        this.thoiGianKhaiBao = ngayKhaiBao;
        this.tiepXucVoiNguoiBenhKhong = tiepXucVoiNguoiBenhKhong;
        this.diVeTuVungDichKhong = diVeTuVungDichKhong;
        this.tiepXucVoiNguoiDiVeTuVungDichKhong = tiepXucVoiNguoiDiVeTuVungDichKhong;
        this.daDenQuocGia = daDenQuocGia;
        this.sot = sot;
        this.ho = ho;
        this.khoTho = khoTho;
        this.viemPhoi = viemPhoi;
        this.dauHong = dauHong;
        this.metMoi = metMoi;
        this.benhGanManTinh = benhGanManTinh;
        this.benhMauManTinh = benhMauManTinh;
        this.benhPhoiManTinh = benhPhoiManTinh;
        this.benhThanManTinh = benhThanManTinh;
        this.benhTimMach = benhTimMach;
        this.huyetApCao = huyetApCao;
        this.hivSuyGiamMienDich = hivSuyGiamMienDich;
        this.nguoiNhanGhepTang = nguoiNhanGhepTang;
        this.tieuDuong = tieuDuong;
        this.ungThu = ungThu;
        this.coThai = coThai;
    }
    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getMaPhieuKhaiBaoYTe() {
        return maPhieuKhaiBaoYTe;
    }

    public void setMaPhieuKhaiBaoYTe(String maPhieuKhaiBaoYTe) {
        this.maPhieuKhaiBaoYTe = maPhieuKhaiBaoYTe;
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

    public boolean isTiepXucVoiNguoiBenhKhong() {
        return tiepXucVoiNguoiBenhKhong;
    }

    public void setTiepXucVoiNguoiBenhKhong(boolean tiepXucVoiNguoiBenhKhong) {
        this.tiepXucVoiNguoiBenhKhong = tiepXucVoiNguoiBenhKhong;
    }

    public boolean isDiVeTuVungDichKhong() {
        return diVeTuVungDichKhong;
    }

    public void setDiVeTuVungDichKhong(boolean diVeTuVungDichKhong) {
        this.diVeTuVungDichKhong = diVeTuVungDichKhong;
    }

    public boolean isTiepXucVoiNguoiDiVeTuVungDichKhong() {
        return tiepXucVoiNguoiDiVeTuVungDichKhong;
    }

    public void setTiepXucVoiNguoiDiVeTuVungDichKhong(boolean tiepXucVoiNguoiDiVeTuVungDichKhong) {
        this.tiepXucVoiNguoiDiVeTuVungDichKhong = tiepXucVoiNguoiDiVeTuVungDichKhong;
    }

    public String getDaDenQuocGia() {
        return daDenQuocGia;
    }

    public void setDaDenQuocGia(String daDenQuocGia) {
        this.daDenQuocGia = daDenQuocGia;
    }

    public boolean isSot() {
        return sot;
    }

    public void setSot(boolean sot) {
        this.sot = sot;
    }

    public boolean isHo() {
        return ho;
    }

    public void setHo(boolean ho) {
        this.ho = ho;
    }

    public boolean isKhoTho() {
        return khoTho;
    }

    public void setKhoTho(boolean khoTho) {
        this.khoTho = khoTho;
    }

    public boolean isViemPhoi() {
        return viemPhoi;
    }

    public void setViemPhoi(boolean viemPhoi) {
        this.viemPhoi = viemPhoi;
    }

    public boolean isDauHong() {
        return dauHong;
    }

    public void setDauHong(boolean dauHong) {
        this.dauHong = dauHong;
    }

    public boolean isMetMoi() {
        return metMoi;
    }

    public void setMetMoi(boolean metMoi) {
        this.metMoi = metMoi;
    }

    public boolean isBenhGanManTinh() {
        return benhGanManTinh;
    }

    public void setBenhGanManTinh(boolean benhGanManTinh) {
        this.benhGanManTinh = benhGanManTinh;
    }

    public boolean isBenhMauManTinh() {
        return benhMauManTinh;
    }

    public void setBenhMauManTinh(boolean benhMauManTinh) {
        this.benhMauManTinh = benhMauManTinh;
    }

    public boolean isBenhPhoiManTinh() {
        return benhPhoiManTinh;
    }

    public void setBenhPhoiManTinh(boolean benhPhoiManTinh) {
        this.benhPhoiManTinh = benhPhoiManTinh;
    }

    public boolean isBenhThanManTinh() {
        return benhThanManTinh;
    }

    public void setBenhThanManTinh(boolean benhThanManTinh) {
        this.benhThanManTinh = benhThanManTinh;
    }

    public boolean isBenhTimMach() {
        return benhTimMach;
    }

    public void setBenhTimMach(boolean benhTimMach) {
        this.benhTimMach = benhTimMach;
    }

    public boolean isHuyetApCao() {
        return huyetApCao;
    }

    public void setHuyetApCao(boolean huyetApCao) {
        this.huyetApCao = huyetApCao;
    }

    public boolean isHivSuyGiamMienDich() {
        return hivSuyGiamMienDich;
    }

    public void setHivSuyGiamMienDich(boolean hivSuyGiamMienDich) {
        this.hivSuyGiamMienDich = hivSuyGiamMienDich;
    }

    public boolean isNguoiNhanGhepTang() {
        return nguoiNhanGhepTang;
    }

    public void setNguoiNhanGhepTang(boolean nguoiNhanGhepTang) {
        this.nguoiNhanGhepTang = nguoiNhanGhepTang;
    }

    public boolean isTieuDuong() {
        return tieuDuong;
    }

    public void setTieuDuong(boolean tieuDuong) {
        this.tieuDuong = tieuDuong;
    }

    public boolean isUngThu() {
        return ungThu;
    }

    public void setUngThu(boolean ungThu) {
        this.ungThu = ungThu;
    }

    public boolean isCoThai() {
        return coThai;
    }

    public void setCoThai(boolean coThai) {
        this.coThai = coThai;
    }
}
