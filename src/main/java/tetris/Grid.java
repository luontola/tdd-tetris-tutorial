// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public interface Grid {

    char EMPTY = '.';

    int rows();

    int columns();

    char cellAt(int row, int col);

    static String toString(Grid grid) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < grid.rows(); row++) {
            for (int col = 0; col < grid.columns(); col++) {
                sb.append(grid.cellAt(row, col));
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
