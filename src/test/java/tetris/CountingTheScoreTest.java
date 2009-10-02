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
import static tetris.ScoreCounter.*;

/**
 * @author Esko Luontola
 */
@RunWith(NestedJUnit4.class)
public class CountingTheScoreTest extends Assert {

    private final ScoreCounter counter = new ScoreCounter();


    public class When_the_game_is_started {

        @Test
        public void the_score_is_zero() {
            assertEquals(0, counter.score());
        }

        @Test
        public void no_rows_have_been_removed() {
            assertEquals(0, counter.removedRows());
        }
    }

    public class When_rows_are_removed {

        @Test
        public void removing_one_row_gives_few_points() {
            counter.onRowsRemoved(1);
            assertEquals(POINTS_1_ROW, counter.score());
        }

        @Test
        public void removing_many_rows_gives_more_points() {
            counter.onRowsRemoved(2);
            assertEquals(POINTS_2_ROWS, counter.score());
        }

        @Test
        public void the_score_accumulates() {
            counter.onRowsRemoved(1);
            counter.onRowsRemoved(2);
            assertEquals(POINTS_1_ROW + POINTS_2_ROWS, counter.score());
        }

        @Test
        public void the_number_of_removed_rows_accumulates() {
            counter.onRowsRemoved(1);
            counter.onRowsRemoved(2);
            assertEquals(1 + 2, counter.removedRows());
        }
    }
}
