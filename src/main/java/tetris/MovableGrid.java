// Copyright (c) 2008-2013  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class MovableGrid implements Grid {

    private final Grid grid;
    public final int rowOffset; // TODO: make private
    public final int colOffset; // TODO: make private

    public MovableGrid(Grid grid, int rowOffset, int colOffset) {
        this.grid = grid;
        this.rowOffset = rowOffset;
        this.colOffset = colOffset;
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
    public char colorAt(int rowOuter, int colOuter) {
        int rowInner = rowOuter - rowOffset;
        int colInner = colOuter - colOffset;
        if (rowInner >= 0
                && rowInner < grid.rows()
                && colInner >= 0
                && colInner < grid.columns()) {
            return grid.colorAt(rowInner, colInner);
        } else {
            return EMPTY;
        }
    }

    public boolean isInside(Grid board) {
        return rowOffset < board.rows();
    }

    public MovableGrid moveDown() {
        return new MovableGrid(grid, rowOffset + 1, colOffset);
    }
}
