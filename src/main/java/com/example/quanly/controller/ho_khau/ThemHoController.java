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
import java.util.ResourceBundle;

public class ThemHoController implements Initializable {

    public TextField maHoKhauTF;
    public TextField maKhuVucTF;
    public TextField diaChiTF;
    public AnchorPane themhoLayout;
    @FXML
    private Button chuHoBtn;
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    @FXML
    private Button huyBtn;
    private NhanKhau chuHo;
    public void onThemHoBtnClick(){
        if(this.chuHo == null) return ;
        String maHoKhau = maHoKhauTF.getText();
        String maKhuVuc = maKhuVucTF.getText();
        String diaChi = diaChiTF.getText();
        HoKhau hoKhau = new HoKhau(maHoKhau, this.chuHo, maKhuVuc, diaChi, "", "");
        Database.insertHoKhau(hoKhau);
        Stage stage  = (Stage) huyBtn.getScene().getWindow();
        stage.close();
    }

    public void onHuyButtonClick(){
        Stage stage  = (Stage) huyBtn.getScene().getWindow();
        stage.close();
    }

    public void onDataReceived(NhanKhau chuHo){
        if(chuHo == null) return ;
        this.chuHo = chuHo;
        chuHoBtn.setText(this.chuHo.getHoTen());
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
}