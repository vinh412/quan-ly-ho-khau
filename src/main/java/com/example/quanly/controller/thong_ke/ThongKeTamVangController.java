package com.example.quanly.controller.thong_ke;

import com.example.quanly.Database;
import com.example.quanly.models.CachLy;
import com.example.quanly.models.GiayTamTru;
import com.example.quanly.models.GiayTamVang;
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

public class ThongKeTamVangController implements Initializable {
    @FXML
    private TableView<GiayTamVang> tableView;
    @FXML
    private TableColumn<GiayTamVang, String> hoTen;
    @FXML
    private TableColumn<GiayTamVang, LocalDate> namSinh;
    @FXML
    private TableColumn<GiayTamVang, String> idNhanKhau;
    @FXML
    private TableColumn<GiayTamVang, String> noiTamTru;
    @FXML
    private TableColumn<GiayTamVang, LocalDate> tuNgay;
    @FXML
    private TableColumn<GiayTamVang, LocalDate> denNgay;
    @FXML
    private TableColumn<GiayTamVang, String> lyDo;
    private ObservableList<GiayTamVang> giayTamVangObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idNhanKhau.setCellValueFactory(new PropertyValueFactory<>("idNhanKhau"));
        hoTen.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
        namSinh.setCellValueFactory(new PropertyValueFactory<>("namSinh"));
        noiTamTru.setCellValueFactory(new PropertyValueFactory<>("noiTamTru"));
        tuNgay.setCellValueFactory(new PropertyValueFactory<>("tuNgay"));
        denNgay.setCellValueFactory(new PropertyValueFactory<>("denNgay"));
        lyDo.setCellValueFactory(new PropertyValueFactory<>("lyDo"));

        ArrayList<GiayTamVang> giayTamTruArrayList = Database.findGiayTamVang("*", "");
        giayTamVangObservableList.addAll(giayTamTruArrayList);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setItems(giayTamVangObservableList);
    }
}
