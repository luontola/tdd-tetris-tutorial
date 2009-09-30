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
public class MovablePiece implements Grid {

    // Coordinates in use:
    // 'outer'  = coordinate in the parent grid (game board)
    // 'inner'  = coordinate in the contained piece
    // 'offset' = the inner coordinate [0,0] in outer coordinates

    private final Point offset;
    private final RotatableGrid innerPiece;

    public MovablePiece(RotatableGrid innerPiece) {
        this(new Point(0, 0), innerPiece);
    }

    private MovablePiece(Point offset, RotatableGrid innerPiece) {
        this.offset = offset;
        this.innerPiece = innerPiece;
    }

    public boolean outsideBoard(Grid board) {
        for (Point inner : Grids.allPointsOf(this)) {
            if (innerPiece.cellAt(inner) != EMPTY
                    && outsideBoard(inner, board)) {
                return true;
            }
        }
        return false;
    }

    private boolean outsideBoard(Point inner, Grid board) {
        Point outer = asOuter(inner);
        return outer.row >= board.rows()
                || outer.col < 0
                || outer.col >= board.columns();
    }

    public boolean isAt(Point outer) {
        Point inner = asInner(outer);
        return inner.row >= 0 && inner.row < innerPiece.rows()
                && inner.col >= 0 && inner.col < innerPiece.columns()
                && innerPiece.cellAt(inner) != EMPTY;
    }

    public MovablePiece moveTo(Point offset) {
        return new MovablePiece(offset, innerPiece);
    }

    public MovablePiece moveDown() {
        return new MovablePiece(new Point(offset.row + 1, offset.col), innerPiece);
    }

    public MovablePiece moveLeft() {
        return new MovablePiece(new Point(offset.row, offset.col - 1), innerPiece);
    }

    public MovablePiece moveRight() {
        return new MovablePiece(new Point(offset.row, offset.col + 1), innerPiece);
    }

    public int rows() {
        return innerPiece.rows();
    }

    public int columns() {
        return innerPiece.columns();
    }

    public char cellAt(Point outer) {
        return innerPiece.cellAt(asInner(outer));
    }

    private Point asInner(Point outer) {
        return new Point(outer.row - offset.row, outer.col - offset.col);
    }

    private Point asOuter(Point inner) {
        return new Point(inner.row + offset.row, inner.col + offset.col);
    }
}
