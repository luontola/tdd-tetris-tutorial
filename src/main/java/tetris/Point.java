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
public class Point {

    public final int row;
    public final int col;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Point moveUp() {
        return new Point(row - 1, col);
    }

    public Point moveDown() {
        return new Point(row + 1, col);
    }

    public Point moveLeft() {
        return new Point(row, col - 1);
    }

    public Point moveRight() {
        return new Point(row, col + 1);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point that = (Point) obj;
            return this.row == that.row && this.col == that.col;
        }
        return false;
    }

    public int hashCode() {
        return row * 3 + col * 7;
    }

    public String toString() {
        return "[" + row + "," + col + "]";
    }
}
