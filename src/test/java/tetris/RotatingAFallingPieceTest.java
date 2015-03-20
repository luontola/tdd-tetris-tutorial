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
public class RotatingAFallingPieceTest {

    private static final int LOTS_OF_TIMES = 10;

    private Board board;

    public class When_there_is_adequate_space {

        @Before
        public void dropPiece() {
            board = new Board(6, 8);
            board.drop(new Piece("" +
                    "X..\n" +
                    "XXX\n" +
                    "...\n"));
            assertThat(board.toString(), is("" +
                    "...X....\n" +
                    "...XXX..\n" +
                    "........\n" +
                    "........\n" +
                    "........\n" +
                    "........\n"));
        }

        @Test
        public void can_rotate_clockwise() {
            board.rotateCW();

            assertThat(board.toString(), is("" +
                    "....XX..\n" +
                    "....X...\n" +
                    "....X...\n" +
                    "........\n" +
                    "........\n" +
                    "........\n"));
        }

        @Test
        public void can_rotate_counterclockwise() {
            board.rotateCCW();

            assertThat(board.toString(), is("" +
                    "....X...\n" +
                    "....X...\n" +
                    "...XX...\n" +
                    "........\n" +
                    "........\n" +
                    "........\n"));
        }
    }

    public class When_there_is_no_room_to_rotate {

        @Before
        public void dropPiece() {
            board = new Board("" +
                    "........\n" +
                    "........\n" +
                    "........\n" +
                    "..Z..Z..\n" +
                    "..Z..Z..\n" +
                    "..Z..Z..\n");
            board.drop(new Piece("" +
                    ".X.\n" +
                    ".X.\n" +
                    ".X.\n"));
        }

        @Test
        public void next_to_left_wall() {
            for (int i = 0; i < LOTS_OF_TIMES; i++) {
                board.moveLeft();
            }
            board.moveDown();
            board.moveDown();

            board.rotateCW();

            assertThat(board.toString(), is("" +
                    "........\n" +
                    "........\n" +
                    "X.......\n" +
                    "X.Z..Z..\n" +
                    "X.Z..Z..\n" +
                    "..Z..Z..\n"));
        }

        @Test
        public void next_to_right_wall() {
            for (int i = 0; i < LOTS_OF_TIMES; i++) {
                board.moveRight();
            }
            board.moveDown();
            board.moveDown();

            board.rotateCCW();

            assertThat(board.toString(), is("" +
                    "........\n" +
                    "........\n" +
                    ".......X\n" +
                    "..Z..Z.X\n" +
                    "..Z..Z.X\n" +
                    "..Z..Z..\n"));
        }
    }

    // TODO: it can not be rotated when there is no room to rotate (left wall, right wall, other pieces...)

    // TODO: when piece is up against a wall (or piece) and it is rotated (no room to rotate), move it away from the wall ("wallkick")
    // See: http://bsixcentdouze.free.fr/tc/tgm-en/tgm.html
    // http://bsixcentdouze.free.fr/tc/tgm-en/img/wallkick1.png
    // http://bsixcentdouze.free.fr/tc/tgm-en/img/wallkick2.png
    // http://bsixcentdouze.free.fr/tc/tgm-en/img/wallkick3.png
}
