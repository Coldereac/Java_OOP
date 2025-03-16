package Prakt_5;

public class Circle extends Figure {
    private double radius;

    public Circle(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius is negative");
        }
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void print() {
        System.out.printf("Circle:\n Radius: %.2f\n Area: %.2f\n Perimeter: %.2f\n", this.radius, getArea(), getPerimeter());
    }

    public double getRadius() {
        return radius;
    }
}
