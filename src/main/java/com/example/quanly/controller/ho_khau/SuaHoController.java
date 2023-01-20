package com.example.quanly.controller.ho_khau;

import com.example.quanly.Database;
import com.example.quanly.HelloApplication;
import com.example.quanly.Popup;
import com.example.quanly.models.HoKhau;
import com.example.quanly.models.NhanKhau;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SuaHoController implements Initializable, IChonChuHo {
    @FXML
    private TextField maHoKhauTF;
    @FXML
    private TextField maKhuVucTF;
    @FXML
    private TextField diaChiTF;
    @FXML
    private AnchorPane themhoLayout;
    @FXML
    private Button chuHoBtn;
    private HoKhau hoKhauSua;
    private NhanKhau chuHo;
    public SuaHoController(HoKhau hoKhauSua){
        this.hoKhauSua = hoKhauSua;
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.maHoKhauTF.setText(this.hoKhauSua.getMaHoKhau());
        this.maKhuVucTF.setText(this.hoKhauSua.getMaKhuVuc());
        this.diaChiTF.setText(this.hoKhauSua.getDiaChi());
        ArrayList<NhanKhau> arrayList = Database.findNhanKhau("ID", this.hoKhauSua.getIdChuHo());
        this.chuHo = arrayList.get(0);
        this.chuHoBtn.setText(this.chuHo.getHoTen());
    }
    public void onChuHoBtnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ho_khau/chon_chu_ho.fxml"));
        ChonChuHoController chonChuHoController = new ChonChuHoController();
        chonChuHoController.setParentController(this);
        fxmlLoader.setController(chonChuHoController);
        Parent root = fxmlLoader.load();
        Node node = root.lookup("#chon_chu_ho_layout");
        Popup popup = new Popup();
        popup.setLayout(node);
        popup.setTitle("Chọn chủ hộ");
        popup.show();
        System.out.println("Chon chu ho clicked");
    }

    public void onSuaBtnClick(ActionEvent actionEvent) {
        if(this.chuHo == null) return ;
        String maHoKhau = this.maHoKhauTF.getText();
        String maKhuVuc = this.maKhuVucTF.getText();
        String diaChi = this.diaChiTF.getText();
        HoKhau hoKhau = new HoKhau(maHoKhau, this.chuHo, maKhuVuc, diaChi, "", "");
        System.out.println("ho khau sua: "+maHoKhau+maKhuVuc);
        Database.updateOneHoKhau(this.hoKhauSua, hoKhau);
        Stage stage = (Stage) chuHoBtn.getScene().getWindow();
        stage.close();
    }

    public void onHuyBtnClick(ActionEvent actionEvent) {
        Stage stage = (Stage) chuHoBtn.getScene().getWindow();
        stage.close();
    }


    @Override
    public void onDataReceived(NhanKhau chuHo) {
        if(chuHo == null) return ;
        this.chuHo = chuHo;
        chuHoBtn.setText(this.chuHo.getHoTen());
    }
}
