package com.example.quanly.controller.covid;

import com.example.quanly.Database;
import com.example.quanly.HelloApplication;
import com.example.quanly.controller.nhan_khau.ChonNhanKhauController;
import com.example.quanly.models.CachLy;
import com.example.quanly.models.NhanKhau;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;

import java.io.IOException;
import java.sql.Date;
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
    private Label namSinhLB;
    @FXML
    private TextField diaDiemCachLyTF;
    @FXML
    private DatePicker tuNgayDatePicker;
    @FXML
    private DatePicker denNgayDatePicker;
    @FXML
    private ChoiceBox<String> mucDoCachLyChoiceBox;
    @FXML
    private CheckBox testCovidChuaCheckBox;
    @FXML
    private GridPane testCovidGridPane;
    @FXML
    private TextField hinhThucTestTF;
    @FXML
    private DatePicker thoiDiemTestDatePicker;
    @FXML
    private Spinner<Integer> soLanTestSpinner;
    @FXML
    private TextField ketQuaCacLanTestTF;


    public void initialize(){
        dialogPane.lookupButton(ButtonType.OK).setDisable(true);

        hoTenLB.textProperty().addListener((observable, oldValue, newValue) -> {
            if(selectedNhanKhau != null){
                dialogPane.lookupButton(ButtonType.OK).setDisable(false);
            }
            else{
                dialogPane.lookupButton(ButtonType.OK).setDisable(false);
            }
        });
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

        testCovidGridPane.setVisible(false);
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1);
        soLanTestSpinner.setValueFactory(valueFactory);
        soLanTestSpinner.setEditable(false);
        testCovidChuaCheckBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(testCovidChuaCheckBox.isSelected()){
                    testCovidGridPane.setVisible(true);
                }
                else
                    testCovidGridPane.setVisible(false);
            }
        });
    }

    public CachLy getCachLy(){
        return new CachLy(-1, maCachLyTF.getText(), selectedNhanKhau.getID(), LocalDate.now().toString(),
                diaDiemCachLyTF.getText(), tuNgayDatePicker.getValue().toString(), denNgayDatePicker.getValue().toString(),
                mucDoCachLyChoiceBox.getValue(), testCovidChuaCheckBox.isSelected(), hinhThucTestTF.getText(),
                soLanTestSpinner.getValue(), thoiDiemTestDatePicker.getValue().toString(), ketQuaCacLanTestTF.getText());
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
                    namSinhLB.setText(selectedNhanKhau.getNamSinh().toString());
                }
                System.out.println("OK clicked");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showThongTinCachLy(CachLy cachLy){
        NhanKhau nhanKhau = Database.findNhanKhau("ID", cachLy.getIdNhanKhau()).get(0);
        maCachLyTF.setText(cachLy.getMaCachLy());
        diaDiemCachLyTF.setText(cachLy.getDiaDiemCachLy());
        chonNhanKhauBtn.setVisible(false);
        mucDoCachLyChoiceBox.setValue(cachLy.getMucDoCachLy());
        hoTenLB.setText(nhanKhau.getHoTen());
        namSinhLB.setText(nhanKhau.getNamSinh().toString());
        tuNgayDatePicker.setValue(Date.valueOf(cachLy.getTuNgay()).toLocalDate());
        tuNgayDatePicker.setValue(Date.valueOf(cachLy.getDenNgay()).toLocalDate());
        testCovidChuaCheckBox.setSelected(cachLy.isDaTestCovidChua());
        if(cachLy.isDaTestCovidChua()){
            hinhThucTestTF.setText(cachLy.getHinhThucTest());
            soLanTestSpinner.setPromptText(cachLy.getSoLanTest()+"");
            thoiDiemTestDatePicker.setValue(Date.valueOf(cachLy.getThoiDiemTest()).toLocalDate());
            ketQuaCacLanTestTF.setText(cachLy.getKetQuaCacLanTest());
            testCovidGridPane.setVisible(true);
        }else
            testCovidGridPane.setVisible(false);

        maCachLyTF.setDisable(true);
        diaDiemCachLyTF.setDisable(true);
        mucDoCachLyChoiceBox.setDisable(true);
        tuNgayDatePicker.setDisable(true);
        denNgayDatePicker.setDisable(true);
        testCovidChuaCheckBox.setDisable(true);
        hinhThucTestTF.setDisable(true);
        soLanTestSpinner.setDisable(true);
        thoiDiemTestDatePicker.setDisable(true);
        ketQuaCacLanTestTF.setDisable(true);
    }
}
