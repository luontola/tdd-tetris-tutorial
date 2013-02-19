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
        if (rowInner >= 0
                && rowInner < inner.rows()
                && colInner >= 0
                && colInner < inner.columns()) {
            return inner.colorAt(rowInner, colInner);
        } else {
            return EMPTY;
        }
    }

    public boolean collidesWith(Grid outer) {
        for (int rowInner = 0; rowInner < inner.rows(); rowInner++) {
            for (int colInner = 0; colInner < inner.columns(); colInner++) {
                if (inner.colorAt(rowInner, colInner) != EMPTY) {
                    int rowOuter = rowInner + rowOffset;
                    int colOuter = colInner + colOffset;
                    if (rowOuter >= outer.rows() || outer.colorAt(rowOuter, colOuter) != EMPTY) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public MovableGrid moveDown() {
        return new MovableGrid(inner, rowOffset + 1, colOffset);
    }
}
