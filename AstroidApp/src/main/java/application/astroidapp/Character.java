package application.astroidapp;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;

/**
 * Character Abstract Class
 */
public abstract class Character {

    private Polygon character;
    private Point2D movement;

    /**
     * Constructor for Character class
     * @param polygon Polygon that will be used for drawing
     * @param x Location along x-axis
     * @param y Location along y-axis
     */
    public Character(Polygon polygon, int x, int y) {
        this.character = polygon;
        this.character.setTranslateX(x);
        this.character.setTranslateY(y);

        this.movement = new Point2D(0, 0);
    }

    /**
     * Gets the polygon used for this character
     * @return Polygon object
     */
    public Polygon getCharacter() {
        return character;
    }

    /**
     * Rotates this character to the left
     */
    public void turnLeft() {
        this.character.setRotate(this.character.getRotate() - 5);
    }

    /**
     * Rotates this character to the right
     */
    public void turnRight() {
        this.character.setRotate(this.character.getRotate() + 5);
    }

    /**
     * Moves this character along the x and/or y axes
     */
    public void move() {
        this.character.setTranslateX(this.character.getTranslateX() + this.movement.getX());
        this.character.setTranslateY(this.character.getTranslateY() + this.movement.getY());
    }

    /**
     * Accelerates the speed at which this character moves
     */
    public void accelerate() {
        double changeX = Math.cos(Math.toRadians(this.character.getRotate()));
        double changeY = Math.sin(Math.toRadians(this.character.getRotate()));

        changeX *= 0.05;
        changeY *= 0.05;

        this.movement = this.movement.add(changeX, changeY);
    }
}
