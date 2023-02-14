package com.example.quanly.controller.nhan_khau;

import com.example.quanly.Database;
import com.example.quanly.HelloApplication;
import com.example.quanly.Popup;
import com.example.quanly.models.HoKhau;
import com.example.quanly.models.NhanKhau;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class NhanKhauController implements Initializable {

    private ArrayList<NhanKhau> list;
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
    ObservableList<NhanKhau> listview = FXCollections.observableArrayList();

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

        tableView.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){
                try {
                    // load the fxml file and create a new popup dialog
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("nhan_khau/them_nhan_khau.fxml"));
                    DialogPane themNhanKhauDiaLog = fxmlLoader.load();

                    Dialog<ButtonType> dialog = new Dialog<>();
                    dialog.setDialogPane(themNhanKhauDiaLog);
                    dialog.setTitle("Thông tin nhân khẩu");

                    NhanKhau nhanKhau = tableView.getSelectionModel().getSelectedItem();
                    ThemNhanKhauController themNhanKhauController = fxmlLoader.getController();
                    themNhanKhauController.showThongTinNhanKhau(nhanKhau);
                    Optional<ButtonType> clickedButton = dialog.showAndWait();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void onThemNhanKhauBtnClick() {
        try {
            // load the fxml file and create a new popup dialog
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("nhan_khau/them_nhan_khau.fxml"));
            DialogPane themNhanKhauDialogPane = fxmlLoader.load();

            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setDialogPane(themNhanKhauDialogPane);
            dialog.setTitle("Thêm nhân khẩu mới");

            ThemNhanKhauController themNhanKhauController = fxmlLoader.getController();
            Optional<ButtonType> clickedButton = dialog.showAndWait();
            if(clickedButton.get() == ButtonType.OK){
                themNhanKhauController.onXacNhanBtnClick();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onXoaNhanKhauBtnClick() {
        System.out.println("Xoa nhan khau clicked");
        System.out.println("Xoa ho "+tableView.getSelectionModel().getSelectedItem());
        NhanKhau selectedItem = tableView.getSelectionModel().getSelectedItem();
        if(selectedItem == null) return ;
        Database.deleteOneNhanKhau(selectedItem);
        tableView.getItems().remove(selectedItem);
    }

    public void onCapNhatNhanKhauBtnClick() {
        System.out.println("Cap nhat nhan khau clicked");
        NhanKhau selectedItem = tableView.getSelectionModel().getSelectedItem();
        if(selectedItem == null) return ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("nhan_khau/cap_nhat_nhan_khau.fxml"));
        CapNhatNhanKhauController capNhatNhanKhauController = new CapNhatNhanKhauController(selectedItem);
        fxmlLoader.setController(capNhatNhanKhauController);
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
        Popup popup = new Popup();
        popup.setLayout(node);
        popup.setTitle("Cập nhật nhân khẩu");
        popup.show();
        System.out.println("Them nhan khau clicked");
    }

    public void onTamTruBtnClick() {
        NhanKhau selectedItem = tableView.getSelectionModel().getSelectedItem();
        if(selectedItem == null) return ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("nhan_khau/tam_tru.fxml"));
        TamTruController tamTruController = new TamTruController(selectedItem);
        fxmlLoader.setController(tamTruController);
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
        Popup popup = new Popup();
        popup.setLayout(node);
        popup.setTitle("Đăng ký tạm trú");
        popup.show();
    }

    public void onTamVangBtnClick() {
        NhanKhau selectedItem = tableView.getSelectionModel().getSelectedItem();
        if(selectedItem == null) return ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("nhan_khau/tam_vang.fxml"));
        TamVangController tamVangController = new TamVangController(selectedItem);
        fxmlLoader.setController(tamVangController);
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
        Popup popup = new Popup();
        popup.setLayout(node);
        popup.setTitle("Đăng ký tạm vắng");
        popup.show();
    }

    public void onKhaiTuBtnClick() {
        NhanKhau selectedItem = tableView.getSelectionModel().getSelectedItem();
        if(selectedItem == null) return ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("nhan_khau/khai_tu.fxml"));
        KhaiTuController khaiTuController = new KhaiTuController(selectedItem);
        fxmlLoader.setController(khaiTuController);
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
        Popup popup = new Popup();
        popup.setLayout(node);
        popup.setTitle("Khai tử");
        popup.show();
    }

    public void onTimKiemBtnClick() {
        System.out.println("search by" + comboBox.getValue() + searchTF.getText());
        String field = switch (comboBox.getValue()) {
            case "Họ tên" -> "hoTen";
            case "Mã nhân khẩu" -> "maNhanKhau";
            case "Địa chỉ hiện nay" -> "diaChiHienNay";
            default -> null;
        };
        ArrayList<NhanKhau> list = Database.findNhanKhau(field, searchTF.getText());
        listview = FXCollections.observableArrayList();
        listview.addAll(list);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setItems(listview);
    }
}
