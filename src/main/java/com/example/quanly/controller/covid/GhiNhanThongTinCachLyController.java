package com.example.quanly.controller.covid;

import com.example.quanly.Database;
import com.example.quanly.HelloApplication;
import com.example.quanly.controller.nhan_khau.ChonNhanKhauController;
import com.example.quanly.models.CachLy;
import com.example.quanly.models.NhanKhau;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class GhiNhanThongTinCachLyController {
    @FXML
    private DialogPane dialogPane;
    private NhanKhau selectedNhanKhau;
    @FXML
    private TextField maCachLyTF;
    @FXML
    private Button chonNhanKhauBtn;
    @FXML
    private Label hoTenLB;
    @FXML
    private TextField diaDiemCachLyTF;
    @FXML
    private DatePicker tuNgayDatePicker;
    @FXML
    private DatePicker denNgayDatePicker;
    @FXML
    private ChoiceBox<String> mucDoCachLyChoiceBox;

    public void initialize(){
        mucDoCachLyChoiceBox.setItems(FXCollections.observableArrayList("F0", "F1", "F2", "F3"));
        mucDoCachLyChoiceBox.setValue("F0");

        // Converter
        StringConverter<LocalDate> converter = new StringConverter<>() {
            final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            @Override
            public String toString(LocalDate date) {
                if(date != null)
                    return dateTimeFormatter.format(date);
                else
                    return "";
            }

            @Override
            public LocalDate fromString(String string) {
                if(string != null && !string.isEmpty())
                    return LocalDate.parse(string, dateTimeFormatter);
                else
                    return null;
            }
        };
        tuNgayDatePicker.setConverter(converter);
        tuNgayDatePicker.setPromptText("yyyy-MM-dd");
        tuNgayDatePicker.setValue(LocalDate.now());
        denNgayDatePicker.setConverter(converter);
        denNgayDatePicker.setPromptText("yyyy-MM-dd");
        denNgayDatePicker.setValue(LocalDate.now());
    }

    public CachLy getCachLy(){
        return new CachLy(-1, maCachLyTF.getText(), selectedNhanKhau.getID(), LocalDate.now().toString(), diaDiemCachLyTF.getText(), tuNgayDatePicker.getValue().toString(), denNgayDatePicker.getValue().toString(), mucDoCachLyChoiceBox.getValue());
    }
    @FXML
    private void onChonNhanKhauBtnClick(){
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
                this.selectedNhanKhau = chonNhanKhauController.getSelectedNhanKhau();
                if(selectedNhanKhau != null){
                    hoTenLB.setText(selectedNhanKhau.getHoTen());
                }
                System.out.println("OK clicked");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
