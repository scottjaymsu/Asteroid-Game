package application.asteroidapp;

import java.util.Random;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

/**
 * Asteroid Class
 * Inherits from Character Class.
 */
public class Asteroid extends Character {
    // Randomness to add to movement
    private double rotationalMovement;

    /**
     * Constructor for Asteroid Class
     * 
     * @param x Location along x-axis
     * @param y Location along y-axis
     */
    public Asteroid(int x, int y) {
        // Calls constructor of superclass Character
        // Passes the randomized Polygon from PolygonFactory as parameter
        super(new PolygonFactory().createPolygon(), x, y);

        Random rand = new Random();

        // Set asteroid color to red
        super.getCharacter().setFill(Color.RED);

        // Randomly rotate the Polygon
        super.getCharacter().setRotate(rand.nextInt(360));

        // Amount of times to call accelerate method
        int acceleration = 1 + rand.nextInt(10);
        for (int i = 0; i < acceleration; i++) {
            accelerate();
        }

        // Set rotational movement with randomness
        this.rotationalMovement = 0.5 - rand.nextDouble();
    }

    @Override
    public void move() {
        // Call move method from superclass Character
        super.move();

        // Add rotational movement to the asteroid's rotation
        super.getCharacter().setRotate(super.getCharacter().getRotate() + rotationalMovement);
    }
}
