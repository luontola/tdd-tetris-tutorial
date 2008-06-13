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
 * @since Jun 13, 2008
 */
public class GridAsciiView {

    private final Grid grid;

    public GridAsciiView(Grid grid) {
        this.grid = grid;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < grid.rows(); row++) {
            for (int col = 0; col < grid.columns(); col++) {
                sb.append(grid.cellAt(row, col));
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
