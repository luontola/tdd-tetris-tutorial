/*
 * Copyright (c) 2008, Esko Luontola. All Rights Reserved.
 *
 * This program and its source code may be freely used for personal
 * non-commercial educational purposes. Usage as course material
 * is not allowed without prior permission.
 */

package tetris;

/**
 * @author orfjackal
 * @since Jun 6, 2008
 */
public class Block {

    private int row;
    private int col;
    private final char style;

    public Block(char style) {
        this.style = style;
    }

    public void moveTo(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int row() {
        return row;
    }

    public int col() {
        return col;
    }

    public boolean isAt(int row, int col) {
        return row == this.row && col == this.col;
    }

    public char style() {
        return style;
    }
}
