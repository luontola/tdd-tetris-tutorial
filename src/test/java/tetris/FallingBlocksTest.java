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
public class FallingBlocksTest {

    public static Test suite() {
        return new TestSuite(FallingBlocksTest.class.getDeclaredClasses());
    }

    public static class A_new_board extends TestCase {

        private Board board;

        protected void setUp() throws Exception {
            board = new Board(3, 3);
        }

        public void test_Is_empty() {
            assertEquals("" +
                    "...\n" +
                    "...\n" +
                    "...\n", board.toString());
        }

        public void test_Has_no_falling_blocks() {
            assertFalse(board.hasFalling());
        }
    }

    public static class When_a_block_is_dropped extends TestCase {

        private Board board;

        protected void setUp() throws Exception {
            board = new Board(3, 3);
            board.drop(new Block('X'));
        }

        public void test_The_block_is_falling() {
            assertTrue(board.hasFalling());
        }

        public void test_It_starts_from_the_top_middle() {
            assertEquals("" +
                    ".X.\n" +
                    "...\n" +
                    "...\n", board.toString());
        }

        public void test_It_moves_down_one_row_per_tick() {
            board.tick();
            assertEquals("" +
                    "...\n" +
                    ".X.\n" +
                    "...\n", board.toString());
        }

        public void test_At_most_one_block_may_be_falling_at_a_time() {
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

    public static class When_a_block_reaches_the_bottom extends TestCase {

        private Board board;

        protected void setUp() throws Exception {
            board = new Board(3, 3);
            board.drop(new Block('X'));
            board.tick();
            board.tick();
        }

        public void test_It_is_still_falling_on_the_last_row() {
            assertTrue(board.hasFalling());
            assertEquals("" +
                    "...\n" +
                    "...\n" +
                    ".X.\n", board.toString());
        }

        public void test_It_stops_when_it_hits_the_bottom() {
            board.tick();
            assertFalse(board.hasFalling());
            assertEquals("" +
                    "...\n" +
                    "...\n" +
                    ".X.\n", board.toString());
        }
    }

    public static class When_a_block_lands_on_another_block extends TestCase {

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

        public void test_It_is_still_falling_right_above_the_other_block() {
            assertTrue(board.hasFalling());
            assertEquals("" +
                    "...\n" +
                    ".Y.\n" +
                    ".X.\n", board.toString());
        }

        public void test_It_stops_when_it_hits_the_other_block() {
            board.tick();
            assertFalse(board.hasFalling());
            assertEquals("" +
                    "...\n" +
                    ".Y.\n" +
                    ".X.\n", board.toString());
        }
    }
}
