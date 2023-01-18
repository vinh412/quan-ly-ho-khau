package com.example.quanly.controller.nhan_khau;

import com.example.quanly.Database;
import com.example.quanly.HelloApplication;
import com.example.quanly.Popup;
import com.example.quanly.models.HoKhau;
import com.example.quanly.models.NhanKhau;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
    private Button themNhanKhauBtn;
    @FXML
    private Button xoaNhanKhauBtn;
    @FXML
    private Button capNhatNhanKhauBtn;
    @FXML
    private Button timKiemBtn;
    @FXML
    private Button tamVangBtn;
    @FXML
    private Button tamTruBtn;
    @FXML
    private Button khaiTuBtn;
    @FXML
    private TextField searchTF;
    @FXML
    private ComboBox comboBox;
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
    //
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        String items[] = {"Mã nhân khẩu", "Họ tên", "Địa chỉ hiện nay"};
        comboBox.getItems().addAll(items);
        comboBox.setValue(items[1]);

        maNhanKhau.setCellValueFactory(new PropertyValueFactory<>("maNhanKhau"));
        hoTen.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
        gioiTinh.setCellValueFactory(new PropertyValueFactory<>("gioiTinh"));
        namSinh.setCellValueFactory(new PropertyValueFactory<>("namSinh"));
        diaChiHienNay.setCellValueFactory(new PropertyValueFactory<>("diaChiHienNay"));
        ArrayList<NhanKhau> list = Database.findNhanKhau("*", "");
        for(int i=0;i<list.size();i++){
            listview.add(list.get(i));
        }
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setItems(listview);
    }

    public void onThemNhanKhauBtnClick(ActionEvent actionEvent) {
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
        Popup.setLayout(node);
        Popup.setTitle("Thêm nhân khẩu mới");
        Popup.show();
        System.out.println("Them nhan khau clicked");
    }

    public void onXoaNhanKhauBtnClick(ActionEvent actionEvent) {
        System.out.println("Xoa nhan khau clicked");
        System.out.println("Xoa ho "+tableView.getSelectionModel().getSelectedItem());
        NhanKhau selectedItem = tableView.getSelectionModel().getSelectedItem();
        if(selectedItem == null) return ;
        Database.deleteOneNhanKhau(selectedItem);
        tableView.getItems().remove(selectedItem);
    }

    public void onCapNhatNhanKhauBtnClick(ActionEvent actionEvent) {
        System.out.println("Cap nhat nhan khau clicked");
    }

    public void onTamTruBtnClick(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("nhan_khau/tam_tru.fxml"));
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
        Popup.setLayout(node);
        Popup.setTitle("Đăng ký tạm trú");
        Popup.show();
    }

    public void onTamVangBtnClick(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("nhan_khau/tam_vang.fxml"));
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
        Popup.setLayout(node);
        Popup.setTitle("Đăng ký tạm vắng");
        Popup.show();
    }

    public void onKhaiTuBtnClick(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("nhan_khau/khai_tu.fxml"));
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
        Popup.setLayout(node);
        Popup.setTitle("Khai tử");
        Popup.show();
    }

    public void onTimKiemBtnClick(ActionEvent actionEvent) {
        System.out.println("search by" + comboBox.getValue() + searchTF.getText());
        String field = null;
        switch (comboBox.getValue().toString()){
            case "Họ tên":
                field = "hoTen";
                break;
            case "Mã nhân khẩu":
                field = "maNhanKhau";
                break;
            case "Địa chỉ hiện nay":
                field = "diaChiHienNay";
                break;
        }
        ArrayList<NhanKhau> list = Database.findNhanKhau(field, searchTF.getText());
        listview = FXCollections.observableArrayList();
        for(int i=0;i<list.size();i++){
            listview.add(list.get(i));
        }
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setItems(listview);
    }
}
