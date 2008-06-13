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
public class Board implements Grid {

    private Block fallingBlock;
    private char[][] blocks;

    public Board(int rows, int columns) {
        blocks = new char[rows][columns];
        for (char[] tmp : blocks) {
            Arrays.fill(tmp, EMPTY);
        }
    }

    public void tick() {
        Block test = fallingBlock.moveDown();
        if (conflictsWithBoard(test)) {
            stopFallingBlock();
        } else {
            fallingBlock = test;
        }
    }

    private boolean conflictsWithBoard(Block block) {
        return outsideBoard(block) || hitsAnotherBlock(block);
    }

    private boolean outsideBoard(Block block) {
        return block.row() >= rows();
    }

    private boolean hitsAnotherBlock(Block block) {
        return blocks[block.row()][block.col()] != EMPTY;
    }


    public void drop(Rotatable piece) {
    }

    public void drop(Block block) {
        if (hasFallingBlock()) {
            throw new IllegalStateException("Another block may not be dropped when one is already falling");
        }
        fallingBlock = block.moveTo(0, columns() / 2);
    }

    public boolean hasFallingBlock() {
        return fallingBlock != null;
    }

    private void stopFallingBlock() {
        assert hasFallingBlock();
        copyToBoard(fallingBlock);
        fallingBlock = null;
    }


    private void copyToBoard(Block block) {
        blocks[block.row()][block.col()] = block.style();
    }

    public int rows() {
        return blocks.length;
    }

    public int columns() {
        return blocks[0].length;
    }

    public char cellAt(int row, int col) {
        if (fallingBlock != null && fallingBlock.isAt(row, col)) {
            return fallingBlock.style();
        } else {
            return blocks[row][col];
        }
    }

    public String toString() {
        return new GridAsciiView(this).toString();
    }
}
