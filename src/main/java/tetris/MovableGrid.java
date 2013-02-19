// Copyright (c) 2008-2013  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class MovableGrid implements Grid {

    private final Grid inner;
    private final int rowOffset;
    private final int colOffset;

    public MovableGrid(Grid inner, int rowOffset, int colOffset) {
        this.inner = inner;
        this.rowOffset = rowOffset;
        this.colOffset = colOffset;
    }

    @Override
    public int rows() {
        return inner.rows();
    }

    @Override
    public int columns() {
        return inner.columns();
    }

    @Override
    public char colorAt(int rowOuter, int colOuter) {
        int rowInner = rowOuter - rowOffset;
        int colInner = colOuter - colOffset;
        if (Grids.isInside(inner, rowInner, colInner)) {
            return inner.colorAt(rowInner, colInner);
        } else {
            return EMPTY;
        }
    }

    public boolean collidesWith(Grid outer) {
        for (int rowInner = 0; rowInner < inner.rows(); rowInner++) {
            for (int colInner = 0; colInner < inner.columns(); colInner++) {
                if (inner.colorAt(rowInner, colInner) == EMPTY) {
                    continue;
                }

                int rowOuter = rowInner + rowOffset;
                int colOuter = colInner + colOffset;
                if (!Grids.isInside(outer, rowOuter, colOuter)
                        || outer.colorAt(rowOuter, colOuter) != EMPTY) {
                    return true;
                }
            }
        }
        return false;
    }

    public MovableGrid moveDown() {
        return new MovableGrid(inner, rowOffset + 1, colOffset);
    }

    public MovableGrid moveLeft() {
        return new MovableGrid(inner, rowOffset, colOffset - 1);
    }
}
