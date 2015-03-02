// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class Tetromino {

    public static final Tetromino T_SHAPE = new Tetromino("" +
            ".T.\n" +
            "TTT\n" +
            "...\n");

    private final Piece piece;

    public Tetromino(String shape) {
        this.piece = new Piece(shape);
    }

    private Tetromino(Piece piece) {
        this.piece = piece;
    }

    public Tetromino rotateRight() {
        return new Tetromino(piece.rotateRight());
    }

    public Tetromino rotateLeft() {
        return new Tetromino(piece.rotateLeft());
    }

    @Override
    public String toString() {
        return piece.toString();
    }
}
