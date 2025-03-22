package Prakt_6;

import Prakt_2.Vector;

import java.util.NoSuchElementException;

class Vector_Inner extends Vector {

    public Vector_Inner(double... coords) {
        super(coords);
    }

    public Vector_Inner(Vector_Inner copy) {
        super(copy);
    }

    public Iterator<Double> iterator() {
        return new VectorIterator();
    }

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
}
