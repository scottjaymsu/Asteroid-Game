package application.astroidapp;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.*;

/**
 * GameWindow Class
 */
public class GameWindow extends Application {
    // Width of GameWindow that can be accessed throughout project
    public static int width = 300;
    // Height of GameWindow that can be accessed throughout project
    public static int height = 200;

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
        pane.setPrefSize(width,height);

        // Initialize Ship
        Ship ship = new Ship(width / 2, height / 2);

        // Initialize list of Asteroid to avoid
        List<Asteroid> asteroids = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Random rand = new Random();
            Asteroid asteroid = new Asteroid(rand.nextInt(width / 3), rand.nextInt(height));
            asteroids.add(asteroid);
        }

        // UI element is added to Pane container as child node
        pane.getChildren().add(ship.getCharacter());
        asteroids.forEach(asteroid -> pane.getChildren().add(asteroid.getCharacter()));

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
                // Check if LEFT key is pressed and call turnLeft method of Ship
                if(pressedKeys.getOrDefault(KeyCode.LEFT, false)) {
                    ship.turnLeft();
                }

                // Check if RIGHT key is pressed and call turnRIGHT method of Ship
                if(pressedKeys.getOrDefault(KeyCode.RIGHT, false)) {
                    ship.turnRight();
                }

                // Check if UP key is pressed and call accelerate method of Ship
                if(pressedKeys.getOrDefault(KeyCode.UP, false)) {
                    ship.accelerate();
                }

                ship.move();
                asteroids.forEach(asteroid -> asteroid.move());

                // If Ship collides with Asteroid within list of asteroids, animation is stopped
                asteroids.forEach(asteroid -> {
                    if (ship.collide(asteroid)) {
                        stop();
                    }
                });
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
