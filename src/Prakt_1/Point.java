package Prakt_1;


public class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public boolean isInCircle(Point c, double r) {
        return (Math.sqrt(Math.pow(this.x - c.x, 2) + Math.pow(this.y - c.y, 2))) <= r;
    }

    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }
}
