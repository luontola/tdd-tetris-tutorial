// Copyright (c) 2008-2013  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class Piece implements Grid {

    private final char[][] blocks;

    public Piece(String blocks) {
        this(Grids.parse(blocks));
    }

    private Piece(char[][] blocks) {
        this.blocks = blocks;
    }

    @Override
    public int rows() {
        return blocks.length;
    }

    @Override
    public int columns() {
        return blocks.length;
    }

    @Override
    public char colorAt(int row, int col) {
        return blocks[row][col];
    }

    @Override
    public String toString() {
        return Grids.format(this);
    }

    public Piece rotateRight() {
        int dimension = blocks.length;
        char[][] rotated = new char[dimension][dimension];
        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col < dimension; col++) {
                int newRow = col;
                int newCol = dimension - 1 - row;
                rotated[newRow][newCol] = blocks[row][col];
            }
        }
        return new Piece(rotated);
    }

    public Piece rotateLeft() {
        return rotateRight().rotateRight().rotateRight();
    }
}
