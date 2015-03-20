// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

import java.util.stream.Stream;

public class RotatablePiece implements RotatableGrid {

    private final Piece[] orientations;
    private final int current;

    public RotatablePiece(String... orientations) {
        this.current = 0;
        this.orientations = Stream.of(orientations)
                .map(Piece::new)
                .toArray(Piece[]::new);
    }

    private RotatablePiece(int current, Piece[] orientations) {
        this.current = (current + orientations.length) % orientations.length;
        this.orientations = orientations;
    }

    private Piece current() {
        return orientations[current];
    }

    @Override
    public RotatablePiece rotateCW() {
        return new RotatablePiece(current + 1, orientations);
    }

    @Override
    public RotatablePiece rotateCCW() {
        return new RotatablePiece(current - 1, orientations);
    }

    @Override
    public String toString() {
        return current().toString();
    }

    @Override
    public int rows() {
        return current().rows();
    }

    @Override
    public int columns() {
        return current().columns();
    }

    @Override
    public char cellAt(int row, int col) {
        return current().cellAt(row, col);
    }
}
