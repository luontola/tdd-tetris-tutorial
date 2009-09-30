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
public class RotatingAFallingPieceTest extends Assert {

    private static final Piece PIECE = new Piece("" +
            ".X.\n" +
            "XX.\n" +
            "...\n");

    private Board board = new Board(5, 8);


    public class When_a_piece_is_falling_on_an_empty_board {

        @Before
        public void dropPiece() {
            board.drop(PIECE);
            assertEquals("" +
                    "....X...\n" +
                    "...XX...\n" +
                    "........\n" +
                    "........\n" +
                    "........\n", board.toString());
        }

        @Test
        public void it_can_be_rotated_clockwise() {
            board.rotateClockwise();
            assertEquals("" +
                    "....X...\n" +
                    "....XX..\n" +
                    "........\n" +
                    "........\n" +
                    "........\n", board.toString());
        }
    }

    // TODO: a falling piece can be rotated clockwise
    // TODO: a falling piece can be rotated counter-clockwise
    // TODO: it can not be rotated when there is no room to rotate (left wall, right wall, other pieces...)

    // TODO: when piece is up against a wall (or piece) and it is rotated (no room to rotate), move it away from the wall ("wallkick")
    // See: http://bsixcentdouze.free.fr/tc/tgm-en/tgm.html
    // http://bsixcentdouze.free.fr/tc/tgm-en/img/wallkick1.png
    // http://bsixcentdouze.free.fr/tc/tgm-en/img/wallkick2.png
    // http://bsixcentdouze.free.fr/tc/tgm-en/img/wallkick3.png
}
