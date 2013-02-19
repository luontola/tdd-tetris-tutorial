// Copyright (c) 2008-2013  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class Piece {

    private final char[][] blocks;

    public Piece(String blocks) {
        this(explode(blocks));
    }

    private Piece(char[][] blocks) {
        this.blocks = blocks;
    }

    private static char[][] explode(String shape) {
        char[][] blocks = new char[3][];
        String[] rows = shape.split("\n");
        for (int i = 0; i < rows.length; i++) {
            blocks[i] = rows[i].toCharArray();
        }
        return blocks;
    }

    @Override
    public String toString() {
        String s = "";
        for (char[] rows : blocks) {
            for (char cell : rows) {
                s += cell;
            }
            s += '\n';
        }
        return s;
    }

    public Piece rotateRight() {
        char[][] rotated = new char[3][3];
        for (int row = 0; row < blocks.length; row++) {
            for (int col = 0; col < blocks[row].length; col++) {
                rotated[row][col] = blocks[row][col];
            }
        }
        return new Piece(rotated);
    }
}
