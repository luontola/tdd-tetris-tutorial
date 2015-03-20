// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

import java.util.stream.Stream;

public class RotatableShape implements RotatableGrid {

    private final Shape[] orientations;

    public RotatableShape(String... orientations) {
        this.orientations = Stream.of(orientations)
                .map(Shape::new)
                .toArray(Shape[]::new);
    }

    private Shape current() {
        return orientations[0];
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

    @Override
    public RotatableGrid rotateCW() {
        return null;
    }

    @Override
    public RotatableGrid rotateCCW() {
        return null;
    }
}
