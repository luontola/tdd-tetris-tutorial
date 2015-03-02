// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

import java.util.Arrays;

public class Board {

    private static final char EMPTY = '.';

    private final int rows;
    private final int columns;
    private final char[][] stationary;
    private Block falling;
    private int fallingBlockRow = 0;

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
        String s = "";
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                s += getColorAt(row, col);
            }
            s += '\n';
        }
        return s;
    }

    private char getColorAt(int row, int col) {
        if (hasFallingAt(row, col)) {
            return falling.getColor();
        } else {
            return stationary[row][col];
        }
    }

    private boolean hasFallingAt(int row, int col) {
        return hasFalling() && row == fallingBlockRow && col == 1;
    }

    public boolean hasFalling() {
        return falling != null;
    }

    public void drop(Block block) {
        if (hasFalling()) {
            throw new IllegalStateException("a block is already falling");
        }
        this.falling = block;
    }

    public void tick() {
        if (fallingBlockRow == rows - 1) {
            stationary[fallingBlockRow][1] = falling.getColor();
            falling = null;
        } else {
            fallingBlockRow++;
        }
    }
}
