/*
 * Copyright (c) 2008, Esko Luontola. All Rights Reserved.
 *
 * This program and its source code may be freely used for personal
 * non-commercial educational purposes. Usage as course material
 * is not allowed without prior permission.
 */

package tetris;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author Esko Luontola
 * @since 13.6.2008
 */
public class ControllingFallingPiecesTest {

    public static Test suite() {
        return new TestSuite(ControllingFallingPiecesTest.class.getDeclaredClasses());
    }

    public static class WhenAPieceIsDropped extends TestCase {

        private Board board;

        protected void setUp() throws Exception {
            board = new Board(6, 8);
            board.drop(Tetrominoe.T_SHAPE);
        }

        public void testItStartsFromTopMiddle() {
            assertEquals("" +
                    "....T...\n" +
                    "...TTT..\n" +
                    "........\n" +
                    "........\n" +
                    "........\n" +
                    "........\n", board.toString());
        }
    }
}
