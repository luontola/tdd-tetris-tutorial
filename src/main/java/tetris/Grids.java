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

    public static List<Point> allPointsOf(Grid g) {
        List<Point> points = new ArrayList<Point>();
        for (int row = 0; row < g.rows(); row++) {
            for (int col = 0; col < g.columns(); col++) {
                points.add(new Point(row, col));
            }
        }
        return points;
    }
}
