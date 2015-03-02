// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

import net.orfjackal.nestedjunit.NestedJUnit;
import org.junit.*;
import org.junit.runner.RunWith;

@RunWith(NestedJUnit.class)
public class MovingAFallingPieceTest extends Assert {

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


    @Test
    public void a_falling_piece_starts_at_top_middle_even_when_the_piece_has_empty_rows_at_the_top() {
        Board board = new Board(6, 8);

        board.drop(PIECE);

        assertEquals("" +
                "....X...\n" +
                "...XXX..\n" +
                "....X...\n" +
                "........\n" +
                "........\n" +
                "........\n", board.toString());
    }

    @Test
    public void a_falling_piece_can_be_moved_left() {
        Board board = new Board(6, 8);

        board.drop(PIECE);

        board.moveLeft();

        assertEquals("" +
                "...X....\n" +
                "..XXX...\n" +
                "...X....\n" +
                "........\n" +
                "........\n" +
                "........\n", board.toString());
    }

    // TODO: a falling piece can be moved right
    // TODO: a falling piece can be moved down
    // TODO: it will not move left over over the board
    // TODO: it will not move right over over the board
    // TODO: it will not move down over over the board (will stop falling)
    // TODO: it can not be moved left if another piece is in the way
    // TODO: it can not be moved right if another piece is in the way
    // TODO: it can not be moved down if another piece is in the way (will stop falling)
}
