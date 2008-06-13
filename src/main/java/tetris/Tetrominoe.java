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

    private static Rotatable[] allRotations(Piece piece, int maxRotations) {
        Rotatable[] x = new Rotatable[maxRotations];
        x[0] = piece;
        for (int i = 1; i < x.length; i++) {
            piece = piece.rotateRight();
            x[i] = piece;
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
