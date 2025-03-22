package Prakt_6;

import Prakt_2.Vector;

import java.util.NoSuchElementException;

class Vector_Anonymous extends Vector {

    public Vector_Anonymous(double... coords) {
        super(coords);
    }

    public Vector_Anonymous(Vector_Anonymous copy) {
        super(copy);
    }

    public Iterator<Double> iterator() {
        return new Iterator<Double>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < getCoords().length;
            }

            @Override
            public Double next() {
                return getCoords()[index++];
            }
        };
    }
}
