// Copyright (c) 2008-2013  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class Piece {

    private final char[][] blocks;

    public Piece(String blocks) {
        this.blocks = explode(blocks);
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
        return this;
    }
}
