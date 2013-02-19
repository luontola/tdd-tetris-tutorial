package tetris;

public class Board {

    private final int rows;
    private final int columns;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public String toString() {
        String s = "";
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                s += ".";
            }
            s += "\n";
        }
        return s;
    }

    public boolean hasFalling() {
        return false;
    }
}
