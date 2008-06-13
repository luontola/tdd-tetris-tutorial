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
public class TableAsciiView {

    public static String visualize(Table t) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < t.rows(); row++) {
            for (int col = 0; col < t.columns(); col++) {
                sb.append(t.cellAt(row, col));
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
