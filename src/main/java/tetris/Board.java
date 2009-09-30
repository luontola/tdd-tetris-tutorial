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

    private boolean conflictsWithBoard(MovablePiece p) {
        return p.outsideBoard(this) || hitsStationaryBlock(p);
    }

    private boolean hitsStationaryBlock(MovablePiece piece) {
        for (Point point : Grids.allPointsOf(this)) {
            if (piece.isAt(point) && piece.cellAtOuter(point) != EMPTY
                    && blocks[point.row][point.col] != EMPTY) {
                return true;
            }
        }
        return false;
    }

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

    private boolean hasRoomOnRight(MovablePiece test) {
//        System.out.println("Board.hasRoomOnRight");
//        System.out.println(Grids.toString(test));
//        System.out.println(test.blocksOnBoard());
        for (Point p : test.blocksOnBoard()) {
            Point oneStepRight = p.moveRight();
            if (oneStepRight.col >= columns()) {
                return false;
            }
            if (stationaryBlockExistsAt(oneStepRight)
                    /* && !test.isAt(oneStepRight)*/
                    && cellAt(oneStepRight) != EMPTY) {
                return false;
            }
        }
        return true;
    }

    private boolean stationaryBlockExistsAt(Point p) {
        return blocks[p.row][p.col] != EMPTY;
    }

    private boolean hasRoomOnLeft(MovablePiece test) {
//        System.out.println("Board.hasRoomOnLeft");
//        System.out.println(Grids.toString(test));
//        System.out.println(test.blocksOnBoard());
        for (Point p : test.blocksOnBoard()) {
            Point oneStepLeft = p.moveLeft();
            if (oneStepLeft.col < 0) {
                return false;
            }
            if (stationaryBlockExistsAt(oneStepLeft)
                    /* && !test.isAt(oneStepRight)*/
                    && cellAt(oneStepLeft) != EMPTY) {
                return false;
            }
        }
        return true;
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
        for (Point point : Grids.allPointsOf(this)) {
            if (piece.isAt(point) && piece.cellAtOuter(point) != EMPTY) {
                blocks[point.row][point.col] = piece.cellAtOuter(point);
            }
        }
    }

    public int rows() {
        return blocks.length;
    }

    public int columns() {
        return blocks[0].length;
    }

    public char cellAt(Point point) {
        if (falling != null && falling.isAt(point)) {
            return falling.cellAtOuter(point);
        } else {
            return blocks[point.row][point.col];
        }
    }

    public String toString() {
        return Grids.toString(this);
    }
}
