// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class Piece {

    private final String shape;

    public Piece(String shape) {
        this.shape = shape;
    }

    @Override
    public String toString() {
        return shape;
    }

    public Piece rotateRight() {
        return this;
    }
}
