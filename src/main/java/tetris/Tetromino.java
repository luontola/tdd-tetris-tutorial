// Copyright (c) 2008-2013  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class Tetromino {

    public static final Tetromino T_SHAPE = new Tetromino("" +
            ".T.\n" +
            "TTT\n" +
            "...\n", 4, 0);
    public static final Tetromino I_SHAPE = new Tetromino("" +
            ".....\n" +
            ".....\n" +
            "IIII.\n" +
            ".....\n" +
            ".....\n", 4, 0);

    private final Piece[] rotations;
    private final int currentRotation;

    public Tetromino(String shape, int rotations, int currentRotation) {
        this(generateRotations(new Piece(shape), rotations), currentRotation);
    }

    private static Piece[] generateRotations(Piece shape, int count) {
        Piece[] rotations = new Piece[count];
        for (int i = 0; i < count; i++) {
            rotations[i] = shape;
            shape = shape.rotateRight();
        }
        return rotations;
    }

    private Tetromino(Piece[] rotations, int currentRotation) {
        this.rotations = rotations;
        this.currentRotation = (currentRotation + rotations.length) % rotations.length;
    }

    @Override
    public String toString() {
        return rotations[currentRotation].toString();
    }

    public Tetromino rotateRight() {
        return new Tetromino(rotations, currentRotation + 1);
    }

    public Tetromino rotateLeft() {
        return new Tetromino(rotations, currentRotation - 1);
    }
}
