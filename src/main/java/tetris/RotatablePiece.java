// Copyright (c) 2008-2010  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

/**
 * @author Esko Luontola
 */
public class RotatablePiece implements RotatableGrid {

    private final FixedShape[] orientations;
    private final int current;

    public RotatablePiece(String... orientations) {
        this.orientations = new FixedShape[orientations.length];
        for (int i = 0; i < orientations.length; i++) {
            this.orientations[i] = new FixedShape(orientations[i]);
        }
        current = 0;
    }

    private RotatablePiece(FixedShape[] orientations, int current) {
        this.orientations = orientations;
        this.current = fixArrayIndex(current, orientations);
    }

    private static int fixArrayIndex(int index, Object[] array) {
        while (index < 0) {
            index += array.length;
        }
        return index % array.length;
    }

    public int rows() {
        return self().rows();
    }

    public int columns() {
        return self().columns();
    }

    public char cellAt(Point point) {
        return self().cellAt(point);
    }

    public String toString() {
        return self().toString();
    }

    private FixedShape self() {
        return orientations[current];
    }

    public RotatablePiece rotateClockwise() {
        return new RotatablePiece(orientations, current + 1);
    }

    public RotatablePiece rotateCounterClockwise() {
        return new RotatablePiece(orientations, current - 1);
    }
}
