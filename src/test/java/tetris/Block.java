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

    private final int row;
    private final int col;
    private final char style;

    public Block(char style) {
        this(0, 0, style);
    }

    private Block(int row, int col, char style) {
        this.row = row;
        this.col = col;
        this.style = style;
    }

    public Block moveTo(int row, int col) {
        return new Block(row, col, style);
    }

    public boolean isAt(int row, int col) {
        return row == this.row && col == this.col;
    }

    public int row() {
        return row;
    }

    public int col() {
        return col;
    }

    public char style() {
        return style;
    }

    public Block moveDown() {
        return new Block(row + 1, col, style);
    }
}
