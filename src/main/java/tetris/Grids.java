/*
 * Copyright (c) 2008, Esko Luontola. All Rights Reserved.
 *
 * This program and its source code may be freely used for personal
 * non-commercial educational purposes. Usage as course material
 * is not allowed without prior permission.
 */

package tetris;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Esko Luontola
 * @since 27.8.2008
 */
public class Grids {

    private Grids() {
    }

    public static List<Point> allPointsOf(Grid grid) {
        List<Point> points = new ArrayList<Point>();
        for (int row = 0; row < grid.rows(); row++) {
            for (int col = 0; col < grid.columns(); col++) {
                points.add(new Point(row, col));
            }
        }
        return points;
    }

    public static String toString(Grid grid) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < grid.rows(); row++) {
            for (int col = 0; col < grid.columns(); col++) {
                sb.append(grid.cellAt(new Point(row, col)));
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public static char[][] fromString(String s) {
        String[] lines = s.split("\n");
        char[][] grid = new char[lines.length][lines.length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                grid[row][col] = lines[row].charAt(col);
            }
        }
        return grid;
    }
}
