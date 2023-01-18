package com.example.quanly.controller.ho_khau;

import com.example.quanly.HelloApplication;
import com.example.quanly.Popup;
import com.example.quanly.controller.MainController;
import com.example.quanly.models.HoKhau;
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

public class HoKhauController implements Initializable {

    @FXML
    private Button themHoBtn;
    @FXML
    private Button suaHoBtn;
    @FXML
    private Button xoaHoBtn;
    @FXML
    private Button timKiemBtn;
    @FXML
    private TextField searchTF;
    @FXML
    private ComboBox comboBox;
    // table view
    @FXML
    private TableView<HoKhau> tableView;
    @FXML
    private TableColumn<HoKhau, String> maHoKhau;
    @FXML
    private TableColumn<HoKhau, String> idChuHo;
    @FXML
    private TableColumn<HoKhau, String> maKhuVuc;
    @FXML
    private TableColumn<HoKhau, String> diaChi;
    @FXML
    private TableColumn<HoKhau, String> ngayLap;
    @FXML
    private TableColumn<HoKhau, String> ngayChuyenDi;
    @FXML
    private TableColumn<HoKhau, String> lyDoChuyen;
    @FXML
    private TableColumn<HoKhau, String> nguoiThucHien;
    ObservableList<HoKhau> listview = FXCollections.observableArrayList();
    //
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        String items[] = {"Mã hộ khẩu", "ID chủ hộ", "Mã khu vực", "Địa chỉ", "Ngày lập"};
        comboBox.getItems().addAll(items);
        comboBox.setValue(items[0]);

        maHoKhau.setCellValueFactory(new PropertyValueFactory<>("maHoKhau"));
        idChuHo.setCellValueFactory(new PropertyValueFactory<>("idChuHo"));
        maKhuVuc.setCellValueFactory(new PropertyValueFactory<>("maKhuVuc"));
        diaChi.setCellValueFactory(new PropertyValueFactory<>("diaChi"));
        ngayLap.setCellValueFactory(new PropertyValueFactory<>("ngayLap"));
        ngayChuyenDi.setCellValueFactory(new PropertyValueFactory<>("ngayChuyenDi"));
        lyDoChuyen.setCellValueFactory(new PropertyValueFactory<>("lyDoChuyen"));
        nguoiThucHien.setCellValueFactory(new PropertyValueFactory<>("nguoiThucHien"));
        ArrayList<HoKhau> list = Database.findHoKhau("*", "");
        for(int i=0;i<list.size();i++){
            listview.add(list.get(i));
        }
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setItems(listview);
    }

    public void onXoaHoBtnClicked(ActionEvent actionEvent) {
        System.out.println("Xoa ho "+tableView.getSelectionModel().getSelectedItem());
        HoKhau selectedItem = tableView.getSelectionModel().getSelectedItem();
        if(selectedItem == null) return ;
        Database.deleteOneHoKhau(selectedItem);
        tableView.getItems().remove(selectedItem);
    }

    public void onSuaHoBtnClicked(ActionEvent actionEvent) {
    }

    public void onThemHoBtnClicked(ActionEvent actionEvent) {
        System.out.println("Them ho clicked");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ho_khau/them_ho.fxml"));
        Parent root = null;
        try {
            root = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Node node = null;
        if (root != null) {
            node = root.lookup("#them_ho_layout");
        }
        Popup.setLayout(node);
        Popup.setTitle("Thêm hộ khẩu mới");
        Popup.show();
    }

    public void onTimKiemBtnClicked(ActionEvent actionEvent) {
        System.out.println("search by" + comboBox.getValue() + searchTF.getText());
        String field = null;
        switch (comboBox.getValue().toString()){
            case "Mã hộ khẩu":
                field = "maHoKhau";
                break;
            case "ID chủ hộ":
                field = "idChuHo";
                break;
            case "Mã khu vực":
                field = "maKhuVuc";
                break;
            case "Địa chỉ":
                field = "diaChi";
                break;
            case "Ngày lập":
                field = "ngayLap";
                break;
        }
        ArrayList<HoKhau> list = Database.findHoKhau(field, searchTF.getText());
        listview = FXCollections.observableArrayList();
        for(int i=0;i<list.size();i++){
            listview.add(list.get(i));
        }
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setItems(listview);
    }
}
