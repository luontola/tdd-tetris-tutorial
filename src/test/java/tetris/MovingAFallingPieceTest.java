/*
 * Copyright (c) 2008-2009  Esko Luontola, www.orfjackal.net
 *
 * You may use and modify this source code freely for personal non-commercial use.
 * This source code may NOT be used as course material without prior written agreement.
 */

package tetris;

import net.orfjackal.nestedjunit.NestedJUnit4;
import org.junit.*;
import org.junit.runner.RunWith;

/**
 * @author Esko Luontola
 */
@RunWith(NestedJUnit4.class)
public class MovingAFallingPieceTest extends Assert {

    private static final RotatableGrid PIECE = new Piece("" +
            ".X.\n" +
            ".X.\n" +
            ".X.\n"
    );
    private static final int LOTS_OF_TIMES = 10;

    private Board board = new Board(5, 8);


    public class When_a_piece_is_falling_on_an_empty_board {

        @Before
        public void dropPiece() {
            board.drop(PIECE);
            assertEquals("" +
                    "....X...\n" +
                    "....X...\n" +
                    "....X...\n" +
                    "........\n" +
                    "........\n", board.toString());
        }

        @Test
        public void it_can_be_moved_left() {
            board.moveLeft();
            assertEquals("" +
                    "...X....\n" +
                    "...X....\n" +
                    "...X....\n" +
                    "........\n" +
                    "........\n", board.toString());
        }

        @Test
        public void it_can_be_moved_right() {
            board.moveRight();
            assertEquals("" +
                    ".....X..\n" +
                    ".....X..\n" +
                    ".....X..\n" +
                    "........\n" +
                    "........\n", board.toString());
        }

        @Test
        public void it_can_be_moved_down() {
            board.moveDown();
            assertEquals("" +
                    "........\n" +
                    "....X...\n" +
                    "....X...\n" +
                    "....X...\n" +
                    "........\n", board.toString());
        }

        @Test
        public void it_cannot_be_moved_left_over_the_board() {
            for (int i = 0; i < LOTS_OF_TIMES; i++) {
                board.moveLeft();
            }
            assertEquals("" +
                    "X.......\n" +
                    "X.......\n" +
                    "X.......\n" +
                    "........\n" +
                    "........\n", board.toString());
        }

        @Test
        public void it_cannot_be_moved_right_over_the_board() {
            for (int i = 0; i < LOTS_OF_TIMES; i++) {
                board.moveRight();
            }
            assertEquals("" +
                    ".......X\n" +
                    ".......X\n" +
                    ".......X\n" +
                    "........\n" +
                    "........\n", board.toString());
        }

        @Test
        public void it_cannot_be_moved_down_over_the_board() {
            for (int i = 0; i < LOTS_OF_TIMES; i++) {
                board.moveDown();
            }
            assertEquals("" +
                    "........\n" +
                    "........\n" +
                    "....X...\n" +
                    "....X...\n" +
                    "....X...\n", board.toString());
            assertTrue(board.hasFalling());
        }
    }

    public class When_a_piece_is_falling_and_some_blocks_are_in_its_way {

        @Before
        public void dropPiece() {
            board = new Board("" +
                    "........\n" +
                    "Y......Y\n" +
                    "Y......Y\n" +
                    "Y......Y\n" +
                    "YYYYY..Y\n");

            board.drop(PIECE);
            assertEquals("" +
                    "....X...\n" +
                    "Y...X..Y\n" +
                    "Y...X..Y\n" +
                    "Y......Y\n" +
                    "YYYYY..Y\n", board.toString());
        }

        @Test
        public void it_cannot_be_moved_left_over_the_other_blocks() {
            for (int i = 0; i < LOTS_OF_TIMES; i++) {
                board.moveLeft();
            }
            assertEquals("" +
                    ".X......\n" +
                    "YX.....Y\n" +
                    "YX.....Y\n" +
                    "Y......Y\n" +
                    "YYYYY..Y\n", board.toString());
        }

        @Test
        public void it_cannot_be_moved_right_over_the_other_blocks() {
            for (int i = 0; i < LOTS_OF_TIMES; i++) {
                board.moveRight();
            }
            assertEquals("" +
                    "......X.\n" +
                    "Y.....XY\n" +
                    "Y.....XY\n" +
                    "Y......Y\n" +
                    "YYYYY..Y\n", board.toString());
        }

        @Test
        public void it_cannot_be_moved_down_over_the_other_blocks() {
            for (int i = 0; i < LOTS_OF_TIMES; i++) {
                board.moveDown();
            }
            assertEquals("" +
                    "........\n" +
                    "Y...X..Y\n" +
                    "Y...X..Y\n" +
                    "Y...X..Y\n" +
                    "YYYYY..Y\n", board.toString());
            assertTrue(board.hasFalling());
        }
    }
}
