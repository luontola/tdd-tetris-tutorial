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

    private MovablePiece fallingBlock;
    private char[][] blocks;

    public Board(int rows, int columns) {
        blocks = new char[rows][columns];
        for (char[] tmp : blocks) {
            Arrays.fill(tmp, EMPTY);
        }
    }

    public void tick() {
        MovablePiece test = fallingBlock.moveDown();
        if (conflictsWithBoard(test)) {
            stopFallingBlock();
        } else {
            fallingBlock = test;
        }
    }

    private boolean conflictsWithBoard(MovablePiece block) {
        return outsideBoard(block) || hitsAnotherBlock(block);
    }

    private boolean outsideBoard(MovablePiece block) {
        return block.row() >= rows();
    }

    private boolean hitsAnotherBlock(MovablePiece block) {
        return blocks[block.row()][block.col()] != EMPTY;
    }


    public void drop(RotatableGrid piece) {
        if (hasFallingBlock()) {
            throw new IllegalStateException("Another block may not be dropped when one is already falling");
        }
        fallingBlock = new MovablePiece(piece).moveTo(0, columns() / 2);
    }

    public boolean hasFallingBlock() {
        return fallingBlock != null;
    }

    private void stopFallingBlock() {
        assert hasFallingBlock();
        copyToBoard(fallingBlock);
        fallingBlock = null;
    }


    private void copyToBoard(MovablePiece block) {
        blocks[block.row()][block.col()] = block.cellAt(block.row(), block.col());
    }

    public int rows() {
        return blocks.length;
    }

    public int columns() {
        return blocks[0].length;
    }

    public char cellAt(int row, int col) {
        if (fallingBlock != null && fallingBlock.isAt(row, col)) {
            return fallingBlock.cellAt(row, col);
        } else {
            return blocks[row][col];
        }
    }

    public String toString() {
        return new GridAsciiView(this).toString();
    }
}
