// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

import java.util.Arrays;

public class Board implements Grid {

    private static final char EMPTY = '.';

    private final int rows;
    private final int columns;
    private final char[][] stationary;

    private Block falling;
    private int fallingBlockRow;
    private int fallingBlockColumn;

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
        if (hasFallingAt(row, col)) {
            return falling.getColor();
        } else {
            return stationary[row][col];
        }
    }

    private boolean hasFallingAt(int row, int col) {
        return hasFalling() && row == fallingBlockRow && col == fallingBlockColumn;
    }

    public void drop(Block block) {
        if (hasFalling()) {
            throw new IllegalStateException("a block is already falling");
        }
        startFalling(block);
    }

    public void tick() {
        if (fallingHitsFloor() || fallingHitsStationary()) {
            stopFalling();
        } else {
            fallOneRow();
        }
    }

    public boolean hasFalling() {
        return falling != null;
    }

    private void startFalling(Block block) {
        this.falling = block;
        this.fallingBlockRow = 0;
        this.fallingBlockColumn = 1;
    }

    private void stopFalling() {
        stationary[fallingBlockRow][fallingBlockColumn] = falling.getColor();
        falling = null;
    }

    private boolean fallingHitsFloor() {
        return fallingBlockRow == rows - 1;
    }

    private boolean fallingHitsStationary() {
        return stationary[fallingBlockRow + 1][fallingBlockColumn] != EMPTY;
    }

    private void fallOneRow() {
        fallingBlockRow++;
    }
}
