// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class Block implements Grid {

    private final char color;

    public Block(char color) {
        this.color = color;
    }

    @Override
    public int rows() {
        return 1;
    }

    @Override
    public int columns() {
        return 1;
    }

    @Override
    public char cellAt(int row, int col) {
        return color;
    }
}
