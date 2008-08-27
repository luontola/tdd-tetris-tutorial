/*
 * Copyright (c) 2008, Esko Luontola. All Rights Reserved.
 *
 * This program and its source code may be freely used for personal
 * non-commercial educational purposes. Usage as course material
 * is not allowed without prior permission.
 */

package tetris;

/**
 * @author Esko Luontola
 * @since 13.6.2008
 */
public interface Grid {

    char EMPTY = '.';

    int rows();

    int columns();

    char cellAt(Point point);
}
