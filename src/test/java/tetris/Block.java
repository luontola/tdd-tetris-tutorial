/*
 * Copyright (c) 2008, Esko Luontola. All Rights Reserved.
 *
 * This program and its source code may be freely used for personal
 * non-commercial educational purposes. Usage as course material
 * is not allowed without prior permission.
 */

package tetris;

/**
 * @author Esko Luontola
 * @since 6.6.2008
 */
public class Block implements RotatableGrid {

    private final char cell;

    public Block(char cell) {
        this.cell = cell;
    }

    public int rows() {
        return 1;
    }

    public int columns() {
        return 1;
    }

    public char cellAt(int row, int col) {
        return cell;
    }

    public RotatableGrid rotateRight() {
        return this;
    }

    public RotatableGrid rotateLeft() {
        return this;
    }
}
