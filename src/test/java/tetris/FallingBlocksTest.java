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
 * @since 6.6.2008
 */
public class FallingBlocksTest {

    public static Test suite() {
        return new TestSuite(FallingBlocksTest.class.getDeclaredClasses());
    }

    public static class ANewBoard extends TestCase {

        private Board board;

        protected void setUp() throws Exception {
            board = new Board(3, 3);
        }

        public void testIsEmpty() {
            assertEquals("" +
                    "...\n" +
                    "...\n" +
                    "...\n", board.toString());
        }

//        public void testHasNoFallingBlocks() {
//            assertFalse(board.hasFalling());
//        }
    }

/*
    public static class WhenABlockIsDropped extends TestCase {

        private Board board;

        protected void setUp() throws Exception {
            board = new Board(3, 3);
            board.drop(new Block('X'));
        }

        public void testTheBlockIsFalling() {
            assertTrue(board.hasFalling());
        }

//        public void testItStartsFromTheTopMiddle() {
//            assertEquals("" +
//                    ".X.\n" +
//                    "...\n" +
//                    "...\n", board.toString());
//        }

//        public void testItMovesDownOneRowPerTick() {
//            board.tick();
//            assertEquals("" +
//                    "...\n" +
//                    ".X.\n" +
//                    "...\n", board.toString());
//        }

//        public void testAtMostOneBlockMayBeFallingAtATime() {
//            try {
//                board.drop(new Block('Y'));
//                fail();
//            } catch (IllegalStateException e) {
//                assertTrue(e.getMessage().contains("already falling"));
//            }
//            assertEquals("" +
//                    ".X.\n" +
//                    "...\n" +
//                    "...\n", board.toString());
//        }
    }
*/

/*
    public static class WhenABlockReachesTheBottom extends TestCase {

        private Board board;

        protected void setUp() throws Exception {
            board = new Board(3, 3);
            board.drop(new Block('X'));
            board.tick();
            board.tick();
        }

        public void testItIsStillFallingOnTheLastRow() {
            assertTrue(board.hasFalling());
            assertEquals("" +
                    "...\n" +
                    "...\n" +
                    ".X.\n", board.toString());
        }

//        public void testItStopsWhenItHitsTheBottom() {
//            board.tick();
//            assertFalse(board.hasFalling());
//            assertEquals("" +
//                    "...\n" +
//                    "...\n" +
//                    ".X.\n", board.toString());
//        }
    }
*/

/*
    public static class WhenABlockLandsOnAnotherBlock extends TestCase {

        private Board board;

        protected void setUp() throws Exception {
            board = new Board(3, 3);
            board.drop(new Block('X'));
            board.tick();
            board.tick();
            board.tick();
            assertFalse(board.hasFalling());
            assertEquals("" +
                    "...\n" +
                    "...\n" +
                    ".X.\n", board.toString());
            board.drop(new Block('Y'));
            board.tick();
        }

        public void testItIsStillFallingRightAboveTheOtherBlock() {
            assertTrue(board.hasFalling());
            assertEquals("" +
                    "...\n" +
                    ".Y.\n" +
                    ".X.\n", board.toString());
        }

//        public void testItStopsWhenItHitsTheOtherBlock() {
//            board.tick();
//            assertFalse(board.hasFalling());
//            assertEquals("" +
//                    "...\n" +
//                    ".Y.\n" +
//                    ".X.\n", board.toString());
//        }
    }
*/
}
