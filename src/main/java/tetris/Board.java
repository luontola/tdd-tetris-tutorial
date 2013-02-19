package tetris;

public class Board implements Grid {

    private final int rows;
    private final int columns;
    private final char[][] stationary;

    private MovableGrid falling;

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
            return falling.colorAt(row - falling.row, col - falling.col);
        } else {
            return stationary[row][col];
        }
    }

    private boolean hasFallingAt(int row, int col) {
        if (!hasFalling()) {
            return false;
        }
        return row >= falling.row
                && row < falling.row + falling.rows()
                && col >= falling.col
                && col < falling.col + falling.columns();
    }

    public boolean hasFalling() {
        return falling != null;
    }

    public void drop(Grid piece) {
        if (hasFalling()) {
            throw new IllegalStateException("The board has an already falling piece");
        }
        this.falling = new MovableGrid(piece);
        this.falling.row = 0;
        this.falling.col = piece.columns();
    }

    public void tick() {
        int nextRow = falling.row + 1;
        int nextCol = falling.col;
        if (isInsideBoard(nextRow) && isEmpty(nextRow, nextCol)) {
            falling.row = nextRow;
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
        stationary[falling.row][falling.col] = falling.colorAt(0, 0);
        falling = null;
    }
}
