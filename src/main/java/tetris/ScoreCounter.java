/*
 * Copyright (c) 2008-2009  Esko Luontola, www.orfjackal.net
 *
 * You may use and modify this source code freely for personal non-commercial use.
 * This source code may NOT be used as course material without prior written agreement.
 */

package tetris;

/**
 * @author Esko Luontola
 */
public class ScoreCounter implements RowRemovalListener {

    private int score = 0;

    public void onRowsRemoved(int removedRowsCount) {
        score += removedRowsCount * 100;
    }

    public int removedRows() {
        return 0;
    }

    public int score() {
        return score;
    }
}
