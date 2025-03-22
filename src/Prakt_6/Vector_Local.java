package Prakt_6;

import Prakt_2.Vector;

import java.util.NoSuchElementException;

class Vector_Local extends Vector {

    public Vector_Local(double... coords) {
        super(coords);
    }

    public Vector_Local(Vector_Local copy) {
        super(copy);
    }

    public Iterator<Double> iterator() {
        class VectorIterator implements Iterator<Double> {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < getCoords().length;
            }

            @Override
            public Double next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No more elements in the vector.");
                }
                return getCoords()[index++];
            }
        }
        return new VectorIterator();
    }


}
