// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

/**
 * @author Esko Luontola
 */
public interface RotatableGrid extends Grid {

    RotatableGrid rotateRight();

    RotatableGrid rotateLeft();
}
