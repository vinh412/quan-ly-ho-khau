package com.example.quanly;

import com.example.quanly.models.HoKhau;
import com.example.quanly.models.NhanKhau;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Database {
    private static Connection conn = null;
    public static void connect() {
//        Connection conn = null;
        String dbURL = "jdbc:mysql://localhost/quanlyhokhau";
        String username = "root";
        String password = "";
        try {
            conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null)
                System.out.println("Ket noi thanh cong");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertNhanKhau(NhanKhau nhanKhau){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String maNhanKhau = nhanKhau.getMaNhanKhau();
        String hoTen = nhanKhau.getHoTen();
        String bietDanh = nhanKhau.getBietDanh();
        String namSinh = nhanKhau.getNamSinh();
        String gioiTinh = nhanKhau.getGioiTinh();
        String noiSinh = nhanKhau.getNoiSinh();
        String nguyenQuan = nhanKhau.getNguyenQuan();
        String danToc = nhanKhau.getDanToc();
        String tonGiao = nhanKhau.getTonGiao();
        String quocTich = nhanKhau.getQuocTich();
        String soHoChieu = nhanKhau.getSoHoChieu();
        String noiThuongTru = nhanKhau.getNoiThuongTru();
        String diaChiHienNay = nhanKhau.getDiaChiHienNay();
        String trinhDoHocVan = nhanKhau.getTrinhDoHocVan();
        String trinhDoChuyenMon = nhanKhau.getTrinhDoChuyenMon();
        String bietTiengDanToc = nhanKhau.getBietTiengDanToc();
        String trinhDoNgoaiNgu = nhanKhau.getTrinhDoNgoaiNgu();
        String ngheNghiep = nhanKhau.getNgheNghiep();
        String noiLamViec = nhanKhau.getNoiLamViec();
        String tienAn = nhanKhau.getTienAn();
        String ngayChuyenDen = nhanKhau.getNgayChuyenDen();
        String lyDoChuyenDen = nhanKhau.getLyDoChuyenDen();
        String ngayChuyenDi = nhanKhau.getNgayChuyenDi();
        String lyDoChuyenDi = nhanKhau.getLyDoChuyenDi();
        String diaChiMoi = nhanKhau.getDiaChiMoi();
        String ngayTao = LocalDate.now().format(dateFormatter);
        //int idNguoiTao = nhanKhau.getIdNguoiTao();
        //String ngayXoa = nhanKhau.getNgayXoa();
        //int idNguoiXoa = nhanKhau.getIdNguoiXoa();
        //String lyDoXoa = nhanKhau.getLyDoXoa();
        String ghiChu = nhanKhau.getGhiChu();

        String sql = "INSERT INTO `nhan_khau` (`maNhanKhau`, `hoTen`, `bietDanh`, `namSinh`, `gioiTinh`, `noiSinh`, " +
                "`nguyenQuan`, `danToc`, `tonGiao`, `quocTich`, `soHoChieu`, `noiThuongTru`, `diaChiHienNay` ," +
                "`trinhDoHocVan`, `trinhDoChuyenMon`, `bietTiengDanToc`, `trinhDoNgoaiNgu`, `ngheNghiep`, " +
                "`noiLamViec`, `tienAn`, `ngayChuyenDen`, `lyDoChuyenDen`, `ngayChuyenDi`, `lyDoChuyenDi`, " +
                "`diaChiMoi`, `ngayTao`, `ghiChu`)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            st.setString (1, maNhanKhau);
            st.setString (2, hoTen);
            st.setString (3, bietDanh);
            st.setString(4, namSinh);
            st.setString(5, gioiTinh);
            st.setString(6, noiSinh);
            st.setString (7, nguyenQuan);
            st.setString (8, danToc);
            st.setString (9, tonGiao);
            st.setString(10, quocTich);
            st.setString(11, soHoChieu);
            st.setString (12, noiThuongTru);
            st.setString (13, diaChiHienNay);
            st.setString (14, trinhDoHocVan);
            st.setString(15, trinhDoChuyenMon);
            st.setString(16, bietTiengDanToc);
            st.setString (17, trinhDoNgoaiNgu);
            st.setString (18, ngheNghiep);
            st.setString (19, noiLamViec);
            st.setString(20, tienAn);
            st.setString(21, ngayChuyenDen);
            st.setString (22, lyDoChuyenDen);
            st.setString (23, ngayChuyenDi);
            st.setString (24, lyDoChuyenDi);
            st.setString(25, diaChiMoi);
            st.setString(26, ngayTao);
            st.setString(27, ghiChu);
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertHoKhau(HoKhau hoKhau){
        String maHoKhau = hoKhau.getMaHoKhau();
        String maKhuVuc = hoKhau.getMaKhuVuc();
        String diaChi = hoKhau.getDiaChi();
        String ngayLap = hoKhau.getNgayLap();
        String ngayChuyenDi = hoKhau.getNgayChuyenDi();
        String lyDoChuyen = hoKhau.getLyDoChuyen();

        String sql = "INSERT INTO `ho_khau` (`maHoKhau`, `maKhuVuc`, `diaChi`, `ngayLap`, `ngayChuyenDi`, `lyDoChuyen`)" + "VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            st.setString (1, maHoKhau);
            st.setString (2, maKhuVuc);
            st.setString (3, diaChi);
            st.setString(4, ngayLap);
            st.setString(5, ngayChuyenDi);
            st.setString(6, lyDoChuyen);
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
