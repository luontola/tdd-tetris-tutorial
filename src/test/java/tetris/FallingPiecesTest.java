/*
 * Copyright (c) 2008-2009  Esko Luontola, www.orfjackal.net
 *
 * You may use and modify this source code freely for personal non-commercial use.
 * This source code may NOT be used as course material without prior written agreement.
 */

package tetris;

import org.junit.*;
import org.junit.runner.RunWith;

/**
 * @author Esko Luontola
 */
@RunWith(NestedJUnit4.class)
public class FallingPiecesTest extends Assert {

/*
    private final Board board = new Board(6, 8);


    public class When_a_piece_is_dropped {

        @Before
        public void dropPiece() {
            board.drop(Tetrominoe.T_SHAPE);
        }

        @Test
        public void it_starts_from_top_middle() {
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
    public class When_a_piece_reaches_the_bottom {

        @Before
        public void fallToLastRow() {
            board.drop(Tetrominoe.T_SHAPE);
            board.tick();
            board.tick();
            board.tick();
            board.tick();
        }

        @Test
        public void it_is_still_falling_on_the_last_row() {
            assertTrue(board.hasFalling());
            assertEquals("" +
                    "........\n" +
                    "........\n" +
                    "........\n" +
                    "........\n" +
                    "....T...\n" +
                    "...TTT..\n", board.toString());
        }

//        @Test
//        public void it_stops_when_it_hits_the_bottom() {
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
    public class When_a_piece_lands_on_another_piece {

        @Before
        public void landOnAnother() {
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

        @Test
        public void it_is_still_falling_right_above_the_other_piece() {
            assertTrue(board.hasFalling());
            assertEquals("" +
                    "........\n" +
                    "........\n" +
                    "....T...\n" +
                    "...TTT..\n" +
                    "....T...\n" +
                    "...TTT..\n", board.toString());
        }

//        @Test
//        public void it_stops_when_it_hits_the_other_piece() {
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
