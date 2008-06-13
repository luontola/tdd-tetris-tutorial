/*
 * Copyright (c) 2008, Esko Luontola. All Rights Reserved.
 *
 * This program and its source code may be freely used for personal
 * non-commercial educational purposes. Usage as course material
 * is not allowed without prior permission.
 */

package tetris;

/**
 * @author orfjackal
 * @since Jun 6, 2008
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

    public boolean isAt(int absRow, int absCol) {
        return absRow == relRow && absCol == relCol;
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
        return piece.cellAt(absRow - relRow, absCol - relCol);
    }
}