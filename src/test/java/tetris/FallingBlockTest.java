/*
 * Copyright (c) 2008, Esko Luontola. All Rights Reserved.
 *
 * This program and its source code may be freely used for personal
 * non-commercial educational purposes. Usage as course material
 * is not allowed without prior permission.
 */

package tetris;

import junit.framework.TestCase;

/**
 * @author orfjackal
 * @since Jun 6, 2008
 */
public class FallingBlockTest {

    public static class ANewBoard extends TestCase {
        private Board b;

        protected void setUp() throws Exception {
            b = new Board(3, 3);
        }

        public void testIsEmpty() {
            assertEquals(b.toString(), "" +
                    "...\n" +
                    "...\n" +
                    "...\n");
        }
    }

}
