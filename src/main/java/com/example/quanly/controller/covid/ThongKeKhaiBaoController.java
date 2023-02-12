package com.example.quanly.controller.covid;

import com.example.quanly.Database;
import com.example.quanly.HelloApplication;
import com.example.quanly.models.CachLy;
import com.example.quanly.models.KhaiBaoYTe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class ThongKeKhaiBaoController implements Initializable {
    @FXML
    private TableView<KhaiBaoYTe> khaiBaoYTeTableView;
    @FXML
    private TableColumn<KhaiBaoYTe, String> maPhieuKhaiBaoYTeColumn;
    @FXML
    private TableColumn<KhaiBaoYTe, Integer> idNhanKhauColumn;
    @FXML
    private TableColumn<KhaiBaoYTe, String> thoiGianKhaiBaoColumn;

    private ObservableList<KhaiBaoYTe> khaiBaoYTeObservableList = FXCollections.observableArrayList();
    private ArrayList<KhaiBaoYTe> khaiBaoYTeArrayList;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        maPhieuKhaiBaoYTeColumn.setCellValueFactory(new PropertyValueFactory<>("maPhieuKhaiBaoYTe"));
        idNhanKhauColumn.setCellValueFactory(new PropertyValueFactory<>("idNhanKhau"));
        thoiGianKhaiBaoColumn.setCellValueFactory(new PropertyValueFactory<>("thoiGianKhaiBao"));

        khaiBaoYTeArrayList = Database.findKhaiBao("*", "");
        khaiBaoYTeObservableList.addAll(khaiBaoYTeArrayList);
        khaiBaoYTeTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        khaiBaoYTeTableView.setItems(khaiBaoYTeObservableList);


        khaiBaoYTeTableView.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2){
                KhaiBaoYTe khaiBaoYTe = khaiBaoYTeTableView.getSelectionModel().getSelectedItem();
                try {
                    // load the fxml file and create a new popup dialog
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("covid/khai_bao_y_te.fxml"));
                    DialogPane khaiBaoYTeDialogPane = fxmlLoader.load();

                    Dialog<ButtonType> dialog = new Dialog<>();
                    dialog.setDialogPane(khaiBaoYTeDialogPane);
                    dialog.setTitle("Thông tin khai báo y tế");

                    KhaiBaoYTeController khaiBaoYTeController = fxmlLoader.getController();
                    khaiBaoYTeController.showKhaiBaoYTe(khaiBaoYTe);
                    Optional<ButtonType> clickedButton = dialog.showAndWait();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    @FXML
    private void onTimKiemBtnClick(){

    }
}
