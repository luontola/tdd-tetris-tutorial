// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class Piece implements Grid {

    private final char[][] blocks;

    public Piece(String shape) {
        this.blocks = Grid.parse(shape);
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
