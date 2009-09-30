/*
 * Copyright (c) 2008-2009  Esko Luontola, www.orfjackal.net
 *
 * You may use and modify this source code freely for personal non-commercial use.
 * This source code may NOT be used as course material without prior written agreement.
 */

package tetris;

/**
 * @author Esko Luontola
 * @since 1.10.2009
 */
public class Piece2 implements RotatableGrid {

    private final FixedPiece[] orientations;

    public Piece2(String... orientations) {
        this.orientations = new FixedPiece[orientations.length];
        for (int i = 0; i < orientations.length; i++) {
            this.orientations[i] = new FixedPiece(orientations[i]);
        }
    }

    public RotatableGrid rotateClockwise() {
        return this;
    }

    public RotatableGrid rotateCounterClockwise() {
        return this;
    }

    public int rows() {
        return orientations[0].rows();
    }

    public int columns() {
        return orientations[0].columns();
    }

    public char cellAt(Point point) {
        return orientations[0].cellAt(point);
    }

    public String toString() {
        return Grids.toString(this);
    }
}
