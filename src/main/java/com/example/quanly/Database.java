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
    public static void insertOne(HoKhau hoKhau){
        String soHoKhau = hoKhau.soHoKhau;
        String hoTenChuHo = hoKhau.hoTenChuHo;
        String soNha = hoKhau.soNha;
        String duong = hoKhau.duong;
        String xa = hoKhau.xa;
        String huyen = hoKhau.huyen;

        String sql = "INSERT INTO `hokhau` (`SoHoKhau`, `HoTenChuHo`, `SoNha`, `Duong`, `Xa`, `Huyen`)" + "VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(sql);
            st.setString (1, soHoKhau);
            st.setString (2, hoTenChuHo);
            st.setString (3, soNha);
            st.setString(4, duong);
            st.setString(5, xa);
            st.setString(6, huyen);
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
