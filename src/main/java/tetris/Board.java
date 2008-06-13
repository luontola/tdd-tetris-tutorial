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
public class Board implements Table {

    private static final char EMPTY = '.';

    private Block fallingBlock;
    private char[][] board;

    public Board(int rows, int columns) {
        board = new char[rows][columns];
        for (char[] tmp : board) {
            Arrays.fill(tmp, EMPTY);
        }
    }

    public void drop(Block block) {
        if (isFallingBlock()) {
            throw new IllegalStateException("Another block may not be dropped when one is already falling");
        }
        fallingBlock = block.moveTo(0, columns() / 2);
    }

    public void tick() {
        Block test = fallingBlock.moveDown();
        if (conflictsWithBoard(test)) {
            stopFallingBlock();
        } else {
            fallingBlock = test;
        }
    }

    public boolean isFallingBlock() {
        return fallingBlock != null;
    }

    private void stopFallingBlock() {
        assert isFallingBlock();
        copyToBoard(fallingBlock);
        fallingBlock = null;
    }

    private void copyToBoard(Block block) {
        board[block.row()][block.col()] = block.style();
    }

    private boolean conflictsWithBoard(Block block) {
        return outsideBoard(block) || hitsAnotherBlock(block);
    }

    private boolean outsideBoard(Block block) {
        return block.row() >= rows();
    }

    private boolean hitsAnotherBlock(Block block) {
        return board[block.row()][block.col()] != EMPTY;
    }

    public String toString() {
        return TableAsciiView.visualize(this);
    }

    public char cellAt(int row, int col) {
        if (fallingBlock != null && fallingBlock.isAt(row, col)) {
            return fallingBlock.style();
        } else {
            return board[row][col];
        }
    }

    public int rows() {
        return board.length;
    }

    public int columns() {
        return board[0].length;
    }
}
