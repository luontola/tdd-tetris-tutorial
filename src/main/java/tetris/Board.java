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
        if (hasFalling()) {
            char color = falling.colorAt(row, col);
            if (color != EMPTY) {
                return color;
            }
        }
        return stationary[row][col];
    }

    public boolean hasFalling() {
        return falling != null;
    }

    public void drop(Grid piece) {
        if (hasFalling()) {
            throw new IllegalStateException("The board has an already falling piece");
        }
        this.falling = new MovableGrid(piece, 0, piece.columns());
    }

    public void tick() {
        MovableGrid test = falling.moveDown();
        if (test.isInside(this) && isEmpty(test.rowOffset, test.colOffset)) {
            falling = test;
        } else {
            stopFalling();
        }
    }

    private boolean isEmpty(int row, int col) {
        return Grids.asGrid(stationary).colorAt(row, col) == Grid.EMPTY;
    }

    private void stopFalling() {
        for (int row = 0; row < rows(); row++) {
            for (int col = 0; col < columns(); col++) {
                stationary[row][col] = colorAt(row, col);
            }
        }
        falling = null;
    }
}
