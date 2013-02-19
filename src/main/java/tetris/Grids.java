// Copyright (c) 2008-2013  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class Grids {

    public static char[][] parse(String shape) {
        String[] rows = shape.split("\n");
        char[][] blocks = new char[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            blocks[i] = rows[i].toCharArray();
        }
        return blocks;
    }

    public static String format(Grid shape) {
        String s = "";
        for (int row = 0; row < shape.rows(); row++) {
            for (int col = 0; col < shape.columns(); col++) {
                s += shape.colorAt(row, col);
            }
            s += '\n';
        }
        return s;
    }
}
