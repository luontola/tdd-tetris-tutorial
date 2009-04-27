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
 */
public class FallingPiecesTest {

    public static Test suite() {
        return new TestSuite(FallingPiecesTest.class.getDeclaredClasses());
    }

/*
    public static class When_a_piece_is_dropped extends TestCase {

        private Board board;

        protected void setUp() throws Exception {
            board = new Board(6, 8);
            board.drop(Tetrominoe.T_SHAPE);
        }

        public void test_It_starts_from_top_middle() {
            assertEquals("" +
                    "....T...\n" +
                    "...TTT..\n" +
                    "........\n" +
                    "........\n" +
                    "........\n" +
                    "........\n", board.toString());
        }
    }
*/

/*
    public static class When_a_piece_reaches_the_bottom extends TestCase {

        private Board board;

        protected void setUp() throws Exception {
            board = new Board(6, 8);
            board.drop(Tetrominoe.T_SHAPE);
            board.tick();
            board.tick();
            board.tick();
            board.tick();
        }

        public void test_It_is_still_falling_on_the_last_row() {
            assertTrue(board.hasFalling());
            assertEquals("" +
                    "........\n" +
                    "........\n" +
                    "........\n" +
                    "........\n" +
                    "....T...\n" +
                    "...TTT..\n", board.toString());
        }

//        public void test_It_stops_when_it_hits_the_bottom() {
//            board.tick();
//            assertFalse(board.hasFalling());
//            assertEquals("" +
//                    "........\n" +
//                    "........\n" +
//                    "........\n" +
//                    "........\n" +
//                    "....T...\n" +
//                    "...TTT..\n", board.toString());
//        }
    }
*/

/*
    public static class When_a_piece_lands_on_another_piece extends TestCase {

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

        public void test_It_is_still_falling_right_above_the_other_piece() {
            assertTrue(board.hasFalling());
            assertEquals("" +
                    "........\n" +
                    "........\n" +
                    "....T...\n" +
                    "...TTT..\n" +
                    "....T...\n" +
                    "...TTT..\n", board.toString());
        }

//        public void test_It_stops_when_it_hits_the_other_piece() {
//            board.tick();
//            assertFalse(board.hasFalling());
//            assertEquals("" +
//                    "........\n" +
//                    "........\n" +
//                    "....T...\n" +
//                    "...TTT..\n" +
//                    "....T...\n" +
//                    "...TTT..\n", board.toString());
//        }
    }
*/
}
