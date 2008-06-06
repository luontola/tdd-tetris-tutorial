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
 * @since Jun 6, 2008
 */
public class Board {

    private int width;
    private int height;
    private Block fallingBlock;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                sb.append('.');
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public void drop(Block block) {
        fallingBlock = block;
    }
}
