package Prakt_5;

public class RectangularPrism extends Rectangle {
    private double c;

    public RectangularPrism(double a, double b, double c) {
        super(a, b);
        if (c <= 0) {
            throw new IllegalArgumentException("c <= 0");
        }
        this.c = c;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    @Override
    public double getPerimeter() {
        return this.getA() * 4 + this.getB() * 4 + this.getC() * 4;
    }

    @Override
    public double getArea() {
        return this.getA() * this.getB() * this.getC();
    }

    @Override
    public void print() {
        System.out.printf("\nRectangular Prism:\n Sides: %.2f %.2f %.2f\n Perimeter: %.2f\n Area: %.2f\n Diagonal: %.2f\n", this.getA(), this.getB(), this.getC(), getPerimeter(), getArea(), getDiagonal());
    }


}
