package application.asteroidapp;

import java.util.Random;
import javafx.scene.shape.Polygon;

/**
 * PolygonFactory Class
 */
public class PolygonFactory {

    /**
     * Polygon Constructor
     * 
     * @return Polygon with randomized size
     */
    public Polygon createPolygon() {
        Random rnd = new Random();

        // Randomize the size of the polygon
        double size = 10 + rnd.nextInt(10);

        // Formula for calculating the angles of the corners of a pentagon
        // http://mathworld.wolfram.com/Pentagon.html
        Polygon polygon = new Polygon();
        double c1 = Math.cos(Math.PI * 2 / 5);
        double c2 = Math.cos(Math.PI / 5);
        double s1 = Math.sin(Math.PI * 2 / 5);
        double s2 = Math.sin(Math.PI * 4 / 5);

        // Set the points of the Polygon to create a pentagon shape
        polygon.getPoints().addAll(
                size, 0.0,
                size * c1, -1 * size * s1,
                -1 * size * c2, -1 * size * s2,
                -1 * size * c2, size * s2,
                size * c1, size * s1);

        // Add random changes to each point for more irregularity
        for (int i = 0; i < polygon.getPoints().size(); i++) {
            int change = rnd.nextInt(5) - 2;
            polygon.getPoints().set(i, polygon.getPoints().get(i) + change);
        }

        return polygon;
    }
}
