package com.example.quanly.controller.covid;

import com.example.quanly.Database;
import com.example.quanly.models.CachLy;
import com.example.quanly.models.KhaiBaoYTe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ThongKeKhaiBaoController implements Initializable {
    @FXML
    private TableView<KhaiBaoYTe> khaiBaoYTeTableView;
    @FXML
    private TableColumn<KhaiBaoYTe, String> maPhieuKhaiBaoYTeColumn;
    @FXML
    private TableColumn<KhaiBaoYTe, Integer> idNhanKhauColumn;
    @FXML
    private TableColumn<KhaiBaoYTe, String> thoiGianKhaiBaoColumn;
    @FXML
    private TableColumn<KhaiBaoYTe, String> sotColumn;
    @FXML
    private TableColumn<KhaiBaoYTe, String> hoColumn;
    @FXML
    private TableColumn<KhaiBaoYTe, String> khoThoColumn;
    @FXML
    private TableColumn<KhaiBaoYTe, String> viemPhoiColumn;
    @FXML
    private TableColumn<KhaiBaoYTe, String> dauHongColumn;
    @FXML
    private TableColumn<KhaiBaoYTe, String> metMoiColumn;
    private ObservableList<KhaiBaoYTe> khaiBaoYTeObservableList = FXCollections.observableArrayList();
    private ArrayList<KhaiBaoYTe> khaiBaoYTeArrayList;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        maPhieuKhaiBaoYTeColumn.setCellValueFactory(new PropertyValueFactory<>("maPhieuKhaiBaoYTe"));
        idNhanKhauColumn.setCellValueFactory(new PropertyValueFactory<>("idNhanKhau"));
        thoiGianKhaiBaoColumn.setCellValueFactory(new PropertyValueFactory<>("thoiGianKhaiBao"));
        sotColumn.setCellValueFactory(new PropertyValueFactory<>("sot"));
        hoColumn.setCellValueFactory(new PropertyValueFactory<>("ho"));
        khoThoColumn.setCellValueFactory(new PropertyValueFactory<>("khoTho"));
        viemPhoiColumn.setCellValueFactory(new PropertyValueFactory<>("viemPhoi"));
        dauHongColumn.setCellValueFactory(new PropertyValueFactory<>("dauHong"));
        metMoiColumn.setCellValueFactory(new PropertyValueFactory<>("metMoi"));

        khaiBaoYTeArrayList = Database.findKhaiBao("*", "");
        khaiBaoYTeObservableList.addAll(khaiBaoYTeArrayList);
        khaiBaoYTeTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        khaiBaoYTeTableView.setItems(khaiBaoYTeObservableList);
    }
    @FXML
    private void onTimKiemBtnClick(){

    }
}
