package tetris;

public class Board implements Grid {

    private final int rows;
    private final int columns;
    private final char[][] stationary;

    private Grid falling;
    private int fallingRow;
    private int fallingCol;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.stationary = Grids.createEmpty(rows, columns);
    }

    public String toString() {
        return Grids.format(this);
    }

    @Override
    public int rows() {
        return rows;
    }

    @Override
    public int columns() {
        return columns;
    }

    public char colorAt(int row, int col) {
        if (hasFallingAt(row, col)) {
            return falling.colorAt(row - fallingRow, col - fallingCol);
        } else {
            return stationary[row][col];
        }
    }

    private boolean hasFallingAt(int row, int col) {
        if (!hasFalling()) {
            return false;
        }
        return row >= fallingRow
                && row < fallingRow + falling.rows()
                && col >= fallingCol
                && col < fallingCol + falling.columns();
    }

    public boolean hasFalling() {
        return falling != null;
    }

    public void drop(Grid piece) {
        if (hasFalling()) {
            throw new IllegalStateException("The board has an already falling piece");
        }
        this.falling = piece;
        this.fallingRow = 0;
        this.fallingCol = piece.columns();
    }

    public void tick() {
        int nextRow = fallingRow + 1;
        int nextCol = fallingCol;
        if (isInsideBoard(nextRow) && isEmpty(nextRow, nextCol)) {
            fallingRow = nextRow;
        } else {
            stopFalling();
        }
    }

    private boolean isInsideBoard(int row) {
        return row < rows;
    }

    private boolean isEmpty(int row, int col) {
        return stationary[row][col] == Grid.EMPTY;
    }

    private void stopFalling() {
        stationary[fallingRow][fallingCol] = falling.colorAt(0, 0);
        falling = null;
    }
}
