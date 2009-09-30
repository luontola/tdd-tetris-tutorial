/*
 * Copyright (c) 2008-2009  Esko Luontola, www.orfjackal.net
 *
 * You may use and modify this source code freely for personal non-commercial use.
 * This source code may NOT be used as course material without prior written agreement.
 */

package tetris;

/**
 * @author Esko Luontola
 */
public class Piece implements RotatableGrid {

    private final Shape[] orientations;
    private final int current;

    public Piece(String... orientations) {
        this.orientations = new Shape[orientations.length];
        for (int i = 0; i < orientations.length; i++) {
            this.orientations[i] = new Shape(orientations[i]);
        }
        current = 0;
    }

    private Piece(Shape[] orientations, int current) {
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

    private Shape self() {
        return orientations[current];
    }

    public Piece rotateClockwise() {
        return new Piece(orientations, current + 1);
    }

    public Piece rotateCounterClockwise() {
        return new Piece(orientations, current - 1);
    }
}
