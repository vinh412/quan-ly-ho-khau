module com.example.quanly {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.quanly to javafx.fxml;
    exports com.example.quanly;
    exports com.example.quanly.controller;
    opens com.example.quanly.controller to javafx.fxml;
    exports com.example.quanly.controller.nhan_khau;
    opens com.example.quanly.controller.nhan_khau to javafx.fxml;
    exports com.example.quanly.controller.ho_khau;
    opens com.example.quanly.controller.ho_khau to javafx.fxml;
    exports com.example.quanly.controller.covid;
    opens com.example.quanly.controller.covid to javafx.fxml;
    exports com.example.quanly.controller.thong_ke;
    opens com.example.quanly.controller.thong_ke to javafx.fxml;

    opens com.example.quanly.models;
}
