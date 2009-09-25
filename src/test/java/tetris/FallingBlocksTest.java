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
public class FallingBlocksTest extends Assert {

    private final Board board = new Board(3, 3);


    public class A_new_board {

        @Test
        public void is_empty() {
            assertEquals("" +
                    "...\n" +
                    "...\n" +
                    "...\n", board.toString());
        }

        @Test
        public void has_no_falling_blocks() {
            assertFalse(board.hasFalling());
        }
    }

    public class When_a_block_is_dropped {

        @Before
        public void dropBlock() {
            board.drop(new Block('X'));
        }

        @Test
        public void the_block_is_falling() {
            assertTrue(board.hasFalling());
        }

        @Test
        public void it_starts_from_the_top_middle() {
            assertEquals("" +
                    ".X.\n" +
                    "...\n" +
                    "...\n", board.toString());
        }

        @Test
        public void it_moves_down_one_row_per_tick() {
            board.tick();
            assertEquals("" +
                    "...\n" +
                    ".X.\n" +
                    "...\n", board.toString());
        }

        @Test
        public void at_most_one_block_may_be_falling_at_a_time() {
            try {
                board.drop(new Block('Y'));
                fail();
            } catch (IllegalStateException e) {
                assertTrue(e.getMessage().contains("already falling"));
            }
            assertEquals("" +
                    ".X.\n" +
                    "...\n" +
                    "...\n", board.toString());
        }
    }

    public class When_a_block_reaches_the_bottom {

        @Before
        public void fallToLastRow() {
            board.drop(new Block('X'));
            board.tick();
            board.tick();
        }

        @Test
        public void it_is_still_falling_on_the_last_row() {
            assertTrue(board.hasFalling());
            assertEquals("" +
                    "...\n" +
                    "...\n" +
                    ".X.\n", board.toString());
        }

        @Test
        public void it_stops_when_it_hits_the_bottom() {
            board.tick();
            assertFalse(board.hasFalling());
            assertEquals("" +
                    "...\n" +
                    "...\n" +
                    ".X.\n", board.toString());
        }
    }

    public class When_a_block_lands_on_another_block {

        @Before
        public void landOnAnother() {
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

        @Test
        public void it_is_still_falling_right_above_the_other_block() {
            assertTrue(board.hasFalling());
            assertEquals("" +
                    "...\n" +
                    ".Y.\n" +
                    ".X.\n", board.toString());
        }

        @Test
        public void it_stops_when_it_hits_the_other_block() {
            board.tick();
            assertFalse(board.hasFalling());
            assertEquals("" +
                    "...\n" +
                    ".Y.\n" +
                    ".X.\n", board.toString());
        }
    }
}