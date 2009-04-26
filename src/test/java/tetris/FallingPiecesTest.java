/*
 * Copyright (c) 2008-2009  Esko Luontola, www.orfjackal.net
 *
 * You may use and modify this source code freely for personal non-commercial use.
 * This source code may NOT be used as course material without prior written agreement.
 */

package tetris;

import junit.framework.*;

/**
 * @author Esko Luontola
 * @since 13.6.2008
 */
public class FallingPiecesTest {

    public static Test suite() {
        return new TestSuite(FallingPiecesTest.class.getDeclaredClasses());
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

    public static class WhenAPieceReachesTheBottom extends TestCase {

        private Board board;

        protected void setUp() throws Exception {
            board = new Board(6, 8);
            board.drop(Tetrominoe.T_SHAPE);
            board.tick();
            board.tick();
            board.tick();
            board.tick();
        }

        public void testItIsStillFallingOnTheLastRow() {
            assertTrue(board.hasFalling());
            assertEquals("" +
                    "........\n" +
                    "........\n" +
                    "........\n" +
                    "........\n" +
                    "....T...\n" +
                    "...TTT..\n", board.toString());
        }

        public void testItStopsWhenItHitsTheBottom() {
            board.tick();
            assertFalse(board.hasFalling());
            assertEquals("" +
                    "........\n" +
                    "........\n" +
                    "........\n" +
                    "........\n" +
                    "....T...\n" +
                    "...TTT..\n", board.toString());
        }
    }

    public static class WhenAPieceLandsOnAnotherPiece extends TestCase {

        private Board board;

        protected void setUp() throws Exception {
            board = new Board(6, 8);
            board.drop(Tetrominoe.T_SHAPE);
            board.tick();
            board.tick();
            board.tick();
            board.tick();
            board.tick();
            assertFalse(board.hasFalling());
            assertEquals("" +
                    "........\n" +
                    "........\n" +
                    "........\n" +
                    "........\n" +
                    "....T...\n" +
                    "...TTT..\n", board.toString());
            board.drop(Tetrominoe.T_SHAPE);
            board.tick();
            board.tick();
        }

        public void testItIsStillFallingRightAboveTheOtherPiece() {
            assertTrue(board.hasFalling());
            assertEquals("" +
                    "........\n" +
                    "........\n" +
                    "....T...\n" +
                    "...TTT..\n" +
                    "....T...\n" +
                    "...TTT..\n", board.toString());
        }

        public void testItStopsWhenItHitsTheOtherPiece() {
            board.tick();
            assertFalse(board.hasFalling());
            assertEquals("" +
                    "........\n" +
                    "........\n" +
                    "....T...\n" +
                    "...TTT..\n" +
                    "....T...\n" +
                    "...TTT..\n", board.toString());
        }
    }
}
