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

    private final int currentRotation;
    private final Rotatable[] rotations;

    public Tetrominoe(int maxRotations, int currentRotation, String blocks) {
        this.currentRotation = currentRotation;
        this.rotations = new Rotatable[maxRotations];

        // rewind
        Piece piece = new Piece(blocks);
        for (int i = 0; i < currentRotation; i++) {
            piece = piece.rotateLeft();
        }

        // precalculate rotations
        rotations[0] = piece;
        for (int i = 1; i < rotations.length; i++) {
            piece = piece.rotateRight();
            rotations[i] = piece;
        }
    }

    private Tetrominoe(int currentRotation, Rotatable[] rotations) {
        this.currentRotation = currentRotation % rotations.length;
        this.rotations = rotations;
    }

    public String toString() {
        return rotations[currentRotation].toString();
    }

    public Tetrominoe rotateRight() {
        return new Tetrominoe(currentRotation + 1, rotations);
    }

    public Tetrominoe rotateLeft() {
        return new Tetrominoe(currentRotation - 1, rotations);
    }
}
