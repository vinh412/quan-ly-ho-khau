package com.example.quanly;

import com.example.quanly.models.HoKhau;
import com.example.quanly.models.NhanKhau;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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

        String sql = "INSERT INTO `ho_khau` (`maHoKhau`, `idChuHo`, `maKhuVuc`, `diaChi`, `ngayLap`, `ngayChuyenDi`, `lyDoChuyen`)" + "VALUES (?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            st.setString (1, maHoKhau);
            st.setInt(2, hoKhau.getChuHo().getID());
            st.setString (3, maKhuVuc);
            st.setString (4, diaChi);
            st.setDate(5, Date.valueOf(ngayLap));
            st.setNull(6, Types.DATE);
            st.setString(7, "");
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("them ho");
    }
    public static ArrayList findHoKhau(String key, String value){
        String sql = null;
        if(key.compareTo("*") == 0 || value.compareTo("") == 0){
            sql = "select * from ho_khau";
        }else {
            sql = "select * from ho_khau " +
                    "where ho_khau." + key + " like " + "'"+value+"%'";
            // find all rows starting with `value`
        }
        ArrayList<HoKhau> result = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement st = null;
        System.out.println(sql);
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();

            while(rs.next()){
                String maHoKhau = rs.getString("maHoKhau");
                String idChuHo = String.valueOf(rs.getInt("idChuHo"));
                String maKhuVuc = rs.getString("maKhuVuc");
                String diaChi = rs.getString("diaChi");
                String ngayLap = rs.getString("ngayLap");
                String ngayChuyenDi = rs.getString("ngayChuyenDi");
                String lyDoChuyen = rs.getString("lyDoChuyen");
                String nguoiThucHien = rs.getString("nguoiThucHien");
                HoKhau hoKhau = new HoKhau(maHoKhau, idChuHo, maKhuVuc, diaChi, ngayLap, ngayChuyenDi, lyDoChuyen);
                result.add(hoKhau);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static ArrayList findNhanKhau(String key, String value){
        String sql = null;
        if(key.compareTo("*") == 0 || value.compareTo("") == 0){
            sql = "select * from nhan_khau";
        }else {
            sql = "select * from nhan_khau " +
                    "where nhan_khau." + key + " like " + "'"+value+"%'";
            // find all rows starting with `value`
        }
        ArrayList<NhanKhau> result = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement st = null;
        System.out.println(sql);
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();

            while(rs.next()){
                String maNhanKhau = rs.getString("maNhanKhau");
                String hoTen = rs.getString("hoTen");
                String gioiTinh = rs.getString("gioiTinh");
                String namSinh = rs.getString("namSinh");
                String diaChiHienNay = rs.getString("diaChiHienNay");
                int id = rs.getInt("ID");
                //
                NhanKhau nhanKhau = new NhanKhau(id, maNhanKhau, hoTen, gioiTinh, namSinh, diaChiHienNay);
                result.add(nhanKhau);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static void deleteOneHoKhau(HoKhau selectedItem) {
        String sql = "DELETE FROM ho_khau WHERE maHoKhau = ?;";
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, selectedItem.getMaHoKhau());
            System.out.println(st);
            st.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void deleteOneNhanKhau(NhanKhau selectedItem) {
        String sql = "DELETE FROM nhan_khau WHERE ID = ?;";
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(sql);
            st.setInt(1, selectedItem.getID());
            System.out.println(st);
            st.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
