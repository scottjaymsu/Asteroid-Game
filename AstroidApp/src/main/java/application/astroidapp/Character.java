package application.astroidapp;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

/**
 * Character Abstract Class
 */
public abstract class Character {
    // Polygon shape
    private Polygon character;
    // Defines a point representing a location in (x,y) coordinate space.
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

    /**
     * Check for collision between characters
     * @param other The other character that is collided with
     * @return If the intersection is 0, there is no collision and False is outputted
     */
    public boolean collide(Character other) {
        Shape collisionArea = Shape.intersect(this.character, other.getCharacter());
        return collisionArea.getBoundsInLocal().getWidth() != -1;
    }
}
