// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class MovableGrid implements Grid {

    private final Board board;
    private final Grid shape;
    public final int row;
    public final int column;

    public MovableGrid(Board board, Grid shape) {
        this.board = board;
        this.shape = shape;
        this.row = startingRowOffset(shape);
        this.column = board.columns() / 2 - shape.columns() / 2;
    }

    private MovableGrid(Board board, Grid shape, int row, int column) {
        this.board = board;
        this.shape = shape;
        this.row = row;
        this.column = column;
    }

    private static int startingRowOffset(Grid shape) {
        for (int row = 0; row < shape.rows(); row++) {
            for (int col = 0; col < shape.columns(); col++) {
                if (shape.hasCellAt(row, col)) {
                    return -row;
                }
            }
        }
        throw new IllegalArgumentException("empty shape: " + shape);
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
        return new MovableGrid(board, shape, row + 1, column);
    }

    public MovableGrid moveLeft() {
        return new MovableGrid(board, shape, row, column - 1);
    }

    public MovableGrid moveRight() {
        return new MovableGrid(board, shape, row, column + 1);
    }
}
