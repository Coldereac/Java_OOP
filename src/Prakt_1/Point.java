package Prakt_1;

import java.util.Objects;

public class Point implements Comparable<Point> {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Checks if this point lies inside or on the boundary of a circle
     *
     * @param c Center of circle
     * @param r Radius of circle
     * @return {@code true} if the point is inside or on the circle, {@code false} otherwise.
     */
    public boolean isInCircle(Point c, double r) {
        return getDistance(c) <= r;
    }

    public double getDistance(Point point) {
        return Math.sqrt(Math.pow(this.x - point.x, 2) + Math.pow(this.y - point.y, 2));
    }

    public void scale(double s) {
        this.x *= s;
        this.y *= s;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point point)) return false;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public int compareTo( Point o) {
        int cmpX = Double.compare(this.x, o.x);
        if (cmpX != 0) {
            return cmpX;
        }
        return Double.compare(this.y, o.y);
    }
}
