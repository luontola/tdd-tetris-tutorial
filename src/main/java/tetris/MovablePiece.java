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

    private final int row;
    private final int col;
    private final RotatableGrid piece;

    public MovablePiece(char style) {
        this(new Piece(style + "\n"));
    }

    public MovablePiece(RotatableGrid piece) {
        this(0, 0, piece);
    }

    public MovablePiece(int row, int col, RotatableGrid piece) {
        this.row = row;
        this.col = col;
        this.piece = piece;
    }

    public int row() {
        return row;
    }

    public int col() {
        return col;
    }

    public boolean isAt(int row, int col) {
        return row == this.row && col == this.col;
    }

    public Block moveTo(int row, int col) {
        return new Block(row, col, piece);
    }

    public Block moveDown() {
        return new Block(row + 1, col, piece);
    }

    public int rows() {
        return piece.rows();
    }

    public int columns() {
        return piece.columns();
    }

    public char cellAt(int row, int col) {
        return piece.cellAt(row - this.row, col - this.col);
    }
}