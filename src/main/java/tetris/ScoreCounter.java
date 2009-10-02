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

    public static final int POINTS_1_ROW = 100;
    public static final int POINTS_2_ROWS = 300;
    public static final int POINTS_3_ROWS = 600;
    public static final int POINTS_4_ROWS = 1000;

    private static final int[] scoringRules = new int[]{
            0,
            POINTS_1_ROW,
            POINTS_2_ROWS,
            POINTS_3_ROWS,
            POINTS_4_ROWS
    };

    private int score = 0;
    private int removedRows = 0;

    public void onRowsRemoved(int rowCount) {
        score += scoringRules[rowCount];
        removedRows += rowCount;
    }

    public int score() {
        return score;
    }

    public int removedRows() {
        return removedRows;
    }
}
