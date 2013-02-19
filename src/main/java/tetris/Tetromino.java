// Copyright (c) 2008-2013  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class Tetromino {

    public static final Tetromino T_SHAPE = new Tetromino("" +
            ".T.\n" +
            "TTT\n" +
            "...\n");

    private final Piece shape;

    public Tetromino(String shape) {
        this(new Piece(shape));
    }

    private Tetromino(Piece shape) {
        this.shape = shape;
    }

    @Override
    public String toString() {
        return shape.toString();
    }

    public Tetromino rotateRight() {
        return new Tetromino(shape.rotateRight());
    }

    public void rotateLeft() {
    }
}
