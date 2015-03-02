// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class Piece {

    private final char[][] blocks;

    public Piece(String shape) {
        String[] rows = shape.split("\n");
        this.blocks = new char[rows.length][rows.length];
        for (int i = 0; i < rows.length; i++) {
            this.blocks[i] = rows[i].toCharArray();
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int row = 0; row < blocks.length; row++) {
            for (int col = 0; col < blocks[row].length; col++) {
                char c = blocks[row][col];
                s += c;
            }
            s += '\n';
        }
        return s;
    }

    public Piece rotateRight() {
        return this;
    }
}
