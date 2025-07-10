package application.asteroidapp;

import javafx.scene.shape.Polygon;

/**
 * Ship Class
 * Inherits from Character Class.
 */
public class Ship extends Character {
    /**
     * Constructor for Ship Class
     * 
     * @param x Location along x-axis
     * @param y Location along y-axis
     */
    public Ship(int x, int y) {
        super(new Polygon(-5, -5, 10, 0, -5, 5), x, y);
    }
}
