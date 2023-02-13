package com.example.quanly.controller.ho_khau;

import com.example.quanly.Database;
import com.example.quanly.HelloApplication;
import com.example.quanly.Popup;
import com.example.quanly.controller.nhan_khau.ChonNhanKhauController;
import com.example.quanly.controller.nhan_khau.NhanKhauController;
import com.example.quanly.models.HoKhau;
import com.example.quanly.models.NhanKhau;
import com.example.quanly.models.ThanhVienTrongHo;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class ThemHoController implements Initializable, IChonChuHo, IChonThanhVien {

    @FXML
    private DialogPane dialogPane;
    public TextField maHoKhauTF;
    public TextField maKhuVucTF;
    public TextField diaChiTF;
    public AnchorPane themhoLayout;
    @FXML
    private Button chuHoBtn;

    public Label hoTenChuHoLB;
    public Label namSinhChuHoLB;
    public Button themBtn;
    public Button xoaBtn;
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
    private ArrayList<NhanKhau> thanhVien = new ArrayList<>();
    //
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        maNhanKhau.setCellValueFactory(new PropertyValueFactory<>("maNhanKhau"));
        hoTen.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
        gioiTinh.setCellValueFactory(new PropertyValueFactory<>("gioiTinh"));
        namSinh.setCellValueFactory(new PropertyValueFactory<>("namSinh"));
        diaChiHienNay.setCellValueFactory(new PropertyValueFactory<>("diaChiHienNay"));
        listview.addAll(this.thanhVien);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setItems(listview);
        dialogPane.lookupButton(ButtonType.OK).setDisable(true);
        hoTenChuHoLB.textProperty().addListener(observable -> {
            if(this.chuHo == null){
                dialogPane.lookupButton(ButtonType.OK).setDisable(true);
            }
            else
                dialogPane.lookupButton(ButtonType.OK).setDisable(false);
        });
    }
    @FXML
    private Button huyBtn;
    private NhanKhau chuHo;
    public void onThemHoBtnClick(){
        if(this.chuHo == null || this.thanhVienTrongHo.size() == 0) return ;
        String maHoKhau = maHoKhauTF.getText();
        String maKhuVuc = maKhuVucTF.getText();
        String diaChi = diaChiTF.getText();
        HoKhau hoKhau = new HoKhau(maHoKhau, this.chuHo, maKhuVuc, diaChi, "", "");

        Database.insertOneHoKhau(hoKhau);

        for(int i=0;i<this.thanhVienTrongHo.size();i++){
            Database.insertOneThanhVienTrongHo(this.thanhVienTrongHo.get(i));
        }
        Database.insertOneThanhVienTrongHo(new ThanhVienTrongHo(this.chuHo, this.chuHo, "Chủ hộ"));

        this.onHuyButtonClick();
    }

    public void onHuyButtonClick(){
        Stage stage  = (Stage) huyBtn.getScene().getWindow();
        stage.close();
    }
    public void onChuHoReceived(NhanKhau chuHo){
        if(chuHo == null) return ;
        this.chuHo = chuHo;
        chuHoBtn.setText(this.chuHo.getHoTen());
    }
    private ArrayList<ThanhVienTrongHo> thanhVienTrongHo = new ArrayList<>();
    @Override
    public void onThanhVienReceived(NhanKhau thanhVien, String quanHeVoiChuHo) {
        if(this.chuHo == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Chưa chọ chủ hộ");
            alert.setContentText("Chọn chủ hộ trước khi chọn thành viên");
            alert.showAndWait();
            return ;
        }
        this.thanhVien.add(thanhVien);
        this.listview.clear();
        this.listview.addAll(this.thanhVien);
        this.tableView.setItems(listview);

        this.thanhVienTrongHo.add(new ThanhVienTrongHo(this.chuHo, thanhVien, quanHeVoiChuHo));
    }
    public void onChuHoBtnClick(ActionEvent actionEvent) throws IOException {
        try {
            // load the fxml file and create a new popup dialog
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("nhan_khau/chon_nhan_khau.fxml"));
            DialogPane chonNhanKhauDialogPane = fxmlLoader.load();

            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setDialogPane(chonNhanKhauDialogPane);
            dialog.setTitle("Chọn nhân khẩu");

            ChonNhanKhauController chonNhanKhauController = fxmlLoader.getController();
            Optional<ButtonType> clickedButton = dialog.showAndWait();
            if(clickedButton.get() == ButtonType.OK){
                this.chuHo = chonNhanKhauController.getSelectedNhanKhau();
                hoTenChuHoLB.setText(chuHo.getHoTen());
                namSinhChuHoLB.setText(chuHo.getNamSinh().toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onThemBtnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ho_khau/chon_thanh_vien.fxml"));
        ThemThanhVienController themThanhVienController = new ThemThanhVienController();
        themThanhVienController.setParentController(this);
        fxmlLoader.setController(themThanhVienController);
        Parent root = fxmlLoader.load();
        Node node = root.lookup("#chon_thanh_vien_layout");
        Popup popup = new Popup();
        popup.setLayout(node);
        popup.setTitle("Thêm thành viên");
        popup.show();
    }

    public void onXoaBtnClick(ActionEvent actionEvent) {
        NhanKhau selectedItem = tableView.getSelectionModel().getSelectedItem();
        tableView.getItems().remove(selectedItem);
        this.thanhVien.remove(selectedItem);
        for(int i=0;i<this.thanhVienTrongHo.size();i++){
            if(this.thanhVienTrongHo.get(i).getThanhVien().getID() == selectedItem.getID()){
                this.thanhVienTrongHo.remove(i);
            }
        }
    }
    public NhanKhau getChuHo(){
        return this.chuHo;
    }

    public ArrayList<ThanhVienTrongHo> getThanhVienTrongHo() {
        return thanhVienTrongHo;
    }

    public void showThongTinHoKhau(HoKhau hoKhau){
        ObservableList<NhanKhau> listView = FXCollections.observableArrayList();
        ArrayList<NhanKhau> thanhVienTrongHo = Database.getThanhVienList(hoKhau.getID());
        listView.addAll(thanhVienTrongHo);

        maHoKhauTF.setText(hoKhau.getMaHoKhau());
        maKhuVucTF.setText(hoKhau.getMaKhuVuc());
        diaChiTF.setText(hoKhau.getDiaChi());

        NhanKhau chuHo = Database.findNhanKhau("ID",hoKhau.getIdChuHo()).get(0);
        hoTenChuHoLB.setText(chuHo.getHoTen());
        namSinhChuHoLB.setText(chuHo.getNamSinh().toString());

        hoTen.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
        gioiTinh.setCellValueFactory(new PropertyValueFactory<>("gioiTinh"));
        namSinh.setCellValueFactory(new PropertyValueFactory<>("namSinh"));
        diaChiHienNay.setCellValueFactory(new PropertyValueFactory<>("diaChiHienNay"));

        TableColumn<NhanKhau, String> quanHeVoiChuHo = new TableColumn<>();
        quanHeVoiChuHo.setText("Quan hệ với chủ hộ");
        quanHeVoiChuHo.setCellValueFactory(new PropertyValueFactory<>("quanHeVoiChuHo"));
        tableView.getColumns().add(quanHeVoiChuHo);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setItems(listView);

        themBtn.setVisible(false);
        xoaBtn.setVisible(false);
        chuHoBtn.setVisible(false);
        maHoKhauTF.setDisable(true);
        maKhuVucTF.setDisable(true);
        diaChiTF.setDisable(true);

    }

    public void showSuaHo(HoKhau hoKhau){
        NhanKhau chuHo = Database.findNhanKhau("ID", hoKhau.getIdChuHo()).get(0);
        hoTenChuHoLB.setText(chuHo.getHoTen());
        namSinhChuHoLB.setText(chuHo.getNamSinh().toString());
        maHoKhauTF.setText(hoKhau.getMaHoKhau());
        maKhuVucTF.setText(hoKhau.getMaKhuVuc());
        diaChiTF.setText(hoKhau.getDiaChi());

        ArrayList<NhanKhau> thanhVienCuaHo = Database.getThanhVienList(hoKhau.getID());
        ObservableList<NhanKhau> listView = FXCollections.observableArrayList();
        listView.addAll(thanhVienCuaHo);

        TableColumn<NhanKhau, String> quanHeVoiChuHo = new TableColumn<>();
        quanHeVoiChuHo.setText("Quan hệ với chủ hộ");
        quanHeVoiChuHo.setCellValueFactory(new PropertyValueFactory<>("quanHeVoiChuHo"));
        tableView.getColumns().add(quanHeVoiChuHo);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setItems(listView);
    }
}