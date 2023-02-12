package com.example.quanly.controller.covid;

import com.example.quanly.Database;
import com.example.quanly.models.CachLy;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ThongKeCachLyController implements Initializable {
    @FXML
    private TableView<CachLy> cachLyTableView;
    @FXML
    private TableColumn<CachLy, String> maCachLyColumn;
    @FXML
    private TableColumn<CachLy, Integer> idNhanKhauColumn;
    @FXML
    private TableColumn<CachLy, String> thoiGianKhaiBaoColumn;
    @FXML
    private TableColumn<CachLy, String> diaDiemCachLyColumn;
    @FXML
    private TableColumn<CachLy, String> tuNgayColumn;
    @FXML
    private TableColumn<CachLy, String> denNgayColumn;
    @FXML
    private TableColumn<CachLy, String> mucDoCachLyColumn;
    private ObservableList<CachLy> cachLyObservableList = FXCollections.observableArrayList();
    private ArrayList<CachLy> cachLyList;
    @FXML
    private ComboBox<String> comboBox;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String[] items = {"Mã cách ly", "Địa điểm cách ly", "ID nhân khẩu", "Thời gian khai báo", "Mức độ cách ly"};
        comboBox.getItems().addAll(items);
        comboBox.setValue(items[0]);

        maCachLyColumn.setCellValueFactory(new PropertyValueFactory<>("maCachLy"));
        idNhanKhauColumn.setCellValueFactory(new PropertyValueFactory<>("idNhanKhau"));
        thoiGianKhaiBaoColumn.setCellValueFactory(new PropertyValueFactory<>("thoiGianKhaiBao"));
        diaDiemCachLyColumn.setCellValueFactory(new PropertyValueFactory<>("diaDiemCachLy"));
        tuNgayColumn.setCellValueFactory(new PropertyValueFactory<>("tuNgay"));
        denNgayColumn.setCellValueFactory(new PropertyValueFactory<>("denNgay"));
        mucDoCachLyColumn.setCellValueFactory(new PropertyValueFactory<>("mucDoCachLy"));
        cachLyList = Database.findCachLy("*","");
        cachLyObservableList.addAll(cachLyList);
        cachLyTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        cachLyTableView.setItems(cachLyObservableList);
    }
    @FXML
    private void onTimKiemBtnClick(){

    }
}
