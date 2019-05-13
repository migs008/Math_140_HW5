
/**
 *
 * @author SWC-Student
 */
public class Location {

    private double x;
    private double y;

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return ("(" + this.x + "," + this.y + ")");
    }

    public void drawTo(Location b) {
        StdDraw.line(this.x, this.y, b.x, b.y);
    }

    public double distanceTo(Location b) {
        double dx = this.x - b.x;
        double dy = this.y - b.y;
        return Math.sqrt(dx*dx + dy*dy);
    }