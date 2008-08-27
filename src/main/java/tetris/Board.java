/*
 * Copyright (c) 2008, Esko Luontola. All Rights Reserved.
 *
 * This program and its source code may be freely used for personal
 * non-commercial educational purposes. Usage as course material
 * is not allowed without prior permission.
 */

package tetris;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Esko Luontola
 * @since 6.6.2008
 */
public class Board implements Grid {

    private MovablePiece falling;
    private char[][] blocks;

    public Board(int rows, int columns) {
        blocks = new char[rows][columns];
        for (char[] tmp : blocks) {
            Arrays.fill(tmp, EMPTY);
        }
    }

    public void tick() {
        MovablePiece test = falling.moveDown();
        if (conflictsWithBoard(test)) {
            stopFalling();
        } else {
            falling = test;
        }
    }

    private boolean conflictsWithBoard(MovablePiece p) {
        return p.outsideBoard(rows()) || hitsStationaryBlock(p);
    }

    private boolean hitsStationaryBlock(MovablePiece piece) {
        for (Point point : allBoardPoints()) {
            if (piece.isAt(point) && piece.cellAt(point) != EMPTY
                    && blocks[point.row][point.col] != EMPTY) {
                return true;
            }
        }
        return false;
    }

    public void drop(RotatableGrid piece) {
        if (hasFalling()) {
            throw new IllegalStateException("Another piece may not be dropped when one is already falling");
        }
        Point topCenter = new Point(0, columns() / 2 - piece.columns() / 2);
        falling = new MovablePiece(piece).moveTo(topCenter);
    }

    public boolean hasFalling() {
        return falling != null;
    }

    private void stopFalling() {
        assert hasFalling();
        copyToBoard(falling);
        falling = null;
    }

    private void copyToBoard(MovablePiece piece) {
        for (Point point : allBoardPoints()) {
            if (piece.isAt(point) && piece.cellAt(point) != EMPTY) {
                blocks[point.row][point.col] = piece.cellAt(point);
            }
        }
    }

    private List<Point> allBoardPoints() {
        List<Point> points = new ArrayList<Point>();
        for (int row = 0; row < rows(); row++) {
            for (int col = 0; col < columns(); col++) {
                points.add(new Point(row, col));
            }
        }
        return points;
    }

    public int rows() {
        return blocks.length;
    }

    public int columns() {
        return blocks[0].length;
    }

    public char cellAt(Point point) {
        if (falling != null && falling.isAt(point)) {
            return falling.cellAt(point);
        } else {
            return blocks[point.row][point.col];
        }
    }

    public String toString() {
        return new GridAsciiView(this).toString();
    }
}
