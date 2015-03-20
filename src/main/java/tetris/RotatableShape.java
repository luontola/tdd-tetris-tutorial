// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

import java.util.stream.Stream;

public class RotatableShape implements RotatableGrid {

    private final Shape[] orientations;
    private final int current;

    public RotatableShape(String... orientations) {
        this.current = 0;
        this.orientations = Stream.of(orientations)
                .map(Shape::new)
                .toArray(Shape[]::new);
    }

    private RotatableShape(int current, Shape[] orientations) {
        this.current = current;
        this.orientations = orientations;
    }

    private Shape current() {
        return orientations[current];
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
    public RotatableShape rotateCW() {
        return new RotatableShape(current + 1, orientations);
    }

    @Override
    public RotatableShape rotateCCW() {
        return null;
    }
}
