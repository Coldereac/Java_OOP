package Prakt_2;
public class Vector {
    private double[] coords;

    public Vector(double ... coords) {
        this.coords = (coords != null) ? coords.clone() : new double[0];
    }

    public Vector(Vector copy) {
        this(copy.coords);
    }

    public void setCoords(double... coords) {
        this.coords = coords;
    }

    public void setCoords(int index, double coord) {
        if (index >= this.coords.length || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        this.coords[index] = coord;
    }

    public double[] getCoords() {
        return coords;
    }

    //Обчислення норми вектора
    public double norm() {
        double sum = 0;
        for (double coord : this.coords) {
            sum += coord * coord;
        }
        return Math.sqrt(sum);
    }

    public int getSize(){
        return coords.length;
    }

    //Вектор можна розділити за модулем, щоб створити одиничний вектор (тобто вектор одиничної довжини)
    //Повертається новий нормалізований вектор
    public Vector normalize() {
        double norm = norm();
        if (norm == 0) throw new ArithmeticException("Cannot normalize zero vector");
        int size = getSize();
        double[] normalized = new double[size];
        for (int i = 0; i < size; i++) {
            normalized[i] = coords[i] / norm;
        }
        return new Vector(normalized);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Vector(");
        for (int i = 0; i < coords.length; i++) {
            if (i > 0) {
                str.append(", ");
            }
            str.append(coords[i]);
        }
        str.append(")");
        return str.toString();
    }
}
