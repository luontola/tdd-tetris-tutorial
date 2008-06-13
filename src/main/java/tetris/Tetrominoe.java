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
 * @since Jun 13, 2008
 */
public class Tetrominoe implements Rotatable {

    public static final Tetrominoe I_SHAPE = new Tetrominoe(2, 1, "" +
            ".....\n" +
            ".....\n" +
            "IIII.\n" +
            ".....\n" +
            ".....\n");
    public static final Tetrominoe J_SHAPE = new Tetrominoe(4, 0, "" +
            "..J\n" +
            "JJJ\n" +
            "...\n");
    public static final Tetrominoe L_SHAPE = new Tetrominoe(4, 0, "" +
            "L..\n" +
            "LLL\n" +
            "...\n");
    public static final Tetrominoe O_SHAPE = new Tetrominoe(1, 0, "" +
            ".OO\n" +
            ".OO\n" +
            "...\n");
    public static final Tetrominoe S_SHAPE = new Tetrominoe(2, 0, "" +
            ".SS\n" +
            "SS.\n" +
            "...\n");
    public static final Tetrominoe T_SHAPE = new Tetrominoe(4, 0, "" +
            ".T.\n" +
            "TTT\n" +
            "...\n");
    public static final Tetrominoe Z_SHAPE = new Tetrominoe(2, 1, "" +
            "ZZ.\n" +
            ".ZZ\n" +
            "...\n");

    private final Rotatable[] rotations;
    private final int currentRotation;

    public Tetrominoe(int maxRotations, int currentRotation, String blocks) {
        Piece firstRotation = firstRotation(new Piece(blocks), currentRotation);
        this.rotations = allRotations(firstRotation, maxRotations);
        this.currentRotation = currentRotation;
    }

    private Tetrominoe(Rotatable[] rotations, int currentRotation) {
        while (currentRotation < 0) {
            currentRotation += rotations.length;
        }
        this.rotations = rotations;
        this.currentRotation = currentRotation % rotations.length;
    }

    private static Piece firstRotation(Piece piece, int currentRotation) {
        for (int i = 0; i < currentRotation; i++) {
            piece = piece.rotateLeft();
        }
        return piece;
    }

    private static Rotatable[] allRotations(Piece firstRotation, int maxRotations) {
        Rotatable[] x = new Rotatable[maxRotations];
        x[0] = firstRotation;
        for (int i = 1; i < x.length; i++) {
            x[i] = x[i - 1].rotateRight();
        }
        return x;
    }

    public Tetrominoe rotateRight() {
        return new Tetrominoe(rotations, currentRotation + 1);
    }

    public Tetrominoe rotateLeft() {
        return new Tetrominoe(rotations, currentRotation - 1);
    }

    public String toString() {
        return rotations[currentRotation].toString();
    }
}
