// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

import net.orfjackal.nestedjunit.NestedJUnit;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(NestedJUnit.class)
public class RotatingAFallingPieceTest {

    private static final Piece PIECE = new Piece("" +
            "X..\n" +
            "XXX\n" +
            "...\n");

    private Board board;

    @Test
    public void can_rotate_clockwise() {
        board = new Board(6, 8);
        board.drop(PIECE);
        assertThat(board.toString(), is("" +
                "...X....\n" +
                "...XXX..\n" +
                "........\n" +
                "........\n" +
                "........\n" +
                "........\n"));

        board.rotateCW();

        assertThat(board.toString(), is("" +
                "....XX..\n" +
                "....X...\n" +
                "....X...\n" +
                "........\n" +
                "........\n" +
                "........\n"));
    }

    // TODO: a falling piece can be rotated counter-clockwise
    // TODO: it can not be rotated when there is no room to rotate (left wall, right wall, other pieces...)

    // TODO: when piece is up against a wall (or piece) and it is rotated (no room to rotate), move it away from the wall ("wallkick")
    // See: http://bsixcentdouze.free.fr/tc/tgm-en/tgm.html
    // http://bsixcentdouze.free.fr/tc/tgm-en/img/wallkick1.png
    // http://bsixcentdouze.free.fr/tc/tgm-en/img/wallkick2.png
    // http://bsixcentdouze.free.fr/tc/tgm-en/img/wallkick3.png
}
