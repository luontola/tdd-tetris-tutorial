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

    private final Rotatable piece;

    public Tetrominoe(String blocks) {
        piece = new Piece(blocks);
    }

    public String toString() {
        return piece.toString();
    }

    public Tetrominoe rotateRight() {
        return this;
    }

    public Tetrominoe rotateLeft() {
        return this;
    }
}
