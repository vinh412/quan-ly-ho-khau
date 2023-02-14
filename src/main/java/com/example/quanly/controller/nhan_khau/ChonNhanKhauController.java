package com.example.quanly.controller.nhan_khau;

import com.example.quanly.Database;
import com.example.quanly.models.HoKhau;
import com.example.quanly.models.NhanKhau;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ChonNhanKhauController {

    private ArrayList<NhanKhau> list;
    @FXML
    private DialogPane dialogPane;
    @FXML
    private TextField searchTF;
    @FXML
    private ComboBox<String> comboBox;
    // table view
    @FXML
    private TableView<NhanKhau> tableView;
    @FXML
    private TableColumn<NhanKhau, String> maNhanKhau;
    @FXML
    private TableColumn<NhanKhau, String> hoTen;
    @FXML
    private TableColumn<NhanKhau, String> gioiTinh;
    @FXML
    private TableColumn<NhanKhau, String> namSinh;
    @FXML
    private TableColumn<NhanKhau, String> diaChiHienNay;
    @FXML
    private Button chonBtn;
    ObservableList<NhanKhau> listview = FXCollections.observableArrayList();
    //
    public void initialize() {
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
        dialogPane.lookupButton(ButtonType.OK).setDisable(true);

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

        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                //Check whether item is selected
                if(tableView.getSelectionModel().getSelectedItem() != null)
                    dialogPane.lookupButton(ButtonType.OK).setDisable(false);
                else
                    dialogPane.lookupButton(ButtonType.OK).setDisable(true);
            }
        });
    }
    @FXML
    public void onTimKiemBtnClick(ActionEvent actionEvent) {
        System.out.println("search by" + comboBox.getValue() + searchTF.getText());
        String field = null;
        switch (comboBox.getValue()){
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
        listview.addAll(list);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setItems(listview);
    }

    public NhanKhau getSelectedNhanKhau(){
        NhanKhau selectedItem = tableView.getSelectionModel().getSelectedItem();
        return selectedItem;
    }
}
