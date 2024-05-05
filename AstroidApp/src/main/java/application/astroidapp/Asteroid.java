package application.astroidapp;

import javafx.scene.shape.Polygon;

/**
 * Asteroid Class
 * Inherits from Character Abstract Class.
 */
public class Asteroid extends Character {
    /**
     * Constructor for Asteroid Class
     * @param x Location along x-axis
     * @param y Location along y-axis
     */
    public Asteroid(int x, int y) {
        super(new Polygon(20, -20, 20, 20, -20, 20, -20, -20), x, y);
    }
}
