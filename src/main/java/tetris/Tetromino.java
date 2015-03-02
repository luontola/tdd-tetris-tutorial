// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class Tetromino {

    public static final Tetromino T_SHAPE = new Tetromino("" +
            ".T.\n" +
            "TTT\n" +
            "...\n");

    private final String shape;

    public Tetromino(String shape) {
        this.shape = shape;
    }

    public Tetromino rotateRight() {
        return null;
    }

    public Tetromino rotateLeft() {
        return null;
    }

    @Override
    public String toString() {
        return shape;
    }
}
