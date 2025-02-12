package Prakt_1;


public class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Checks if this point lies inside or on the boundary of a circle
     * @param c Center of circle
     * @param r Radius of circle
     * @return {@code true} if the point is inside or on the circle, {@code false} otherwise.
     */
    public boolean isInCircle(Point c, double r) {
        return (Math.sqrt(Math.pow(this.x - c.x, 2) + Math.pow(this.y - c.y, 2))) <= r;
    }

    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point point)) return false;
        return x == point.x && y == point.y;
    }
}
