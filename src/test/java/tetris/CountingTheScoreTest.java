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
public class CountingTheScoreTest extends Assert {

    private final ScoreCounter counter = new ScoreCounter();


    public class When_the_game_is_started {

        @Test
        public void no_rows_have_been_removed() {
            assertEquals(0, counter.removedRows());
        }

        @Test
        public void the_score_is_zero() {
            assertEquals(0, counter.score());
        }
    }
}
