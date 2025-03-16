package Prakt_5;

public class Rectangle extends Figure {
    private double a;
    private double b;

    public Rectangle(double a, double b) {
        if (a < 0) {
            throw new IllegalArgumentException("a < 0");
        }
        if (b < 0) {
            throw new IllegalArgumentException("b < 0");
        }
        this.a = a;
        this.b = b;
    }

    @Override
    public double getPerimeter() {
        return (a + b) * 2;
    }

    @Override
    public double getArea() {
        return a * b;
    }

    public double getDiagonal() {
        return Math.sqrt(a * a + b * b);
    }
}
