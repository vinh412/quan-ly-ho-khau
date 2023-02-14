package com.example.quanly.controller.ho_khau;

import com.example.quanly.Database;
import com.example.quanly.models.HoKhau;
import com.example.quanly.models.NhanKhau;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ThemThanhVienController implements Initializable {

    private ArrayList<NhanKhau> list;
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
    @FXML
    private Button chonBtn;
    @FXML
    private TextField quanHeTF;
    ObservableList<NhanKhau> listview = FXCollections.observableArrayList();
    //
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
        list = Database.findNhanKhau("*", "");
        listview.addAll(list);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setItems(listview);

        searchTF.textProperty().addListener((observable, oldValue, newValue) -> {
            ObservableList<NhanKhau> filterList = FXCollections.observableArrayList();
            switch (comboBox.getValue()){
                case "Họ tên":
                    for(NhanKhau nhanKhau : list){
                        if(nhanKhau.getHoTen().toLowerCase().contains(newValue.toLowerCase())){
                            filterList.add(nhanKhau);
                        }
                    }
                    tableView.getItems().clear();
                    tableView.setItems(filterList);
                    break;

                case "Mã nhân khẩu":
                    for(NhanKhau nhanKhau : list){
                        if(nhanKhau.getMaNhanKhau().toLowerCase().contains(newValue.toLowerCase())){
                            filterList.add(nhanKhau);
                        }
                    }
                    tableView.getItems().clear();
                    tableView.setItems(filterList);
                    break;

                case "Địa chỉ hiện nay":
                    for(NhanKhau nhanKhau : list){
                        if(nhanKhau.getDiaChiHienNay().toLowerCase().contains(newValue.toLowerCase())){
                            filterList.add(nhanKhau);
                        }
                    }
                    tableView.getItems().clear();
                    tableView.setItems(filterList);
                    break;
            }
        });
    }
    IChonThanhVien themHoController;
    public void setParentController(IChonThanhVien themHoController) {
        this.themHoController = themHoController;
    }
    public void onChonBtnClick(ActionEvent actionEvent) {
        NhanKhau selectedItem = tableView.getSelectionModel().getSelectedItem();
        if(selectedItem == null || this.quanHeTF.getText().equals("")) return;
        themHoController.onThanhVienReceived(selectedItem, this.quanHeTF.getText());
        Stage stage = (Stage) chonBtn.getScene().getWindow();
        stage.close();
    }
//    @FXML
//    public void onTimKiemBtnClick(ActionEvent actionEvent) {
//        System.out.println("search by" + comboBox.getValue() + searchTF.getText());
//        String field = null;
//        switch (comboBox.getValue()){
//            case "Họ tên":
//                field = "hoTen";
//                break;
//            case "Mã nhân khẩu":
//                field = "maNhanKhau";
//                break;
//            case "Địa chỉ hiện nay":
//                field = "diaChiHienNay";
//                break;
//        }
//        ArrayList<NhanKhau> list = Database.findNhanKhau(field, searchTF.getText());
//        listview = FXCollections.observableArrayList();
//        listview.addAll(list);
//        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//        tableView.setItems(listview);
//    }
}
