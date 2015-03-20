// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class MovablePiece implements Grid {

    private final RotatableGrid piece;
    public final int rowOffset;
    public final int colOffset;

    public MovablePiece(RotatableGrid piece, int rowOffset, int colOffset) {
        this.piece = piece;
        this.rowOffset = rowOffset;
        this.colOffset = colOffset;
    }

    public boolean isOutside(Board board) {
        for (int myRow = 0; myRow < rows(); myRow++) {
            for (int myCol = 0; myCol < columns(); myCol++) {
                if (hasCellAt(myRow, myCol)) {
                    int boardRow = rowOffset + myRow;
                    int boardCol = colOffset + myCol;
                    if (boardCol < 0
                            || boardCol >= board.columns()
                            || boardRow >= board.rows()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean collidesWith(char[][] board) {
        for (int myRow = 0; myRow < rows(); myRow++) {
            for (int myCol = 0; myCol < columns(); myCol++) {
                if (hasCellAt(myRow, myCol)) {
                    int boardRow = rowOffset + myRow;
                    int boardCol = colOffset + myCol;
                    if (board[boardRow][boardCol] != EMPTY) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public char boardCellAt(int boardRow, int boardCol) {
        int myRow = boardRow - rowOffset;
        int myCol = boardCol - colOffset;
        if (myRow >= 0
                && myRow < rows()
                && myCol >= 0
                && myCol < columns()) {
            return cellAt(myRow, myCol);
        }
        return EMPTY;
    }

    @Override
    public char cellAt(int row, int col) {
        return piece.cellAt(row, col);
    }

    @Override
    public int rows() {
        return piece.rows();
    }

    @Override
    public int columns() {
        return piece.columns();
    }

    public MovablePiece rotateCW() {
        return new MovablePiece(piece.rotateCW(), rowOffset, colOffset);
    }

    public MovablePiece rotateCCW() {
        return new MovablePiece(piece.rotateCCW(), rowOffset, colOffset);
    }

    public MovablePiece moveDown() {
        return new MovablePiece(piece, rowOffset + 1, colOffset);
    }

    public MovablePiece moveLeft() {
        return new MovablePiece(piece, rowOffset, colOffset - 1);
    }

    public MovablePiece moveRight() {
        return new MovablePiece(piece, rowOffset, colOffset + 1);
    }
}
