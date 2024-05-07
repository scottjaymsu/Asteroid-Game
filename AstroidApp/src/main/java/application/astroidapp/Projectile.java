package application.astroidapp;

import javafx.geometry.Bounds;
import javafx.scene.shape.Polygon;

/**
 * Projectile Class
 * Inherits from Character
 */
public class Projectile extends Character {
    // Keeps track of if the projectile is in bounds or not
    boolean out = false;

    /**
     * Constructor for Projectile Class
     * @param x Location along x-axis
     * @param y Location along y-axis
     */
    public Projectile(int x, int y) {
        super(new Polygon(2, -2, 2, 2, -2, 2, -2, -2), x, y);
    }

    @Override
    /**
     * Moves this character along the x and y axes
     */
    public void move() {
        Polygon character = super.getCharacter();

        double newX = character.getTranslateX() + super.getMovement().getX();
        double newY = character.getTranslateY() + super.getMovement().getY();

        // Get the bounds of the character in the parent's coordinate system
        Bounds bounds = character.getBoundsInParent();
        double minX = bounds.getMinX();
        double minY = bounds.getMinY();
        double maxX = bounds.getMaxX();
        double maxY = bounds.getMaxY();

        // If the new position is outside the screen bounds then prepare to remove the projectile from the screen
        if ((newX < 0) || (newX > GameWindow.width - (maxX - minX)) || (newY < 0) || (newY > GameWindow.height - (maxY - minY))) {
            this.out = true;
        }

        // Update the character's position
        character.setTranslateX(newX);
        character.setTranslateY(newY);
    }

    /**
     * Checks whether the projectile is out of bounds
     * @return True if the projectile is out of the screen, otherwise false
     */
    public boolean isOut() { return this.out; }
}

