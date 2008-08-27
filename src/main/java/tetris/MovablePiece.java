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
        for (int row = 0; row < piece.rows(); row++) {
            for (int col = 0; col < piece.columns(); col++) {
                if (piece.cellAt(new Point(row, col)) != EMPTY) {
                    Abs abs = new Loc(row, col).toAbs();
                    if (abs.absRow >= boardRows) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isAt(Point abs) {
        Loc loc = new Abs(abs.row, abs.col).toLoc();
        return loc.locRow >= 0 && loc.locRow < piece.rows()
                && loc.locCol >= 0 && loc.locCol < piece.columns()
                && piece.cellAt(new Point(loc.locRow, loc.locCol)) != EMPTY;
    }

    public MovablePiece moveTo(int relRow, int relCol) {
        return new MovablePiece(relRow, relCol, piece);
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

    public char cellAt(Point absPoint) {
        Loc loc = new Abs(absPoint.row, absPoint.col).toLoc();
        return piece.cellAt(new Point(loc.locRow, loc.locCol));
    }

    private class Abs {

        private final int absRow;
        private final int absCol;

        private Abs(int absRow, int absCol) {
            this.absRow = absRow;
            this.absCol = absCol;
        }

        public Loc toLoc() {
            return new Loc(absRow - rel.row, absCol - rel.col);
        }
    }

    private class Loc {

        private final int locRow;
        private final int locCol;

        private Loc(int locRow, int locCol) {
            this.locRow = locRow;
            this.locCol = locCol;
        }

        public Abs toAbs() {
            return new Abs(locRow + rel.row, locCol + rel.col);
        }
    }
}
