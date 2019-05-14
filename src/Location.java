
/*
Author: Miguel Aquino
Sources: Ian Rysdale
Date: 5/13/2019
Purpose: Stores Location objects and draws the location routes.
*/
public class Location {

    private double x;
    private double y;

    /*
    Purpose: Initializes the instance variables.
    Parameters: double of the x and y points for the coordinates.
    Return: N/A
    */
    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /*
    Purpose: Returns the String representation.
    Parameters: N/A
    Return: String representation of the x and y coordinates.
    */
    public String toString() {
        return ("(" + this.x + "," + this.y + ")");
    }

    /*
    Purpose: Draws the line segment between the current Location and the input parameter.
    Parameters: Location object contains x and y points to draw.
    Return: N/A
    */
    public void drawTo(Location b) {
        StdDraw.line(this.x, this.y, b.x, b.y);
    }

    /*
    Purpose: Returns the Euclidean distance between the current Location and the input parameter.
    Parameters: Location object contains x and y points to measure the distance of the two.
    Return: Calculated distance between the points.
    */
    public double distanceTo(Location b) {
        double dx = this.x - b.x;
        double dy = this.y - b.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}