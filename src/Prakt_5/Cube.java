package Prakt_5;

public class Cube extends RectangularPrism {
    public Cube(double a) {
        super(a, a, a);
    }

    @Override
    public void print(){
        System.out.printf("\nCube:\n Sides: %.2f\n Perimeter: %.2f\n Area: %.2f\n Diagonal: %.2f\n", this.getA(), getPerimeter(), getArea(), getDiagonal());
    }
}
