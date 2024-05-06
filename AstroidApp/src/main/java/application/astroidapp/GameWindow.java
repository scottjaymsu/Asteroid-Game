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
        Asteroid asteroid = new Asteroid(50, 50);

        // UI element is added to Pane container as child node
        pane.getChildren().add(ship.getCharacter());
        pane.getChildren().add(asteroid.getCharacter());

        asteroid.turnRight();
        asteroid.turnRight();
        asteroid.accelerate();
        asteroid.accelerate();

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
         * AnitmationTimer object is used to update the game elements and their methods.
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

                if(pressedKeys.getOrDefault(KeyCode.UP, false)) {
                    ship.accelerate();
                }

                ship.move();
                asteroid.move();

                // If Ship collides with Asteroid, animation is stopped
                if (ship.collide(asteroid)) {
                    stop();
                }
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
}
