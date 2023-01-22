package com.example.quanly;

import com.example.quanly.models.*;

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

    public static void insertOneNhanKhau(NhanKhau nhanKhau){
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String maNhanKhau = nhanKhau.getMaNhanKhau();
        String hoTen = nhanKhau.getHoTen();
        String bietDanh = nhanKhau.getBietDanh();
        LocalDate namSinh = nhanKhau.getNamSinh();
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
            st.setDate(4, Date.valueOf(namSinh));
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

    public static void insertOneHoKhau(HoKhau hoKhau){
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
                int idChuHo = rs.getInt("idChuHo");
                String maKhuVuc = rs.getString("maKhuVuc");
                String diaChi = rs.getString("diaChi");
                String ngayLap = rs.getString("ngayLap");
                String ngayChuyenDi = rs.getString("ngayChuyenDi");
                String lyDoChuyen = rs.getString("lyDoChuyen");
                String nguoiThucHien = rs.getString("nguoiThucHien");
                int ID = rs.getInt("ID");
                HoKhau hoKhau = new HoKhau(ID, maHoKhau, idChuHo, maKhuVuc, diaChi, ngayLap, ngayChuyenDi, lyDoChuyen);
                result.add(hoKhau);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static ArrayList findHoKhau(String key, int value){
        String sql = null;
        if(key.compareTo("*") == 0){
            sql = "select * from ho_khau";
        }else {
            sql = "select * from ho_khau " +
                    "where ho_khau." + key + " = " +value;
            // find all rows have `key` = `value`
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
                int idChuHo = rs.getInt("idChuHo");
                String maKhuVuc = rs.getString("maKhuVuc");
                String diaChi = rs.getString("diaChi");
                String ngayLap = rs.getString("ngayLap");
                String ngayChuyenDi = rs.getString("ngayChuyenDi");
                String lyDoChuyen = rs.getString("lyDoChuyen");
                String nguoiThucHien = rs.getString("nguoiThucHien");
                int ID = rs.getInt("ID");
                HoKhau hoKhau = new HoKhau(ID, maHoKhau, idChuHo, maKhuVuc, diaChi, ngayLap, ngayChuyenDi, lyDoChuyen);
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
                int ID = rs.getInt("ID");
                String maNhanKhau = rs.getString("maNhanKhau");
                String hoTen = rs.getString("hoTen");
                String bietDanh = rs.getString("bietDanh");
                String gioiTinh = rs.getString("gioiTinh");
                LocalDate namSinh = rs.getDate("namSinh").toLocalDate();
                String noiSinh = rs.getString("noiSinh");
                String diaChiHienNay = rs.getString("diaChiHienNay");
                String nguyenQuan = rs.getString("nguyenQuan");
                String danToc = rs.getString("danToc");
                String tonGiao = rs.getString("tonGiao");
                String quocTich = rs.getString("quocTich");
                String soHoChieu = rs.getString("soHoChieu");
                String noiThuongTru = rs.getString("noiThuongTru");
                String trinhDoHocVan = rs.getString("trinhDoHocVan");
                String trinhDoChuyenMon = rs.getString("trinhDoChuyenMon");
                String bietTiengDanToc = rs.getString("bietTiengDanToc");
                String trinhDoNgoaiNgu = rs.getString("trinhDoNgoaiNgu");
                String ngheNghiep = rs.getString("ngheNghiep");
                String noiLamViec = rs.getString("noiLamViec");
                String tienAn = rs.getString("tienAn");
                String ngayChuyenDen = rs.getString("ngayChuyenDen");
                String lyDoChuyenDen = rs.getString("lyDoChuyenDen");
                String ngayChuyenDi = rs.getString("ngayChuyenDi");
                String lyDoChuyenDi = rs.getString("lyDoChuyenDi");
                String diaChiMoi = rs.getString("diaChiMoi");
                String ngayTao = rs.getString("ngayTao");
                String ghiChu = rs.getString("ghiChu");

                //
//                NhanKhau nhanKhau = new NhanKhau(id, maNhanKhau, hoTen, gioiTinh, namSinh, diaChiHienNay);
                NhanKhau nhanKhau = new NhanKhau(ID, maNhanKhau, hoTen, bietDanh, namSinh, gioiTinh, noiSinh, nguyenQuan, danToc, tonGiao, quocTich, soHoChieu, noiThuongTru, diaChiHienNay, trinhDoHocVan, trinhDoChuyenMon, bietTiengDanToc, trinhDoNgoaiNgu, ngheNghiep, noiLamViec, tienAn, ngayChuyenDen, lyDoChuyenDen, ngayChuyenDi, lyDoChuyenDi, diaChiMoi, ghiChu);
                result.add(nhanKhau);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static ArrayList findNhanKhau(String key, int value){
        String sql = null;
        if(key.compareTo("*") == 0){
            sql = "select * from nhan_khau";
        }else {
            sql = "select * from nhan_khau " +
                    "where nhan_khau." + key + " = " + value;
        }
        ArrayList<NhanKhau> result = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement st = null;
        System.out.println(sql);
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();

            while(rs.next()){
                int ID = rs.getInt("ID");
                String maNhanKhau = rs.getString("maNhanKhau");
                String hoTen = rs.getString("hoTen");
                String bietDanh = rs.getString("bietDanh");
                String gioiTinh = rs.getString("gioiTinh");
                LocalDate namSinh = rs.getDate("namSinh").toLocalDate();
                String noiSinh = rs.getString("noiSinh");
                String diaChiHienNay = rs.getString("diaChiHienNay");
                String nguyenQuan = rs.getString("nguyenQuan");
                String danToc = rs.getString("danToc");
                String tonGiao = rs.getString("tonGiao");
                String quocTich = rs.getString("quocTich");
                String soHoChieu = rs.getString("soHoChieu");
                String noiThuongTru = rs.getString("noiThuongTru");
                String trinhDoHocVan = rs.getString("trinhDoHocVan");
                String trinhDoChuyenMon = rs.getString("trinhDoChuyenMon");
                String bietTiengDanToc = rs.getString("bietTiengDanToc");
                String trinhDoNgoaiNgu = rs.getString("trinhDoNgoaiNgu");
                String ngheNghiep = rs.getString("ngheNghiep");
                String noiLamViec = rs.getString("noiLamViec");
                String tienAn = rs.getString("tienAn");
                String ngayChuyenDen = rs.getString("ngayChuyenDen");
                String lyDoChuyenDen = rs.getString("lyDoChuyenDen");
                String ngayChuyenDi = rs.getString("ngayChuyenDi");
                String lyDoChuyenDi = rs.getString("lyDoChuyenDi");
                String diaChiMoi = rs.getString("diaChiMoi");
                String ngayTao = rs.getString("ngayTao");
                String ghiChu = rs.getString("ghiChu");

                //
//                NhanKhau nhanKhau = new NhanKhau(id, maNhanKhau, hoTen, gioiTinh, namSinh, diaChiHienNay);
                NhanKhau nhanKhau = new NhanKhau(ID, maNhanKhau, hoTen, bietDanh, namSinh, gioiTinh, noiSinh, nguyenQuan, danToc, tonGiao, quocTich, soHoChieu, noiThuongTru, diaChiHienNay, trinhDoHocVan, trinhDoChuyenMon, bietTiengDanToc, trinhDoNgoaiNgu, ngheNghiep, noiLamViec, tienAn, ngayChuyenDen, lyDoChuyenDen, ngayChuyenDi, lyDoChuyenDi, diaChiMoi, ghiChu);
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

    public static void updateOneHoKhau(HoKhau hoKhauSua, HoKhau hoKhau) {
        String sql = "UPDATE `ho_khau` " +
                "SET maHoKhau=?, idChuHo=?, maKhuVuc=?, diaChi=?, ngayLap=?, ngayChuyenDi=?, lyDoChuyen=? " +
                "WHERE ID = ?;";
        PreparedStatement st=null;
        try{
            st = conn.prepareStatement(sql);
            st.setString (1, hoKhau.getMaHoKhau());
            st.setInt(2, hoKhau.getChuHo().getID());
            st.setString (3, hoKhau.getMaKhuVuc());
            st.setString (4, hoKhau.getDiaChi());
            st.setDate(5, Date.valueOf(hoKhau.getNgayLap()));
            st.setNull(6, Types.DATE);
            st.setString(7, "");
            st.setInt(8, hoKhauSua.getID());
            System.out.println(st);
            st.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void updateOneNhanhKhau(NhanKhau nhanKhauSua, NhanKhau nhanKhauMoi) {
        String sql = "UPDATE `nhan_khau` " +
                "set `maNhanKhau`=?, `hoTen`=?, `bietDanh`=?, `namSinh`=?, `gioiTinh`=?, `noiSinh`=?, " +
                "`nguyenQuan`=?, `danToc`=?, `tonGiao`=?, `quocTich`=?, `soHoChieu`=?, `noiThuongTru`=?, `diaChiHienNay`=? ," +
                "`trinhDoHocVan`=?, `trinhDoChuyenMon`=?, `bietTiengDanToc`=?, `trinhDoNgoaiNgu`=?, `ngheNghiep`=?, " +
                "`noiLamViec`=?, `tienAn`=?, `ngayChuyenDen`=?, `lyDoChuyenDen`=?, `ngayChuyenDi`=?, `lyDoChuyenDi`=?, " +
                "`diaChiMoi`=?, `ngayTao`=?, `ghiChu`=? " +
                "where ID = ?";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            st.setString (1, nhanKhauMoi.getMaNhanKhau());
            st.setString (2, nhanKhauMoi.getHoTen());
            st.setString (3, nhanKhauMoi.getBietDanh());
            st.setDate(4, Date.valueOf(nhanKhauMoi.getNamSinh()));
            st.setString(5, nhanKhauMoi.getGioiTinh());
            st.setString(6, nhanKhauMoi.getNoiSinh());
            st.setString (7, nhanKhauMoi.getNguyenQuan());
            st.setString (8, nhanKhauMoi.getDanToc());
            st.setString (9, nhanKhauMoi.getTonGiao());
            st.setString(10, nhanKhauMoi.getQuocTich());
            st.setString(11, nhanKhauMoi.getSoHoChieu());
            st.setString (12, nhanKhauMoi.getNoiThuongTru());
            st.setString (13, nhanKhauMoi.getDiaChiHienNay());
            st.setString (14, nhanKhauMoi.getTrinhDoHocVan());
            st.setString(15, nhanKhauMoi.getTrinhDoChuyenMon());
            st.setString(16, nhanKhauMoi.getBietTiengDanToc());
            st.setString (17, nhanKhauMoi.getTrinhDoNgoaiNgu());
            st.setString (18, nhanKhauMoi.getNgheNghiep());
            st.setString (19, nhanKhauMoi.getNoiLamViec());
            st.setString(20, nhanKhauMoi.getTienAn());
            st.setString(21, nhanKhauMoi.getNgayChuyenDen());
            st.setString (22, nhanKhauMoi.getLyDoChuyenDen());
            st.setString (23, nhanKhauMoi.getNgayChuyenDi());
            st.setString (24, nhanKhauMoi.getLyDoChuyenDi());
            st.setString(25, nhanKhauMoi.getDiaChiMoi());
            st.setString(26, nhanKhauMoi.getNgayTao());
            st.setString(27, nhanKhauMoi.getGhiChu());
            st.setInt(28, nhanKhauSua.getID());
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertOneGiayTamVang(GiayTamVang giayTamVang) {
        int idNhanKhau = giayTamVang.getNhanKhau().getID();
        String maGiayTamVang = giayTamVang.getMaGiayTamVang();
        String noiTamtru = giayTamVang.getNoiTamtru();
        LocalDate tuNgay = giayTamVang.getTuNgay();
        LocalDate denNgay = giayTamVang.getDenNgay();
        String lyDo = giayTamVang.getLyDo();

        String sql = "INSERT INTO `tam_vang` (`idNhanKhau`, `maGiayTamVang`, `noiTamtru`, `tuNgay`, `denNgay`, `lyDo`)" + "VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            st.setInt (1, idNhanKhau);
            st.setString(2, maGiayTamVang);
            st.setString (3, noiTamtru);
            st.setDate (4, Date.valueOf(tuNgay));
            st.setDate(5, Date.valueOf(denNgay));
            st.setString(6, lyDo);
            System.out.println(st);
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertOneGiayTamTru(GiayTamTru giayTamTru) {
        int idNhanKhau = giayTamTru.getNhanKhau().getID();
        String maGiay = giayTamTru.getMaGiayTamTru();
        String diaChiThuongTru = giayTamTru.getDiaChiThuongTru();
        String diaChiTamTru = giayTamTru.getDiaChiTamTru();
        String soDienThoaiNguoiDangKy = giayTamTru.getSoDienThoaiNguoiDangKy();
        LocalDate tuNgay = giayTamTru.getTuNgay();
        LocalDate denNgay = giayTamTru.getDenNgay();
        String lyDo = giayTamTru.getLyDo();

        String sql = "INSERT INTO `tam_tru` (`idNhanKhau`, `maGiayTamTru`, `diaChiThuongTru`, `diaChiTamTru`, `soDienThoaiNguoiDangKy`, `tuNgay`, `denNgay`, `lyDo`) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            st.setInt (1, idNhanKhau);
            st.setString(2, maGiay);
            st.setString (3, diaChiThuongTru);
            st.setString (4, diaChiTamTru);
            st.setString (5, soDienThoaiNguoiDangKy);
            st.setDate (6, Date.valueOf(tuNgay));
            st.setDate(7, Date.valueOf(denNgay));
            st.setString(8, lyDo);
            System.out.println(st);
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertOneGiayKhaiTu(GiayKhaiTu giayKhaiTu) {
        int idNguoiChet = giayKhaiTu.getNhanKhau().getID();
        String maGiay = giayKhaiTu.getSoGiayKhaiTu();
        int idNguoiKhai = giayKhaiTu.getIdNguoiKhai();
        LocalDate ngayKhai = giayKhaiTu.getNgayKhai();
        LocalDate ngayChet = giayKhaiTu.getNgayChet();
        String lyDo = giayKhaiTu.getLyDoChet();

        String sql = "INSERT INTO `khai_tu` (`soGiayKhaiTu`, `idNguoiKhai`, `idNguoiChet`, `ngayKhai`, `ngayChet`, `lyDoChet`) " + "VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement st;
        try {
            st = conn.prepareStatement(sql);
            st.setString (1, maGiay);
            st.setInt(2, idNguoiKhai);
            st.setInt (3, idNguoiChet);
            st.setDate (4, Date.valueOf(ngayKhai));
            st.setDate (5, Date.valueOf(ngayChet));
            st.setString(6, lyDo);
            System.out.println(st);
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertOneThanhVienTrongHo(ThanhVienTrongHo thanhVienTrongHo) {
        ArrayList<HoKhau> hoKhau = Database.findHoKhau("idChuHo", thanhVienTrongHo.getChuHo().getID());
        String sql = "insert into `thanh_vien_cua_ho` (`idNhanKhau`, `idHoKhau`, `quanHeVoiChuHo`) values (?, ?, ?)";
        PreparedStatement st;
        try{
            st = conn.prepareStatement(sql);
            st.setInt(1, thanhVienTrongHo.getThanhVien().getID());
            st.setInt(2, hoKhau.get(0).getID());
            st.setString(3, thanhVienTrongHo.getQuanHeVoiChuHo());
            System.out.println(st);
            st.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
