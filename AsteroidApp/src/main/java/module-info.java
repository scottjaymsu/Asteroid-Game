module application.asteroidapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens application.asteroidapp to javafx.fxml;

    exports application.asteroidapp;
}