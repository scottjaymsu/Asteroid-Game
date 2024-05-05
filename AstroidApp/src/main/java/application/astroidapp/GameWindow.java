package application.astroidapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 * GameWindow Class
 */
public class GameWindow extends Application {
    /**
     * Automatically called when JavaFX application is launched.
     * Sets up the initial stage with a Pane and a Scene for the game.
     * @param stage The primary stage that is constructed by the platform.
     * @throws Exception If an error occurs during initialization an exception is thrown.
     */
    @Override
    public void start(Stage stage) throws Exception {
        // Pane layout arranges the nodes in the application
        Pane pane = new Pane();
        pane.setPrefSize(600, 400);

        // Polygon object is used to draw ship
        Polygon ship = new Polygon(-5, -5, 10, 0, -5, 5);
        ship.setTranslateX(300);
        ship.setTranslateY(200);
        ship.setRotate(30);

        // UI element is added to Pane container as child node
        pane.getChildren().add(ship);

        // Scene is specified and the pane is used as the root
        Scene scene = new Scene(pane);
        stage.setTitle("Asteroids!");
        stage.setScene(scene);
        stage.show();

        // Ship movement handler
        scene.setOnKeyPressed(event -> HandleShip(event, ship));
    }

    /**
     * Main entry for program
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void HandleShip(KeyEvent event, Polygon ship)
    {
        if (event.getCode() == KeyCode.LEFT) {
            ship.setRotate(ship.getRotate() - 5);
        }

        if (event.getCode() == KeyCode.RIGHT) {
            ship.setRotate(ship.getRotate() + 5);
        }
    }
}
