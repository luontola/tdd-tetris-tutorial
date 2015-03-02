// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

/**
 * @author Esko Luontola
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

    public char cellAt(Point point) {
        return cell;
    }

    public RotatableGrid rotateRight() {
        return this;
    }

    public RotatableGrid rotateLeft() {
        return this;
    }
}
