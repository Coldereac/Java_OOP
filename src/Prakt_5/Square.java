package Prakt_5;

public class Square extends Rectangle {
    public Square(double a) {
        super(a, a);
    }

    @Override
    public void print() {
        System.out.printf("\nSquare:\n Side: %.2f\n Perimeter: %.2f\n Area: %.2f\n Diagonal: %.2f\n", this.getA(), getPerimeter(), getArea(), getDiagonal());
    }
}
