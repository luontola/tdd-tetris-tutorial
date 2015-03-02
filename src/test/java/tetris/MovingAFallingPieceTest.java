// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

import net.orfjackal.nestedjunit.NestedJUnit;
import org.junit.*;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(NestedJUnit.class)
public class MovingAFallingPieceTest {

    /**
     * Test-only piece with empty cells in every direction.
     * Only non-empty cells should take part in the collision checks.
     */
    private static final Piece PIECE = new Piece("" +
            ".....\n" +
            "..X..\n" +
            ".XXX.\n" +
            "..X..\n" +
            ".....\n");
    private static final int LOTS_OF_TIMES = 10;

    private Board board;


    public class A_falling_piece {

        @Before
        public void dropPiece() {
            board = new Board(6, 8);
            board.drop(PIECE);
        }

        @Test
        public void starts_at_top_middle_even_when_the_piece_has_empty_rows_at_the_top() {
            assertThat(board.toString(), is("" +
                    "....X...\n" +
                    "...XXX..\n" +
                    "....X...\n" +
                    "........\n" +
                    "........\n" +
                    "........\n"));
        }

        @Test
        public void can_be_moved_left() {
            board.moveLeft();

            assertThat(board.toString(), is("" +
                    "...X....\n" +
                    "..XXX...\n" +
                    "...X....\n" +
                    "........\n" +
                    "........\n" +
                    "........\n"));
        }

        @Test
        public void can_be_moved_right() {
            board.moveRight();

            assertThat(board.toString(), is("" +
                    ".....X..\n" +
                    "....XXX.\n" +
                    ".....X..\n" +
                    "........\n" +
                    "........\n" +
                    "........\n"));
        }

        @Test
        public void can_be_moved_down() {
            board.moveDown();

            assertThat(board.toString(), is("" +
                    "........\n" +
                    "....X...\n" +
                    "...XXX..\n" +
                    "....X...\n" +
                    "........\n" +
                    "........\n"));
        }

        @Test
        public void cannot_be_moved_left_over_the_board() {
            for (int i = 0; i < LOTS_OF_TIMES; i++) {
                board.moveLeft();
            }

            assertThat(board.toString(), is("" +
                    ".X......\n" +
                    "XXX.....\n" +
                    ".X......\n" +
                    "........\n" +
                    "........\n" +
                    "........\n"));
        }

        @Test
        public void cannot_be_moved_right_over_the_board() {
            for (int i = 0; i < LOTS_OF_TIMES; i++) {
                board.moveRight();
            }

            assertThat(board.toString(), is("" +
                    "......X.\n" +
                    ".....XXX\n" +
                    "......X.\n" +
                    "........\n" +
                    "........\n" +
                    "........\n"));
        }

        @Test
        public void cannot_be_moved_down_over_the_board() {
            for (int i = 0; i < LOTS_OF_TIMES; i++) {
                board.moveDown();
            }

            assertThat(board.toString(), is("" +
                    "........\n" +
                    "........\n" +
                    "........\n" +
                    "....X...\n" +
                    "...XXX..\n" +
                    "....X...\n"));
            assertThat("should stop falling", board.hasFalling(), is(false));
        }
    }

    public class Piece_stops_when_another_piece_is_in_the_way {

        @Before
        public void dropPiece() {
            board = new Board("" +
                    "Z......Z\n" +
                    "Z......Z\n" +
                    "Z......Z\n" +
                    "Z......Z\n" +
                    "Z......Z\n" +
                    "Z.ZZZZZZ\n");
            board.drop(PIECE);
        }

        @Test
        public void when_moving_left() {
            for (int i = 0; i < LOTS_OF_TIMES; i++) {
                board.moveLeft();
            }

            assertThat(board.toString(), is("" +
                    "Z.X....Z\n" +
                    "ZXXX...Z\n" +
                    "Z.X....Z\n" +
                    "Z......Z\n" +
                    "Z......Z\n" +
                    "Z.ZZZZZZ\n"));
        }
    }

    // TODO: it cannot be moved right if another piece is in the way
    // TODO: it cannot be moved down if another piece is in the way (will stop falling)
}
