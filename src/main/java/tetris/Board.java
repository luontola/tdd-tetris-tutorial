package tetris;

import java.util.Arrays;

public class Board {

    private final int rows;
    private final int columns;
    private final char[][] stationary;

    private Block falling;
    private int fallingRow = 0;
    private int fallingCol = 1;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.stationary = createEmptyBoard(rows, columns);
    }

    private static char[][] createEmptyBoard(int rows, int columns) {
        char[][] board = new char[rows][columns];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        return board;
    }

    public String toString() {
        String s = "";
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                s += colorAt(row, col);
            }
            s += '\n';
        }
        return s;
    }

    private char colorAt(int row, int col) {
        if (hasFallingAt(row, col)) {
            return falling.getColor();
        } else {
            return stationary[row][col];
        }
    }

    private boolean hasFallingAt(int row, int col) {
        return hasFalling() && row == fallingRow && col == fallingCol;
    }

    public boolean hasFalling() {
        return falling != null;
    }

    public void drop(Block block) {
        if (hasFalling()) {
            throw new IllegalStateException("The board has an already falling block");
        }
        this.falling = block;
    }

    public void tick() {
        int nextRow = fallingRow + 1;
        if (nextRow < rows) {
            fallingRow = nextRow;
        } else {
            stopFalling();
        }
    }

    private void stopFalling() {
        stationary[fallingRow][fallingCol] = falling.getColor();
        falling = null;
    }
}
