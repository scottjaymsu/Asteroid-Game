module application.astroidapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens application.astroidapp to javafx.fxml;
    exports application.astroidapp;
}