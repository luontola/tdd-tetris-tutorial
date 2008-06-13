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
        this.blocks = linesToArrays(blocks);
    }

    public Piece(char[][] blocks) {
        this.blocks = blocks;
    }


    /**
     * Coordinates when rotating a 3x3 grid right:
     * <pre>
     * before   after
     * 0-0      0-2
     * 0-1      1-2
     * 0-2      2-2
     * 1-0      0-1
     * 1-1      1-1
     * 1-2      2-1
     * 2-0      0-0
     * 2-1      1-0
     * 2-2      2-0
     * </pre>
     */
    public Piece rotateRight() {
        char[][] rotated = new char[blocks.length][blocks.length];
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                rotated[j][2 - i] = blocks[i][j];
            }
        }
        return new Piece(rotated);
    }

    public String toString() {
        return arraysToLines(blocks);
    }

    private static char[][] linesToArrays(String blocks) {
        String[] lines = blocks.split("\n");
        char[][] x = new char[lines.length][lines.length];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                x[i][j] = lines[i].charAt(j);
            }
        }
        return x;
    }

    private static String arraysToLines(char[][] x) {
        StringBuilder sb = new StringBuilder();
        for (char[] line : x) {
            for (char c : line) {
                sb.append(c);
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
