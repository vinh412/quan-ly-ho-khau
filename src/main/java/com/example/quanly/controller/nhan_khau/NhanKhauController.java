package com.example.quanly.controller.nhan_khau;

import com.example.quanly.Database;
import com.example.quanly.HelloApplication;
import com.example.quanly.Popup;
import com.example.quanly.models.HoKhau;
import com.example.quanly.models.NhanKhau;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class NhanKhauController implements Initializable {
    @FXML
    private TextField searchTF;
    @FXML
    private ComboBox<String> comboBox;
    // table view
    @FXML
    private TableView<NhanKhau> tableView;
    @FXML
    private TableColumn<HoKhau, String> maNhanKhau;
    @FXML
    private TableColumn<HoKhau, String> hoTen;
    @FXML
    private TableColumn<HoKhau, String> gioiTinh;
    @FXML
    private TableColumn<HoKhau, String> namSinh;
    @FXML
    private TableColumn<HoKhau, String> diaChiHienNay;
    ObservableList<NhanKhau> listview = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        String[] items = {"Mã nhân khẩu", "Họ tên", "Địa chỉ hiện nay"};
        comboBox.getItems().addAll(items);
        comboBox.setValue(items[1]);

        maNhanKhau.setCellValueFactory(new PropertyValueFactory<>("maNhanKhau"));
        hoTen.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
        gioiTinh.setCellValueFactory(new PropertyValueFactory<>("gioiTinh"));
        namSinh.setCellValueFactory(new PropertyValueFactory<>("namSinh"));
        diaChiHienNay.setCellValueFactory(new PropertyValueFactory<>("diaChiHienNay"));
        ArrayList<NhanKhau> list = Database.findNhanKhau("*", "");
        listview.addAll(list);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setItems(listview);
    }

    public void onThemNhanKhauBtnClick() {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("nhan_khau/them_nhan_khau.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Node node = null;
        if (root != null) {
            node = root.lookup("#them_nhan_khau_layout");
        }
        Popup popup = new Popup();
        popup.setLayout(node);
        popup.setTitle("Thêm nhân khẩu mới");
        popup.show();
        System.out.println("Them nhan khau clicked");
    }

    public void onXoaNhanKhauBtnClick() {
        System.out.println("Xoa nhan khau clicked");
        System.out.println("Xoa ho "+tableView.getSelectionModel().getSelectedItem());
        NhanKhau selectedItem = tableView.getSelectionModel().getSelectedItem();
        if(selectedItem == null) return ;
        Database.deleteOneNhanKhau(selectedItem);
        tableView.getItems().remove(selectedItem);
    }

    public void onCapNhatNhanKhauBtnClick() {
        System.out.println("Cap nhat nhan khau clicked");
        NhanKhau selectedItem = tableView.getSelectionModel().getSelectedItem();
        if(selectedItem == null) return ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("nhan_khau/cap_nhat_nhan_khau.fxml"));
        CapNhatNhanKhauController capNhatNhanKhauController = new CapNhatNhanKhauController(selectedItem);
        fxmlLoader.setController(capNhatNhanKhauController);
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Node node = null;
        if (root != null) {
            node = root.lookup("#them_nhan_khau_layout");
        }
        Popup popup = new Popup();
        popup.setLayout(node);
        popup.setTitle("Thêm nhân khẩu mới");
        popup.show();
        System.out.println("Them nhan khau clicked");
    }

    public void onTamTruBtnClick() {
        NhanKhau selectedItem = tableView.getSelectionModel().getSelectedItem();
        if(selectedItem == null) return ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("nhan_khau/tam_tru.fxml"));
        TamTruController tamTruController = new TamTruController(selectedItem);
        fxmlLoader.setController(tamTruController);
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Node node = null;
        if (root != null) {
            node = root.lookup("#tam_tru_layout");
        }
        Popup popup = new Popup();
        popup.setLayout(node);
        popup.setTitle("Đăng ký tạm trú");
        popup.show();
    }

    public void onTamVangBtnClick() {
        NhanKhau selectedItem = tableView.getSelectionModel().getSelectedItem();
        if(selectedItem == null) return ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("nhan_khau/tam_vang.fxml"));
        TamVangController tamVangController = new TamVangController(selectedItem);
        fxmlLoader.setController(tamVangController);
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Node node = null;
        if (root != null) {
            node = root.lookup("#tam_vang_layout");
        }
        Popup popup = new Popup();
        popup.setLayout(node);
        popup.setTitle("Đăng ký tạm vắng");
        popup.show();
    }

    public void onKhaiTuBtnClick() {
        NhanKhau selectedItem = tableView.getSelectionModel().getSelectedItem();
        if(selectedItem == null) return ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("nhan_khau/khai_tu.fxml"));
        KhaiTuController khaiTuController = new KhaiTuController(selectedItem);
        fxmlLoader.setController(khaiTuController);
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Node node = null;
        if (root != null) {
            node = root.lookup("#khai_tu_layout");
        }
        Popup popup = new Popup();
        popup.setLayout(node);
        popup.setTitle("Khai tử");
        popup.show();
    }

    public void onTimKiemBtnClick() {
        System.out.println("search by" + comboBox.getValue() + searchTF.getText());
        String field = switch (comboBox.getValue()) {
            case "Họ tên" -> "hoTen";
            case "Mã nhân khẩu" -> "maNhanKhau";
            case "Địa chỉ hiện nay" -> "diaChiHienNay";
            default -> null;
        };
        ArrayList<NhanKhau> list = Database.findNhanKhau(field, searchTF.getText());
        listview = FXCollections.observableArrayList();
        listview.addAll(list);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setItems(listview);
    }
}
