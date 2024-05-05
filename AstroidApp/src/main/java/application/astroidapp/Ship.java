package application.astroidapp;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;

/**
 * Ship Class
 */
public class Ship {
    // Polygon object used to draw ship
    private Polygon character;
    // Position (x,y) on pane
    private Point2D movement;

    /**
     * Constructor for Ship Class
     * @param x location on x-axis
     * @param y location on y-axis
     */
    public Ship(int x, int y) {
        this.character = new Polygon(-5, -5, 10, 0, -5, 5);
        this.character.setTranslateX(x);
        this.character.setTranslateY(y);

        this.movement = new Point2D(1, 0);
    }

    /**
     * Gets the polygon used for the ship object
     * @return Polygon object
     */
    public Polygon getCharacter() {
        return character;
    }

    /**
     * Rotates the ship object to the left
     */
    public void turnLeft() {
        this.character.setRotate(this.character.getRotate() - 5);
    }

    /**
     * Rotates the ship object to the right
     */
    public void turnRight() {
        this.character.setRotate(this.character.getRotate() + 5);
    }

    /**
     * Moves the ship object along the x and/or y axis
     */
    public void move() {
        this.character.setTranslateX(this.character.getTranslateX() + this.movement.getX());
        this.character.setTranslateY(this.character.getTranslateY() + this.movement.getY());
    }
}
