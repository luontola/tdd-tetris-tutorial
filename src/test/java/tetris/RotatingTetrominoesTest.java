/*
 * Copyright (c) 2008, Esko Luontola. All Rights Reserved.
 *
 * This program and its source code may be freely used for personal
 * non-commercial educational purposes. Usage as course material
 * is not allowed without prior permission.
 */

package tetris;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author orfjackal
 * @since Jun 13, 2008
 */
public class RotatingTetrominoesTest {

    public static Test suite() {
        return new TestSuite(RotatingTetrominoesTest.class.getDeclaredClasses());
    }

    public static class TheOShape extends TestCase {

        private Tetrominoe shape;

        protected void setUp() throws Exception {
            shape = new Tetrominoe("" +
                    ".YY\n" +
                    ".YY\n" +
                    "...\n");
        }

        public void testIsShapedLikeO() {
            assertEquals("" +
                    ".YY\n" +
                    ".YY\n" +
                    "...\n", shape.toString());
        }

        public void testCanNotBeRotatedRight() {
            shape = shape.rotateRight();
            assertEquals("" +
                    ".YY\n" +
                    ".YY\n" +
                    "...\n", shape.toString());
        }

        public void testCanNotBeRotatedLeft() {
            shape = shape.rotateLeft();
            assertEquals("" +
                    ".YY\n" +
                    ".YY\n" +
                    "...\n", shape.toString());
        }
    }

    public static class TheIShape extends TestCase {

        private Tetrominoe shape;

        protected void setUp() throws Exception {
            shape = new Tetrominoe("" +
                    ".....\n" +
                    ".....\n" +
                    ".CCCC\n" +
                    ".....\n" +
                    ".....\n");
        }

        public void testIsShapedLikeI() {
            assertEquals("" +
                    ".....\n" +
                    ".....\n" +
                    ".CCCC\n" +
                    ".....\n" +
                    ".....\n", shape.toString());
        }

        public void testCanBeRotatedRightOnce() {
            shape = shape.rotateRight();
            assertEquals("" +
                    "..C..\n" +
                    "..C..\n" +
                    "..C..\n" +
                    "..C..\n" +
                    ".....\n", shape.toString());
        }
    }
}
