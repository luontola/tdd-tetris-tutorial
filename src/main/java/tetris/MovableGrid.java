// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class MovableGrid implements Grid {

    private final Grid shape;
    public final int row;
    public final int column;

    public MovableGrid(Grid shape, int row, int column) {
        this.shape = shape;
        this.row = row;
        this.column = column;
    }

    public boolean collides(char[][] board) {
        for (int row = 0; row < rows(); row++) {
            for (int col = 0; col < columns(); col++) {
                if (hasCellAt(row, col)) {
                    int boardRow = this.row + row;
                    int boardCol = this.column + col;
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
        return new MovableGrid(shape, row + 1, column);
    }

    public MovableGrid moveLeft() {
        return new MovableGrid(shape, row, column - 1);
    }

    public MovableGrid moveRight() {
        return new MovableGrid(shape, row, column + 1);
    }
}
