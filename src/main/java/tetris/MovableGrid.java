// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class MovableGrid implements Grid {

    private final Grid shape;
    public final int rowOffset;
    public final int colOffset;

    public MovableGrid(Grid shape, int rowOffset, int colOffset) {
        this.shape = shape;
        this.rowOffset = rowOffset;
        this.colOffset = colOffset;
    }

    public boolean isOutside(Board board) {
        for (int row = 0; row < rows(); row++) {
            for (int col = 0; col < columns(); col++) {
                if (hasCellAt(row, col)) {
                    if (rowOffset + row >= board.rows()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean collidesWith(char[][] board) {
        for (int row = 0; row < rows(); row++) {
            for (int col = 0; col < columns(); col++) {
                if (hasCellAt(row, col)) {
                    int boardRow = rowOffset + row;
                    int boardCol = colOffset + col;
                    if (board[boardRow][boardCol] != EMPTY) {
                        return true;
                    }
                }
            }
        }
        return false;
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

    public MovableGrid moveDown() {
        return new MovableGrid(shape, rowOffset + 1, colOffset);
    }

    public MovableGrid moveLeft() {
        return new MovableGrid(shape, rowOffset, colOffset - 1);
    }

    public MovableGrid moveRight() {
        return new MovableGrid(shape, rowOffset, colOffset + 1);
    }
}
