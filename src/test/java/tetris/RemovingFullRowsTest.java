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
public class RemovingFullRowsTest extends Assert {

    private static final RotatableGrid PIECE = new Piece("" +
            ".X.\n" +
            ".X.\n" +
            ".X.\n"
    );

    private Board board;


    public class When_a_row_becomes_full {

        @Before
        public void dropPiece() {
            board = new Board("" +
                    "........\n" +
                    "........\n" +
                    "AA.A.AAA\n" +
                    "BBBB.BBB\n" +
                    "CCCC.CC.\n");
            board.drop(PIECE);
            board.tick();
            board.tick();
            board.tick();
            assertFalse(board.hasFalling());
        }

        @Test
        public void that_row_is_removed() {
            String status = board.toString();
            assertFalse("Should not contain 'B':\n" + status, status.contains("B"));
        }
    }
}
