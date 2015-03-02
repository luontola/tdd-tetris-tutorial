// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

import net.orfjackal.nestedjunit.NestedJUnit;
import org.junit.*;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Esko Luontola
 */
@RunWith(NestedJUnit.class)
public class RotatingPiecesOfBlocksTest {

    private Piece piece;


    public class A_piece_of_3x3_blocks {

        @Before
        public void createPiece() {
            piece = new Piece("" +
                    ".X.\n" +
                    ".X.\n" +
                    "...\n");
        }

        @Test
        public void consists_of_many_blocks() {
            assertThat(piece.toString(), is("" +
                    ".X.\n" +
                    ".X.\n" +
                    "...\n"));
        }

        @Test
        public void can_be_rotated_right() {
            piece = piece.rotateRight();
            assertThat(piece.toString(), is("" +
                    "...\n" +
                    ".XX\n" +
                    "...\n"));
        }

        @Test
        public void can_be_rotated_left() {
            piece = piece.rotateLeft();
            assertThat(piece.toString(), is("" +
                    "...\n" +
                    "XX.\n" +
                    "...\n"));
        }
    }

    public class A_piece_of_5x5_blocks {

        @Before
        public void createPiece() {
            piece = new Piece("" +
                    "..XXX\n" +
                    "..XX.\n" +
                    "..X..\n" +
                    ".....\n" +
                    ".....\n");
        }

        @Test
        public void consists_of_many_blocks() {
            assertThat(piece.toString(), is("" +
                    "..XXX\n" +
                    "..XX.\n" +
                    "..X..\n" +
                    ".....\n" +
                    ".....\n"));
        }

        @Test
        public void can_be_rotated_right() {
            piece = piece.rotateRight();
            assertThat(piece.toString(), is("" +
                    ".....\n" +
                    ".....\n" +
                    "..XXX\n" +
                    "...XX\n" +
                    "....X\n"));
        }

        @Test
        public void can_be_rotated_left() {
            piece = piece.rotateLeft();
            assertThat(piece.toString(), is("" +
                    "X....\n" +
                    "XX...\n" +
                    "XXX..\n" +
                    ".....\n" +
                    ".....\n"));
        }
    }
}
