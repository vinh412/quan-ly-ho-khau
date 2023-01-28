package com.example.quanly.controller.ho_khau;

import com.example.quanly.models.NhanKhau;

public interface IChonThanhVien {
    void onThanhVienReceived(NhanKhau thanhVien, String quanHeVoiChuHo);
}
