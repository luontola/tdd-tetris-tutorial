/*
 * Copyright (c) 2008-2009  Esko Luontola, www.orfjackal.net
 *
 * You may use and modify this source code freely for personal non-commercial use.
 * This source code may NOT be used as course material without prior written agreement.
 */

package tetris;

/**
 * @author Esko Luontola
 */
public class FixedShape implements Grid {

    private final char[][] blocks;

    public FixedShape(String shape) {
        blocks = Grids.fromString(shape);
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
