package Prakt_4;

import Prakt_1.Point;

public class Point_3d extends Point {
    public double z;

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
        return (Math.sqrt(Math.pow(this.x - c.x, 2) + Math.pow(this.y - c.y, 2)) + Math.pow(this.z - c.z, 2)) <= r;
    }

    @Override
    public String toString() {
        return "Point3d(" + x + ", " + y + ", " + z + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point_3d point3d)) return false;
        if (!super.equals(o)) return false;
        return z == point3d.z;
    }
}
