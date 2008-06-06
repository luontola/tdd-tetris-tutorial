/*
 * Copyright (c) 2008, Esko Luontola. All Rights Reserved.
 *
 * This program and its source code may be freely used for personal
 * non-commercial educational purposes. Usage as course material
 * is not allowed without prior permission.
 */

package tetris;

import java.util.Arrays;

/**
 * @author orfjackal
 * @since Jun 6, 2008
 */
public class Board {

    private static final char EMPTY = '.';

    private Block fallingBlock;
    private char[][] board;

    public Board(int rows, int columns) {
        board = new char[rows][columns];
        for (char[] tmp : board) {
            Arrays.fill(tmp, EMPTY);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                sb.append(cellAt(row, col));
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    private char cellAt(int row, int col) {
        if (fallingBlock != null && fallingBlock.isAt(row, col)) {
            return fallingBlock.style();
        } else {
            return board[row][col];
        }
    }

    public void drop(Block block) {
        fallingBlock = block.moveTo(0, columns() / 2);
    }

    private int columns() {
        return board[0].length;
    }

    public void tick() {
        
    }
}
