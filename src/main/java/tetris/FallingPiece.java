/*
 * Copyright (c) 2008-2009  Esko Luontola, www.orfjackal.net
 *
 * You may use and modify this source code freely for personal non-commercial use.
 * This source code may NOT be used as course material without prior written agreement.
 */

package tetris;

import java.util.*;

/**
 * @author Esko Luontola
 */
public class FallingPiece {

    // Coordinates in use:
    // 'outer'  = coordinate in the parent grid (game board)
    // 'inner'  = coordinate in the contained piece
    // 'offset' = the inner coordinate [0,0] in outer coordinates

    private final Point offset;
    private final RotatableGrid innerPiece;

    public FallingPiece(RotatableGrid innerPiece) {
        this(new Point(0, 0), innerPiece);
    }

    private FallingPiece(Point offset, RotatableGrid innerPiece) {
        this.offset = offset;
        this.innerPiece = innerPiece;
    }

    public FallingPiece moveTo(Point offset) {
        return new FallingPiece(offset, innerPiece);
    }

    public FallingPiece moveDown() {
        return new FallingPiece(offset.moveDown(), innerPiece);
    }

    public FallingPiece moveLeft() {
        return new FallingPiece(offset.moveLeft(), innerPiece);
    }

    public FallingPiece moveRight() {
        return new FallingPiece(offset.moveRight(), innerPiece);
    }

    public FallingPiece rotateClockwise() {
        return new FallingPiece(offset, innerPiece.rotateClockwise());
    }

    public FallingPiece rotateCounterClockwise() {
        return new FallingPiece(offset, innerPiece.rotateCounterClockwise());
    }

    // Board Coordinates

    public char blockAtBoard(Point outer) {
        return innerPiece.cellAt(asInner(outer));
    }

    public boolean hasBlockAtBoard(Point outer) {
        return allBlocksOnBoard().contains(outer);
    }

    public List<Point> allBlocksOnBoard() {
        List<Point> innerPoints = Grids.allNonEmptyPointsOf(innerPiece);
        List<Point> outerPoints = new ArrayList<Point>();
        for (Point inner : innerPoints) {
            outerPoints.add(asOuter(inner));
        }
        return outerPoints;
    }

    private Point asInner(Point outer) {
        return new Point(outer.row - offset.row, outer.col - offset.col);
    }

    private Point asOuter(Point inner) {
        return new Point(inner.row + offset.row, inner.col + offset.col);
    }
}
