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

    private final int relRow;
    private final int relCol;
    private final RotatableGrid piece;

    public MovablePiece(RotatableGrid piece) {
        this(0, 0, piece);
    }

    private MovablePiece(int relRow, int relCol, RotatableGrid piece) {
        this.relRow = relRow;
        this.relCol = relCol;
        this.piece = piece;
    }

    public int relRow() {
        return relRow;
    }

    public int relCol() {
        return relCol;
    }

    public static boolean outsideBoard(MovablePiece p, Board board) {
        for (int row = 0; row < p.piece.rows(); row++) {
            for (int col = 0; col < p.piece.columns(); col++) {
                if (p.piece.cellAt(row, col) == EMPTY) {
                    continue;
                }
                Abs abs = p.new Loc(row, col).toAbs();
                if (abs.absRow >= board.rows()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isAt(int absRow, int absCol) {
        // TODO: the empty cells of the moving piece may overlap stationary non-empty cells
        Loc loc = new Abs(absRow, absCol).toLoc();
        return loc.locRow >= 0 && loc.locRow < piece.rows()
                && loc.locCol >= 0 && loc.locCol < piece.columns();
    }

    public MovablePiece moveTo(int relRow, int relCol) {
        return new MovablePiece(relRow, relCol, piece);
    }

    public MovablePiece moveDown() {
        return new MovablePiece(relRow + 1, relCol, piece);
    }

    public int rows() {
        return piece.rows();
    }

    public int columns() {
        return piece.columns();
    }

    public char cellAt(int absRow, int absCol) {
        Loc loc = new Abs(absRow, absCol).toLoc();
        return piece.cellAt(loc.locRow, loc.locCol);
    }

    private class Abs {

        private final int absRow;
        private final int absCol;

        private Abs(int absRow, int absCol) {
            this.absRow = absRow;
            this.absCol = absCol;
        }

        public Loc toLoc() {
            return new Loc(absRow - relRow, absCol - relCol);
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
            return new Abs(locRow + relRow, locCol + relCol);
        }
    }
}
