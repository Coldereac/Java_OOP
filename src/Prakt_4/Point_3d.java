package Prakt_4;

import Prakt_1.Point;

public class Point_3d extends Point {
    private double z;

    public Point_3d(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    /**
     * Checks if this point lies inside or on the boundary of a sphere
     *
     * @param c Center of sphere
     * @param r Radius of sphere
     * @return {@code true} if the point is inside or on the sphere, {@code false} otherwise.
     */
    public boolean isInSphere(Point_3d c, double r) {
        return getDistance(c) <= r;
    }

    public double getDistance(Point_3d point) {
        return Math.sqrt(Math.pow(this.getX() - point.getX(), 2) + Math.pow(this.getY() - point.getY(), 2) + Math.pow(this.getZ() - point.getZ(), 2));
    }

    @Override
    public void scale(double s) {
        this.setX(this.getX() * s);
        this.setY(this.getY() * s);
        this.setZ(this.getZ() * s);
    }

    @Override
    public String toString() {
        return String.format("Point_3d( %.2f, %.2f, %.2f)", this.getX(), this.getY(), this.getZ());
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point_3d point3d)) return false;
        if (!super.equals(o)) return false;
        return z == point3d.z;
    }
}
