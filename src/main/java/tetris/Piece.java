// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

/**
 * @author Esko Luontola
 */
public class Piece implements RotatableGrid, Grid {

    private final char[][] blocks;

    /**
     * A piece must have equal width and height,
     * and the length of the edge must be odd.
     */
    public Piece(String shape) {
        this.blocks = Grids.fromString(shape);
        assert blocks.length == blocks[0].length;
        assert blocks.length % 2 == 1;
    }

    private Piece(char[][] blocks) {
        this.blocks = blocks;
    }

    public Piece rotateRight() {
        return new Piece(rotateRight(blocks));
    }

    public Piece rotateLeft() {
        return rotateRight().rotateRight().rotateRight();
    }

    /**
     * Coordinates when rotating a 3x3 grid right:
     * <pre>
     * before   after
     * 0-0      0-2
     * 0-1      1-2
     * 0-2      2-2
     * 1-0      0-1
     * 1-1      1-1
     * 1-2      2-1
     * 2-0      0-0
     * 2-1      1-0
     * 2-2      2-0
     * </pre>
     * Coordinates when rotating a 5x5 grid right:
     * <pre>
     * before   after
     * 0-0      0-4
     * 0-1      1-4
     * 0-2      2-4
     * 0-3      3-4
     * 0-4      4-4
     * 1-0      0-3
     * 1-1      1-3
     * 1-2      2-3
     * 1-3      3-3
     * 1-4      4-3
     * ...
     * </pre>
     */
    private static char[][] rotateRight(char[][] x) {
        char[][] rotated = new char[x.length][x.length];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                rotated[j][(x.length - 1) - i] = x[i][j];
            }
        }
        return rotated;
    }

    public int rows() {
        return blocks.length;
    }

    public int columns() {
        return blocks[0].length;
    }

    public char cellAt(Point point) {
        return blocks[point.row][point.col];
    }

    public String toString() {
        return Grids.toString(this);
    }
}
