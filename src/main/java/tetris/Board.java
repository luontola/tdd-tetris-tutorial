/*
 * Copyright (c) 2008-2009  Esko Luontola, www.orfjackal.net
 *
 * You may use and modify this source code freely for personal non-commercial use.
 * This source code may NOT be used as course material without prior written agreement.
 */

package tetris;

import java.util.Arrays;

/**
 * @author Esko Luontola
 */
public class Board implements Grid {

    private MovablePiece falling;
    private char[][] blocks;

    public Board(int rows, int columns) {
        blocks = new char[rows][columns];
        for (char[] tmp : blocks) {
            Arrays.fill(tmp, EMPTY);
        }
    }

    public Board(String initialState) {
        blocks = Grids.fromString(initialState);
    }

    // Falling

    public void drop(RotatableGrid piece) {
        if (hasFalling()) {
            throw new IllegalStateException("Another piece may not be dropped when one is already falling");
        }
        Point topCenter = new Point(0, columns() / 2 - piece.columns() / 2);
        falling = new MovablePiece(piece).moveTo(topCenter);
    }

    public void tick() {
        MovablePiece test = falling.moveDown();
        if (conflictsWithBoard(test)) {
            stopFalling();
        } else {
            falling = test;
        }
    }

    public boolean hasFalling() {
        return falling != null;
    }

    private void stopFalling() {
        assert hasFalling();
        copyToBoard(falling);
        falling = null;
    }

    private void copyToBoard(MovablePiece piece) {
        for (Point p : Grids.allPointsOf(this)) {
            if (piece.hasBlockAtBoard(p)) {
                blocks[p.row][p.col] = piece.cellAtBoard(p);
            }
        }
    }

    // Moving

    public void moveLeft() {
        moveIfNoConflict(falling.moveLeft());
    }

    public void moveRight() {
        moveIfNoConflict(falling.moveRight());
    }

    public void moveDown() {
        moveIfNoConflict(falling.moveDown());
    }

    private void moveIfNoConflict(MovablePiece test) {
        if (!conflictsWithBoard(test)) {
            falling = test;
        }
    }

    // Rotating

    public void rotateClockwise() {
        rotateIfNoConflict(falling.rotateClockwise());
    }

    public void rotateCounterClockwise() {
        rotateIfNoConflict(falling.rotateCounterClockwise());
    }

    private void rotateIfNoConflict(MovablePiece test) {
        if (!conflictsWithBoard(test)) {
            falling = test;
        } else if (hasRoomOnRight(test)) {
            rotateIfNoConflict(test.moveRight());
        } else if (hasRoomOnLeft(test)) {
            rotateIfNoConflict(test.moveLeft());
        }
    }

    private boolean hasRoomOnLeft(MovablePiece test) {
        for (Point p : test.allBlocksOnBoard()) {
            if (conflictsWithBoard(p.moveLeft())) {
                return false;
            }
        }
        return true;
    }

    private boolean hasRoomOnRight(MovablePiece test) {
        for (Point p : test.allBlocksOnBoard()) {
            if (conflictsWithBoard(p.moveRight())) {
                return false;
            }
        }
        return true;
    }

    // Conflict Checks

    private boolean conflictsWithBoard(MovablePiece test) {
        return outsideBoard(test) || hitsStationaryBlock(test);
    }

    private boolean conflictsWithBoard(Point p) {
        return outsideBoard(p) || hitsStationaryBlock(p);
    }

    private boolean outsideBoard(MovablePiece test) {
        for (Point p : test.allBlocksOnBoard()) {
            if (outsideBoard(p)) {
                return true;
            }
        }
        return false;
    }

    private boolean outsideBoard(Point p) {
        return p.row >= rows()
                || p.col < 0
                || p.col >= columns();
    }

    private boolean hitsStationaryBlock(MovablePiece test) {
        for (Point p : test.allBlocksOnBoard()) {
            if (hitsStationaryBlock(p)) {
                return true;
            }
        }
        return false;
    }

    private boolean hitsStationaryBlock(Point p) {
        return blocks[p.row][p.col] != EMPTY;
    }

    // Grid

    public int rows() {
        return blocks.length;
    }

    public int columns() {
        return blocks[0].length;
    }

    public char cellAt(Point point) {
        if (falling != null && falling.hasBlockAtBoard(point)) {
            return falling.cellAtBoard(point);
        } else {
            return blocks[point.row][point.col];
        }
    }

    public String toString() {
        return Grids.toString(this);
    }
}
