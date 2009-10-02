/*
 * Copyright (c) 2008-2009  Esko Luontola, www.orfjackal.net
 *
 * You may use and modify this source code freely for personal non-commercial use.
 * This source code may NOT be used as course material without prior written agreement.
 */

package tetris.easymock;

import net.orfjackal.nestedjunit.NestedJUnit4;
import static org.easymock.EasyMock.*;
import org.junit.*;
import org.junit.runner.RunWith;
import tetris.*;

/**
 * @author Esko Luontola
 */
@RunWith(NestedJUnit4.class)
public class EasyMockExample_RemovingFullRowsTest extends Assert {

    private static final RotatableGrid PIECE = new Piece("" +
            ".X.\n" +
            ".X.\n" +
            ".X.\n"
    );

    private Board board;
    private final RowRemovalListener listener = createMock(RowRemovalListener.class);

    @After
    public void verifyMocks() {
        verify(listener);
    }

    private void dropAndFallToBottom(RotatableGrid piece) {
        board.drop(piece);
        while (board.hasFalling()) {
            board.tick();
        }
    }


    public class When_a_row_becomes_full {

        @Before
        public void dropPiece() {
            board = new Board("" +
                    "........\n" +
                    "........\n" +
                    "AA.A.AAA\n" +
                    "BBBB.BBB\n" +
                    "CCCC.CC.\n");
            board.addRowRemovalListener(listener);

            the_row_removal_listener_is_notified_about_the_removed_rows(listener);
            replay(listener);

            dropAndFallToBottom(PIECE);
        }

        @Test
        public void that_row_is_removed() {
            String s = board.toString();
            assertFalse("Should not contain 'B':\n" + s, s.contains("B"));
        }

        @Test
        public void the_other_rows_fall_down_to_fill_the_empty_space() {
            assertEquals("" +
                    "........\n" +
                    "........\n" +
                    "........\n" +
                    "AA.AXAAA\n" +
                    "CCCCXCC.\n", board.toString());
        }

        private void the_row_removal_listener_is_notified_about_the_removed_rows(RowRemovalListener listener) {
            listener.onRowsRemoved(1);
        }
    }

    public class When_many_rows_become_full_at_the_same_time {

        @Before
        public void dropPiece() {
            board = new Board("" +
                    "........\n" +
                    "........\n" +
                    "AAAA.AAA\n" +
                    "BBBB..BB\n" +
                    "CCCC.CCC\n");
            board.addRowRemovalListener(listener);

            the_row_removal_listener_is_notified_about_the_removed_rows(listener);
            replay(listener);

            dropAndFallToBottom(PIECE);
        }

        @Test
        public void all_of_those_rows_are_removed() {
            String s = board.toString();
            assertFalse("Should not contain 'A':\n" + s, s.contains("A"));
            assertFalse("Should not contain 'C':\n" + s, s.contains("C"));
        }

        @Test
        public void the_other_rows_fall_down_to_fill_the_empty_space() {
            assertEquals("" +
                    "........\n" +
                    "........\n" +
                    "........\n" +
                    "........\n" +
                    "BBBBX.BB\n", board.toString());
        }

        private void the_row_removal_listener_is_notified_about_the_removed_rows(RowRemovalListener listener) {
            listener.onRowsRemoved(2);
        }
    }

    public class When_no_rows_become_full {

        @Before
        public void initBoard() {
            board = new Board("" +
                    "........\n" +
                    "........\n" +
                    "AAA..AAA\n" +
                    "BBBB..BB\n" +
                    "CCC..CCC\n");
            board.addRowRemovalListener(listener);
        }

        @Test
        public void the_row_removal_listener_is_not_notified() {
            replay(listener);  // zero expectations

            dropAndFallToBottom(PIECE);
        }
    }
}
