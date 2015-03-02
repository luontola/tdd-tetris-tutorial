// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class MovableGrid implements Grid {

    private final Grid shape;

    public MovableGrid(Grid shape) {
        this.shape = shape;
    }

    @Override
    public int rows() {
        return shape.rows();
    }

    @Override
    public int columns() {
        return shape.columns();
    }

    @Override
    public char cellAt(int row, int col) {
        return shape.cellAt(row, col);
    }
}
