// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class Piece implements Grid {

    private final char[][] blocks;

    public Piece(String shape) {
        this.blocks = Grid.parse(shape);
        assert blocks.length == blocks[0].length;
    }

    private Piece(char[][] blocks) {
        this.blocks = blocks;
    }

    public Piece rotateCW() {
        int dimension = blocks.length;
        char[][] rotated = new char[dimension][dimension];
        for (int row = 0; row < blocks.length; row++) {
            for (int col = 0; col < blocks[row].length; col++) {
                rotated[col][dimension - 1 - row] = blocks[row][col];
            }
        }
        return new Piece(rotated);
    }

    public Piece rotateCCW() {
        return this.rotateCW().rotateCW().rotateCW();
    }

    @Override
    public int rows() {
        return blocks.length;
    }

    @Override
    public int columns() {
        return blocks[0].length;
    }

    @Override
    public char cellAt(int row, int col) {
        return blocks[row][col];
    }

    @Override
    public String toString() {
        return Grid.toString(this);
    }
}
