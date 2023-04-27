module application.cafe94final {
    requires javafx.controls;
    requires javafx.fxml;


    opens application.cafe94final to javafx.fxml;
    exports application.cafe94final;
}