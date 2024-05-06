package application.astroidapp;

import javafx.scene.shape.Polygon;

/**
 * Projectile Class
 * Inherits from Character
 */
public class Projectile extends Character {
    /**
     * Constructor for Projectile Class
     * @param x Location along x-axis
     * @param y Location along y-axis
     */
    public Projectile(int x, int y) {
        super(new Polygon(2, -2, 2, 2, -2, 2, -2, -2), x, y);
    }
}
