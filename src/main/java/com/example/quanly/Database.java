package com.example.quanly;

import com.example.quanly.models.HoKhau;

import java.sql.*;

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
    public static void insertHoKhau(HoKhau hoKhau){
        String maHoKhau = hoKhau.maHoKhau;
        String maKhuVuc = hoKhau.maKhuVuc;
        String diaChi = hoKhau.diaChi;
        String ngayLap = hoKhau.ngayLap;
        String ngayChuyenDi = hoKhau.ngayChuyenDi;
        String lyDoChuyen = hoKhau.lyDoChuyen;

        String sql = "INSERT INTO `ho_khau` (`maHoKhau`, `maKhuVuc`, `diaChi`, `ngayLap`, `ngayChuyenDi`, `lyDoChuyen`)" + "VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement st = null;
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
    public static void close(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
