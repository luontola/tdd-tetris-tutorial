// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

/**
 * @author Esko Luontola
 */
public class MovablePiece implements Grid {

    // Coordinates in use:
    // 'abs' absolute = coordinate in the parent grid (game board)
    // 'loc' local    = coordinate of the contained piece
    // 'rel' relative = the local coordinate [0,0] in absolute coordinates

    private final Point rel;
    private final RotatableGrid piece;

    public MovablePiece(RotatableGrid piece) {
        this(new Point(0, 0), piece);
    }

    private MovablePiece(Point rel, RotatableGrid piece) {
        this.rel = rel;
        this.piece = piece;
    }

    public boolean outsideBoard(int boardRows) {
        for (Point loc : Grids.allPointsOf(this)) {
            if (piece.cellAt(loc) != EMPTY) {
                if (asAbs(loc).row >= boardRows) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isAt(Point abs) {
        Point loc = asLoc(abs);
        return loc.row >= 0 && loc.row < piece.rows()
                && loc.col >= 0 && loc.col < piece.columns()
                && piece.cellAt(loc) != EMPTY;
    }

    public MovablePiece moveTo(Point rel) {
        return new MovablePiece(rel, piece);
    }

    public MovablePiece moveDown() {
        return new MovablePiece(new Point(rel.row + 1, rel.col), piece);
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
