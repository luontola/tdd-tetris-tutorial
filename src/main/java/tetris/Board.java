// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

import java.util.Arrays;

public class Board implements Grid {

    private final int rows;
    private final int columns;
    private char[][] stationary;

    private MovableGrid falling;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.stationary = emptyBoard(rows, columns);
    }

    private static char[][] emptyBoard(int rows, int columns) {
        char[][] board = new char[rows][columns];
        for (char[] row : board) {
            Arrays.fill(row, EMPTY);
        }
        return board;
    }

    public String toString() {
        return Grid.toString(this);
    }

    @Override
    public int rows() {
        return rows;
    }

    @Override
    public int columns() {
        return columns;
    }

    @Override
    public char cellAt(int row, int col) {
        char cell = fallingCellAt(row, col);
        if (cell != EMPTY) {
            return cell;
        }
        return stationary[row][col];
    }

    private char fallingCellAt(int row, int col) {
        if (hasFalling()) {
            int pieceRow = row - falling.rowOffset;
            int pieceCol = col - falling.colOffset;
            if (pieceRow >= 0
                    && pieceRow < falling.rows()
                    && pieceCol >= 0
                    && pieceCol < falling.columns()) {
                return falling.cellAt(pieceRow, pieceCol);
            }
        }
        return EMPTY;
    }

    public void drop(Grid piece) {
        if (hasFalling()) {
            throw new IllegalStateException("a block is already falling");
        }
        startFalling(piece);
    }

    public void tick() {
        moveDown();
    }

    public boolean hasFalling() {
        return falling != null;
    }

    private void startFalling(Grid piece) {
        int row = startingRowOffset(piece);
        int column = this.columns() / 2 - piece.columns() / 2;
        this.falling = new MovableGrid(piece, row, column);
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

    private void stopFalling() {
        char[][] newStationary = new char[rows()][columns()];
        for (int row = 0; row < rows(); row++) {
            for (int col = 0; col < columns(); col++) {
                newStationary[row][col] = cellAt(row, col);
            }
        }
        stationary = newStationary;
        falling = null;
    }

    public void moveDown() {
        MovableGrid test = falling.moveDown();
        if (test.isOutside(this) || test.collidesWith(stationary)) {
            stopFalling();
        } else {
            falling = test;
        }
    }

    public void moveLeft() {
        MovableGrid test = falling.moveLeft();
        if (!test.isOutside(this)) {
            falling = test;
        }
    }

    public void moveRight() {
        MovableGrid test = falling.moveRight();
        if (!test.isOutside(this)) {
            falling = test;
        }
    }
}
