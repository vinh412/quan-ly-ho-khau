package com.example.quanly.controller.ho_khau;

import com.example.quanly.Database;
import com.example.quanly.HelloApplication;
import com.example.quanly.Popup;
import com.example.quanly.controller.covid.GhiNhanThongTinCachLyController;
import com.example.quanly.controller.covid.KhaiBaoYTeController;
import com.example.quanly.models.*;
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
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class HoKhauController implements Initializable {

    private ArrayList<HoKhau> list;
    @FXML
    private TextField searchTF;
    @FXML
    private ComboBox<String> comboBox;
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

        String[] items = {"Mã hộ khẩu", "ID chủ hộ", "Mã khu vực", "Địa chỉ", "Ngày lập"};
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
        list = Database.findHoKhau("*", "");
        listview.addAll(list);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setItems(listview);

        searchTF.textProperty().addListener((observable, oldValue, newValue) -> {
            ObservableList<HoKhau> filterList = FXCollections.observableArrayList();
            switch (comboBox.getValue()){
                case "Mã hộ khẩu":
                    for(HoKhau hoKhau : list){
                        if(hoKhau.getMaHoKhau().toLowerCase().contains(newValue.toLowerCase())){
                            filterList.add(hoKhau);
                        }
                    }
                    tableView.getItems().clear();
                    tableView.setItems(filterList);
                    break;

                case "ID chủ hộ":
                    for(HoKhau hoKhau : list){
                        String idChuHo = hoKhau.getIdChuHo() + "";
                        if(idChuHo.toLowerCase().contains(newValue.toLowerCase())){
                            filterList.add(hoKhau);
                        }
                    }
                    tableView.getItems().clear();
                    tableView.setItems(filterList);
                    break;

                case "Mã khu vực":
                    for(HoKhau hoKhau : list){
                        if(hoKhau.getMaKhuVuc().toLowerCase().contains(newValue.toLowerCase())){
                            filterList.add(hoKhau);
                        }
                    }
                    tableView.getItems().clear();
                    tableView.setItems(filterList);
                    break;

                case "Địa chỉ":
                    for(HoKhau hoKhau : list){
                        if(hoKhau.getDiaChi().toLowerCase().contains(newValue.toLowerCase())){
                            filterList.add(hoKhau);
                        }
                    }
                    tableView.getItems().clear();
                    tableView.setItems(filterList);
                    break;

                case "Ngày lập":
                    for(HoKhau hoKhau : list){
                        if(hoKhau.getNgayLap().toLowerCase().contains(newValue.toLowerCase())){
                            filterList.add(hoKhau);
                        }
                    }
                    tableView.getItems().clear();
                    tableView.setItems(filterList);
                    break;
            }
        });
    }

    @FXML
    private void onThemHoBtnClick() throws IOException {
        System.out.println("Them ho clicked");
        try {
            // load the fxml file and create a new popup dialog
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ho_khau/them_ho.fxml"));
            DialogPane themHoDialogPane = fxmlLoader.load();

            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setDialogPane(themHoDialogPane);
            dialog.setTitle("Thêm hộ khẩu mới");

            ThemHoController themHoController = fxmlLoader.getController();

            Optional<ButtonType> clickedButton = dialog.showAndWait();
            if(clickedButton.get() == ButtonType.OK){
                if(themHoController.getChuHo() == null) return ;
                String maHoKhau = themHoController.maHoKhauTF.getText();
                String maKhuVuc = themHoController.maKhuVucTF.getText();
                String diaChi = themHoController.diaChiTF.getText();
                HoKhau hoKhau = new HoKhau(maHoKhau, themHoController.getChuHo(), maKhuVuc, diaChi, "", "");

                Database.insertOneHoKhau(hoKhau);

                for(int i=0;i<themHoController.getThanhVienTrongHo().size();i++){
                    Database.insertOneThanhVienTrongHo(themHoController.getThanhVienTrongHo().get(i));
                }
                Database.insertOneThanhVienTrongHo(new ThanhVienTrongHo(themHoController.getChuHo(), themHoController.getChuHo(), "Chủ hộ"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onTimKiemBtnClick() {
        System.out.println("search by" + comboBox.getValue() + searchTF.getText());
        String field = switch (comboBox.getValue()) {
            case "Mã hộ khẩu" -> "maHoKhau";
            case "ID chủ hộ" -> "idChuHo";
            case "Mã khu vực" -> "maKhuVuc";
            case "Địa chỉ" -> "diaChi";
            case "Ngày lập" -> "ngayLap";
            default -> null;
        };
        ArrayList<HoKhau> list = Database.findHoKhau(field, searchTF.getText());
        listview = FXCollections.observableArrayList();
        listview.addAll(list);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setItems(listview);
    }

    @FXML
    private void onSuaHoBtnClick() throws IOException {
        HoKhau selectedItem = tableView.getSelectionModel().getSelectedItem();
        if(selectedItem == null) return ;

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ho_khau/sua_ho.fxml"));
        SuaHoController suaHoController = new SuaHoController(selectedItem);
        fxmlLoader.setController(suaHoController);
        Parent root = (Parent) fxmlLoader.load();
        Node node = null;
        if (root != null) {
            node = root.lookup("#sua_ho_layout");
        }
        Popup popup = new Popup();
        popup.setLayout(node);
        popup.setTitle("Thêm hộ khẩu mới");
        popup.show();
    }

    @FXML
    private void onXoaHoBtnClick(ActionEvent actionEvent) {
        System.out.println("Xoa ho "+tableView.getSelectionModel().getSelectedItem());
        HoKhau selectedItem = tableView.getSelectionModel().getSelectedItem();
        if(selectedItem == null) return ;
        Database.deleteOneHoKhau(selectedItem);
        Database.deleteAllThanhVienTrongHo(selectedItem.getID());
        tableView.getItems().remove(selectedItem);
    }

    public void onTachHoBtnClick(ActionEvent actionEvent) throws IOException {
        HoKhau selectedItem = tableView.getSelectionModel().getSelectedItem();
        if(selectedItem == null) return ;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ho_khau/tach_ho.fxml"));
        TachHoController tachHoController = new TachHoController(selectedItem);
        fxmlLoader.setController(tachHoController);
        Parent root = (Parent) fxmlLoader.load();
        Node node = null;
        if (root != null) {
            node = root.lookup("#tach_ho_layout");
        }
        Popup popup = new Popup();
        popup.setLayout(node);
        popup.setTitle("Tách hộ khẩu");
        popup.show();
    }
}
