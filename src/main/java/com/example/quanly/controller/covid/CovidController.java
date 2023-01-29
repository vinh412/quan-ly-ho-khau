package com.example.quanly.controller.covid;

import com.example.quanly.Database;
import com.example.quanly.HelloApplication;
import com.example.quanly.Popup;
import com.example.quanly.models.CachLy;
import com.example.quanly.models.KhaiBaoYTe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CovidController {
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
    private List<CachLy> cachLyList;

    public void initialize(){
        maCachLyColumn.setCellValueFactory(new PropertyValueFactory<>("maCachLy"));
        idNhanKhauColumn.setCellValueFactory(new PropertyValueFactory<>("idNhanKhau"));
        thoiGianKhaiBaoColumn.setCellValueFactory(new PropertyValueFactory<>("thoiGianKhaiBao"));
        diaDiemCachLyColumn.setCellValueFactory(new PropertyValueFactory<>("diaDiemCachLy"));
        tuNgayColumn.setCellValueFactory(new PropertyValueFactory<>("tuNgay"));
        denNgayColumn.setCellValueFactory(new PropertyValueFactory<>("denNgay"));
        mucDoCachLyColumn.setCellValueFactory(new PropertyValueFactory<>("mucDoCachLy"));
        //cachLyList = Database.findCachLy("*","");
        cachLyObservableList.addAll(cachLyList);
        cachLyTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        cachLyTableView.setItems(cachLyObservableList);
    }
    @FXML
    private void onKhaiBaoYTeBtnClick(){
        try {
            // load the fxml file and create a new popup dialog
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("covid/khai_bao_y_te.fxml"));
            DialogPane khaiBaoYTeDialogPane = fxmlLoader.load();

            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setDialogPane(khaiBaoYTeDialogPane);
            dialog.setTitle("Khai báo y tế");

            KhaiBaoYTeController khaiBaoYTeController = fxmlLoader.getController();

            Optional<ButtonType> clickedButton = dialog.showAndWait();
            if(clickedButton.get() == ButtonType.OK){
                KhaiBaoYTe newKhaiBaoYTe = khaiBaoYTeController.getKhaiBaoYTe();
                //Database.addOneKhaiBaoYTe(newKhaiBaoYTe);
                System.out.println("OK clicked");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onGhiNhanThongTinCachLyBtnClick(){
        try {
            // load the fxml file and create a new popup dialog
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("covid/ghi_nhan_thong_tin_cach_ly.fxml"));
            DialogPane ghiNhanThongTinCachLyDialogPane = fxmlLoader.load();

            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setDialogPane(ghiNhanThongTinCachLyDialogPane);
            dialog.setTitle("Ghi nhận thông tin cách ly");

            GhiNhanThongTinCachLyController ghiNhanThongTinCachLyController = fxmlLoader.getController();

            Optional<ButtonType> clickedButton = dialog.showAndWait();
            if(clickedButton.get() == ButtonType.OK){
                CachLy newCachLy = ghiNhanThongTinCachLyController.getCachLy();
                //Database.addOneCachLy(newCachLy);
                System.out.println("OK clicked");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void onThongKeKhaiBaoYTeBtnClick(){

    }

    @FXML
    private void onThongKeCachLyBtnClick(){

    }

    @FXML
    private void onTimKiemBtnClick(){

    }
}