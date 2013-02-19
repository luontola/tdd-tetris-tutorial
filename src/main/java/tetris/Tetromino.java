// Copyright (c) 2008-2013  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class Tetromino implements Grid {

    public static final Tetromino T_SHAPE = new Tetromino("" +
            ".T.\n" +
            "TTT\n" +
            "...\n", 4, 0);
    public static final Tetromino I_SHAPE = new Tetromino("" +
            ".....\n" +
            "..I..\n" +
            "..I..\n" +
            "..I..\n" +
            "..I..\n", 2, 1);
    public static final Tetromino O_SHAPE = new Tetromino("" +
            ".OO\n" +
            ".OO\n" +
            "...\n", 1, 0);

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
    public int rows() {
        return current().rows();
    }

    @Override
    public int columns() {
        return current().columns();
    }

    @Override
    public char colorAt(int row, int col) {
        return current().colorAt(row, col);
    }

    @Override
    public String toString() {
        return current().toString();
    }

    private Piece current() {
        return rotations[currentRotation];
    }

    public Tetromino rotateRight() {
        return new Tetromino(rotations, currentRotation + 1);
    }

    public Tetromino rotateLeft() {
        return new Tetromino(rotations, currentRotation - 1);
    }
}
