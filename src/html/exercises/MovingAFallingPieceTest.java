/*
 * Copyright (c) 2008, Esko Luontola. All Rights Reserved.
 *
 * This program and its source code may be freely used for personal
 * non-commercial educational purposes. Usage as course material
 * is not allowed without prior permission.
 */

package tetris;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Esko Luontola
 * @since 27.8.2008
 */
public class MovingAFallingPieceTest {

    public static Test suite() {
        return new TestSuite(MovingAFallingPieceTest.class.getDeclaredClasses());
    }

    // TODO: a falling piece can be moved left
    // TODO: a falling piece can be moved right
    // TODO: a falling piece can be moved down
    // TODO: it will not move left over over the board
    // TODO: it will not move right over over the board
    // TODO: it will not move down over over the board (will stop falling)
    // TODO: it can not be moved left if another piece is in the way
    // TODO: it can not be moved right if another piece is in the way
    // TODO: it can not be moved down if another piece is in the way (will stop falling)

    // P.S. Take into consideration, that part of the piece's area may be empty cells.
    // Only non-empty cells should take part in the collision checks.
}
