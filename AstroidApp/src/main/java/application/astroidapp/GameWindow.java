package application.astroidapp;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

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

        Ship ship = new Ship(150, 100);

        // UI element is added to Pane container as child node
        pane.getChildren().add(ship.getCharacter());

//        // Polygon object is used to draw ship
//        Polygon ship = new Polygon(-5, -5, 10, 0, -5, 5);
//        ship.setTranslateX(300);
//        ship.setTranslateY(200);
//        ship.setRotate(30);
//
//        // UI element is added to Pane container as child node
//        pane.getChildren().add(ship);

        // Scene is specified and the pane is used as the root
        Scene scene = new Scene(pane);
        stage.setTitle("Asteroids!");
        stage.setScene(scene);
        stage.show();

        // Record of pressed keys
        Map<KeyCode, Boolean> pressedKeys = new HashMap<>();

        scene.setOnKeyPressed(event -> {
            pressedKeys.put(event.getCode(), Boolean.TRUE);
        });

        scene.setOnKeyReleased(event -> {
            pressedKeys.put(event.getCode(), Boolean.FALSE);
        });

        /**
         * AnimationTimer to test event handlers
         */
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(pressedKeys.getOrDefault(KeyCode.LEFT, false)) {
                    ship.turnLeft();
                }

                if(pressedKeys.getOrDefault(KeyCode.RIGHT, false)) {
                    ship.turnRight();
                }

                ship.move();
            }
        }.start();
    }

    /**
     * Main entry for program
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

//    public void HandleShip(KeyEvent event, Polygon ship)
//    {
//        if (event.getCode() == KeyCode.LEFT) {
//            ship.setRotate(ship.getRotate() - 5);
//        }
//
//        if (event.getCode() == KeyCode.RIGHT) {
//            ship.setRotate(ship.getRotate() + 5);
//        }
//    }
}
