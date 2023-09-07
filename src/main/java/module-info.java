module com.example.tickit {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.tickit to javafx.fxml;
    exports com.example.tickit;
    exports com.example.tickit.Controllers;
    exports com.example.tickit.Models;
    opens com.example.tickit.Controllers to javafx.fxml;
    opens com.example.tickit.Models to java.base;

}