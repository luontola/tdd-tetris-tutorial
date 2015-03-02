// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class Tetromino {

    public static final Tetromino T_SHAPE = new Tetromino(4, "" +
            ".T.\n" +
            "TTT\n" +
            "...\n");
    public static final Tetromino I_SHAPE = new Tetromino(2, "" +
            ".....\n" +
            ".....\n" +
            "IIII.\n" +
            ".....\n" +
            ".....\n");

    private final int currentOrientation;
    private final Piece[] orientations;

    public Tetromino(int orientationCount, String shape) {
        this.currentOrientation = 0;
        this.orientations = new Piece[orientationCount];
        Piece orientation = new Piece(shape);
        for (int i = 0; i < this.orientations.length; i++) {
            this.orientations[i] = orientation;
            orientation = orientation.rotateRight();
        }
    }

    private Tetromino(int currentOrientation, Piece[] orientations) {
        this.currentOrientation = (currentOrientation + orientations.length) % orientations.length;
        this.orientations = orientations;
    }

    public Tetromino rotateRight() {
        return new Tetromino(currentOrientation + 1, orientations);
    }

    public Tetromino rotateLeft() {
        return new Tetromino(currentOrientation - 1, orientations);
    }

    @Override
    public String toString() {
        return orientations[currentOrientation].toString();
    }
}
