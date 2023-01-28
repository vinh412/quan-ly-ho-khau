package com.example.quanly.controller.covid;

import com.example.quanly.models.CachLy;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GhiNhanThongTinCachLyController {
    @FXML
    private TextField maCachLyTF;
    @FXML
    private Button chonNhanKhauBtn;
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
        return new CachLy(-1, maCachLyTF.getText(), 26, LocalDate.now().toString(), diaDiemCachLyTF.getText(), tuNgayDatePicker.getValue().toString(), denNgayDatePicker.getValue().toString(), mucDoCachLyChoiceBox.getValue());
    }
}
