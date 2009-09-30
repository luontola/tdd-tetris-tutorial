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

@RunWith(NestedJUnit4.class)
public class MovingAFallingPieceTest extends Assert {

    private static final Piece PIECE = new Piece("" +
            ".X.\n" +
            ".X.\n" +
            ".X.\n");
    private static final int LOTS_OF_TIMES = 10;

    private final Board board = new Board(5, 8);


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
