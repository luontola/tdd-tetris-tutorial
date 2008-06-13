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
public class Piece {

    private final char[][] blocks;

    public Piece(String blocks) {
        String[] lines = blocks.split("\n");
        this.blocks = new char[lines.length][lines.length];
        for (int i = 0; i < this.blocks.length; i++) {
            for (int j = 0; j < this.blocks[i].length; j++) {
                this.blocks[i][j] = lines[i].charAt(j);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                sb.append(blocks[i][j]);
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public void rotateRight() {

    }
}
