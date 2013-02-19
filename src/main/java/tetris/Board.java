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
        this.stationary = new char[rows][columns];
        for (char[] row : stationary) {
            Arrays.fill(row, '.');
        }
    }

    public String toString() {
        String s = "";
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (hasFallingAt(row, col)) {
                    s += falling.getColor();
                } else {
                    s += stationary[row][col];
                }
            }
            s += '\n';
        }
        return s;
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
        if (fallingRow + 1 < rows) {
            fallingRow++;
        } else {
            stationary[fallingRow][fallingCol] = falling.getColor();
            falling = null;
        }
    }
}
