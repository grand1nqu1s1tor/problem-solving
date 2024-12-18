package uber.model;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Location {
    private double x;
    private double y;

    public double getDistance(Location currentLoc) {
        return sqrt(pow((currentLoc.x - this.x), 2) + pow((currentLoc.y - this.y), 2));
    }
}
