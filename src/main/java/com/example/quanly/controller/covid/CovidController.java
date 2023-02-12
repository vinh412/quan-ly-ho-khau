package com.example.quanly.controller.covid;

import com.example.quanly.Database;
import com.example.quanly.HelloApplication;
import com.example.quanly.Popup;
import com.example.quanly.models.CachLy;
import com.example.quanly.models.HoKhau;
import com.example.quanly.models.KhaiBaoYTe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class CovidController implements Initializable {
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
    @FXML
    private BorderPane borderPane;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FXMLLoader fxmlLoader_center = new FXMLLoader(HelloApplication.class.getResource("covid/covid_main.fxml"));
        Parent root_center = null;
        try {
            root_center = fxmlLoader_center.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Node node_center = null;
        if (root_center != null) {
            node_center = root_center.lookup("#trang_chu_layout");
        }
        borderPane.setCenter(node_center);
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
                Database.addOneKhaiBaoYTe(newKhaiBaoYTe);
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
                Database.addOneCachLy(newCachLy);
                System.out.println("OK clicked");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void onThongKeKhaiBaoYTeBtnClick(){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("covid/thong_ke_khai_bao.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Node node = null;
        if (root != null) {
            node = root.lookup("#tk_kb_layout");
        }
        borderPane.setCenter(node);
    }
    @FXML
    private void onThongKeCachLyBtnClick(){
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("covid/thong_ke_cach_ly.fxml"));
        Parent root = null;
        try {
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Node node = null;
        if (root != null) {
            node = root.lookup("#tk_cl_layout");
        }
        borderPane.setCenter(node);
    }
    @FXML
    private TextField searchTF;
    @FXML
    private void onTimKiemBtnClick(){
        System.out.println("search by" + comboBox.getValue() + searchTF.getText());
        String field = switch (comboBox.getValue()) {
            case "Mã cách ly" -> "maCachLy";
            case "Địa điểm cách ly" -> "diaDiemCachLy";
            case "ID nhân khẩu" -> "idNhanKhau";
            case "Thời gian khai báo" -> "thoiGianKhaiBao";
            case "Mức độ cách ly" -> "mucDoCachLy";
            case "Ngày lập" -> "ngayLap";
            default -> null;
        };
        ArrayList<CachLy> list = Database.findCachLy(field, searchTF.getText());
        cachLyObservableList = FXCollections.observableArrayList();
        cachLyObservableList.addAll(list);
        cachLyTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        cachLyTableView.setItems(cachLyObservableList);
    }

}