package Prakt_5;

public class Triangle extends Figure {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        if (a <= 0) {
            throw new IllegalArgumentException("a <= 0");
        }
        if (b <= 0) {
            throw new IllegalArgumentException("b <= 0");
        }
        if (c <= 0) {
            throw new IllegalArgumentException("c <= 0");
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalArgumentException("Invalid sides for a triangle. Triangle, where one side bigger than the sum of two others, can't exist");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    @Override
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public void print() {
        System.out.printf("\nTriangle:\n Sides: %.2f %.2f %.2f\n Perimeter: %.2f\n Area: %.2f\n", a, b, c, getPerimeter(), getArea());
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
}
