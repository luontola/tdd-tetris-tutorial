// Copyright (c) 2008-2013  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class MovableGrid implements Grid {

    private final Grid grid;
    public int rowOffset;
    public int colOffset;

    public MovableGrid(Grid grid) {
        this.grid = grid;
    }

    @Override
    public int rows() {
        return grid.rows();
    }

    @Override
    public int columns() {
        return grid.columns();
    }

    @Override
    public char colorAt(int row, int col) {
        return grid.colorAt(row - rowOffset, col - colOffset);
    }
}
