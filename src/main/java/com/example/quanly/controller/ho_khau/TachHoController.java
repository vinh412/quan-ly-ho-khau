package com.example.quanly.controller.ho_khau;

import com.example.quanly.Database;
import com.example.quanly.controller.MainController;
import com.example.quanly.models.DinhChinh;
import com.example.quanly.models.HoKhau;
import com.example.quanly.models.NhanKhau;
import com.example.quanly.models.ThanhVienTrongHo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.Console;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class TachHoController implements Initializable {
    private HoKhau hoKhau;
    public TachHoController(HoKhau hoKhau){
        this.hoKhau = hoKhau;
        this.thanhVien = Database.getThanhVienList(this.hoKhau.getID());
    }
    @FXML
    private TableView<NhanKhau> tableView, tableView1;
    @FXML
    private TableColumn<NhanKhau, Integer> ID, ID1;
    @FXML
    private TableColumn<NhanKhau, String> hoTen, hoTen1;
    @FXML
    private TableColumn<NhanKhau, LocalDate> namSinh, namSinh1;
    @FXML
    private TableColumn<NhanKhau, String> quanHe;
    ObservableList<NhanKhau> listview = FXCollections.observableArrayList();
    ObservableList<NhanKhau> listview1 = FXCollections.observableArrayList();
    private ArrayList<NhanKhau> thanhVien = null;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        hoTen.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
        namSinh.setCellValueFactory(new PropertyValueFactory<>("namSinh"));
        quanHe.setCellValueFactory(new PropertyValueFactory<>("quanHeVoiChuHo"));
        listview.addAll(this.thanhVien);
        tableView.setItems(listview);

        tableView1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        ID1.setCellValueFactory(new PropertyValueFactory<>("ID"));
        hoTen1.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
        namSinh1.setCellValueFactory(new PropertyValueFactory<>("namSinh"));
        listview1.addAll(nhanKhauTach);
        tableView1.setItems(listview1);
    }
    private ArrayList<NhanKhau> nhanKhauTach = new ArrayList<>();
    public void onRightBtnClick(){
        NhanKhau selectedItem = tableView.getSelectionModel().getSelectedItem();
        if(selectedItem == null) return ;
        System.out.println("right");

        nhanKhauTach.add(selectedItem);
        listview1.clear();
        listview1.addAll(nhanKhauTach);
        tableView1.setItems(listview1);

        thanhVien.remove(selectedItem);
        listview.clear();
        listview.addAll(thanhVien);
        tableView.setItems(listview);
    }
    public void onLeftBtnClick(){
        NhanKhau selectedItem = tableView1.getSelectionModel().getSelectedItem();
        if(selectedItem == null) return ;
        System.out.println("left");

        thanhVien.add(selectedItem);
        listview.clear();
        listview.addAll(thanhVien);
        tableView.setItems(listview);

        nhanKhauTach.remove(selectedItem);
        listview1.clear();
        listview1.addAll(nhanKhauTach);
        tableView1.setItems(listview1);
    }
    @FXML
    private TextField maHoKhauTF;
    @FXML
    private TextField maKhuVucTF;
    @FXML
    private TextField diaChiTF;
    @FXML
    private Button tachBtn;
    public void onTachBtnClick(){
        if(this.chuHoMoi == null) return ;
        if(this.thanhVien.size() == 0){
            // xoa ho khau
        }

        String maHoKhau = this.maHoKhauTF.getText();
        String maKhuVuc = this.maKhuVucTF.getText();
        String diaChi = this.diaChiTF.getText();

        HoKhau hoKhauMoi = new HoKhau(maHoKhau, this.chuHoMoi, maKhuVuc, diaChi, "", "");

        System.out.println(this.thanhVien.stream().map(Object::toString).collect(Collectors.joining(", ")));
        Database.insertDinhChinh(new DinhChinh(this.hoKhau.getID(), "tách hộ khẩu", this.thanhVien.stream().map(Object::toString).collect(Collectors.joining(", ")), this.nhanKhauTach.stream().map(Object::toString).collect(Collectors.joining(", ")), MainController.currentUser.getID()));

        Database.insertOneHoKhau(hoKhauMoi);

        Database.insertOneThanhVienTrongHo(new ThanhVienTrongHo(this.chuHoMoi,this.chuHoMoi, "Chủ hộ" ));

        for(int i=0;i<this.nhanKhauTach.size();i++){
            if(this.nhanKhauTach.get(i).getID() == this.chuHoMoi.getID()) continue;
            ArrayList<HoKhau> arrayList = Database.findHoKhau("idChuHo", this.chuHoMoi.getID());
            HoKhau hoKhau = arrayList.get(0);
            Database.insertOneThanhVienTrongHo(hoKhau.getID(), this.thanhVien.get(i).getID(), "thành viên");
        }

        for(int i=0;i<this.nhanKhauTach.size();i++){
            Database.deleteOneThanhVienTrongHo(this.hoKhau.getID(), this.nhanKhauTach.get(i).getID());
        }


        Stage stage  = (Stage) tachBtn.getScene().getWindow();
        stage.close();
    }
    @FXML
    private Button chonChuHoBtn;
    private NhanKhau chuHoMoi;
    public void onChonBtnClick(){
        NhanKhau selectedItem = tableView1.getSelectionModel().getSelectedItem();
        if(selectedItem == null) return ;
        this.chonChuHoBtn.setText(selectedItem.getHoTen());
        this.chuHoMoi = selectedItem;
    }
}
