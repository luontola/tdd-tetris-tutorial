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
 * @since 6.6.2008
 */
public class MovablePiece implements Grid {

    // Coordinates in use:
    // 'abs' absolute = coordinate in the parent grid (game board)
    // 'loc' local    = coordinate of the contained piece
    // 'rel' relative = the local coordinate [0,0] in absolute coordinates

    private final Point rel;
    private final RotatableGrid piece;

    public MovablePiece(RotatableGrid piece) {
        this(0, 0, piece);
    }

    private MovablePiece(int relRow, int relCol, RotatableGrid piece) {
        this.rel = new Point(relRow, relCol);
        this.piece = piece;
    }

    public boolean outsideBoard(int boardRows) {
        for (Point loc : allLocalPoints()) {
            if (piece.cellAt(loc) != EMPTY) {
                if (asAbs(loc).row >= boardRows) {
                    return true;
                }
            }
        }
        return false;
    }

    private List<Point> allLocalPoints() {
        List<Point> points = new ArrayList<Point>();
        for (int row = 0; row < piece.rows(); row++) {
            for (int col = 0; col < piece.columns(); col++) {
                points.add(new Point(row, col));
            }
        }
        return points;
    }

    public boolean isAt(Point abs) {
        Point loc = asLoc(abs);
        return loc.row >= 0 && loc.row < piece.rows()
                && loc.col >= 0 && loc.col < piece.columns()
                && piece.cellAt(loc) != EMPTY;
    }

    public MovablePiece moveTo(Point rel) {
        return new MovablePiece(rel.row, rel.col, piece);
    }

    public MovablePiece moveDown() {
        return new MovablePiece(rel.row + 1, rel.col, piece);
    }

    public int rows() {
        return piece.rows();
    }

    public int columns() {
        return piece.columns();
    }

    public char cellAt(Point abs) {
        return piece.cellAt(asLoc(abs));
    }

    private Point asLoc(Point abs) {
        return new Point(abs.row - rel.row, abs.col - rel.col);
    }

    private Point asAbs(Point loc) {
        return new Point(loc.row + rel.row, loc.col + rel.col);
    }
}
