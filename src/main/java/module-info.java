module com.loginpanel.loginpanel {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.loginpanel.loginpanel to javafx.fxml;
    exports com.loginpanel.loginpanel;
}