package com.example.quanly.controller.thong_ke;

import com.example.quanly.Database;
import com.example.quanly.models.CachLy;
import com.example.quanly.models.GiayTamTru;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ThongKeTamTruController implements Initializable {
    @FXML
    private TableView<GiayTamTru> tableView;
    @FXML
    private TableColumn<GiayTamTru, String> hoTen;
    @FXML
    private TableColumn<GiayTamTru, LocalDate> namSinh;
    @FXML
    private TableColumn<GiayTamTru, String> idNhanKhau;
    @FXML
    private TableColumn<GiayTamTru, String> diaChiThuongTru;
    @FXML
    private TableColumn<GiayTamTru, String> diaChiTamTru;
    @FXML
    private TableColumn<GiayTamTru, LocalDate> tuNgay;
    @FXML
    private TableColumn<GiayTamTru, LocalDate> denNgay;
    @FXML
    private TableColumn<GiayTamTru, String> lyDo;
    private ObservableList<GiayTamTru> giayTamTruObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idNhanKhau.setCellValueFactory(new PropertyValueFactory<>("idNhanKhau"));
        hoTen.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
        namSinh.setCellValueFactory(new PropertyValueFactory<>("namSinh"));
        diaChiThuongTru.setCellValueFactory(new PropertyValueFactory<>("diaChiThuongTru"));
        diaChiTamTru.setCellValueFactory(new PropertyValueFactory<>("diaChiTamTru"));
        tuNgay.setCellValueFactory(new PropertyValueFactory<>("tuNgay"));
        denNgay.setCellValueFactory(new PropertyValueFactory<>("denNgay"));
        lyDo.setCellValueFactory(new PropertyValueFactory<>("lyDo"));

        ArrayList<GiayTamTru> giayTamTruArrayList = Database.findGiayTamTru("*", "");
        giayTamTruObservableList.addAll(giayTamTruArrayList);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setItems(giayTamTruObservableList);
    }
}
