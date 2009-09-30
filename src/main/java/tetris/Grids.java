/*
 * Copyright (c) 2008-2009  Esko Luontola, www.orfjackal.net
 *
 * You may use and modify this source code freely for personal non-commercial use.
 * This source code may NOT be used as course material without prior written agreement.
 */

package tetris;

import java.util.*;

/**
 * @author Esko Luontola
 */
public abstract class Grids {

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

    public static List<Point> allNonEmptyPointsOf(Grid grid) {
        List<Point> points = new ArrayList<Point>();
        for (Point p : allPointsOf(grid)) {
            if (grid.cellAt(p) != Grid.EMPTY) {
                points.add(p);
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
        String[] rows = s.split("\n");
        char[][] grid = new char[rows.length][rows[0].length()];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                grid[row][col] = rows[row].charAt(col);
            }
        }
        return grid;
    }
}
