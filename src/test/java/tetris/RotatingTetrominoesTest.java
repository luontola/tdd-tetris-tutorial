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
            shape = new Tetrominoe(1, 0, "" +
                    ".OO\n" +
                    ".OO\n" +
                    "...\n");
        }

        public void testIsShapedLikeO() {
            assertEquals("" +
                    ".OO\n" +
                    ".OO\n" +
                    "...\n", shape.toString());
        }

        public void testCanNotBeRotatedRight() {
            shape = shape.rotateRight();
            assertEquals("" +
                    ".OO\n" +
                    ".OO\n" +
                    "...\n", shape.toString());
        }

        public void testCanNotBeRotatedLeft() {
            shape = shape.rotateLeft();
            assertEquals("" +
                    ".OO\n" +
                    ".OO\n" +
                    "...\n", shape.toString());
        }
    }

    public static class TheIShape extends TestCase {

        private Tetrominoe shape;

        protected void setUp() throws Exception {
            shape = new Tetrominoe(2, 1, "" +
                    ".....\n" +
                    ".....\n" +
                    ".IIII\n" +
                    ".....\n" +
                    ".....\n");
        }

        public void testIsShapedLikeI() {
            assertEquals("" +
                    ".....\n" +
                    ".....\n" +
                    ".IIII\n" +
                    ".....\n" +
                    ".....\n", shape.toString());
        }

        public void testCanBeRotatedRightOnce() {
            shape = shape.rotateRight();
            assertEquals("" +
                    "..I..\n" +
                    "..I..\n" +
                    "..I..\n" +
                    "..I..\n" +
                    ".....\n", shape.toString());
        }

        public void testCanBeRotatedLeftOnce() {
            shape = shape.rotateLeft();
            assertEquals("" +
                    "..I..\n" +
                    "..I..\n" +
                    "..I..\n" +
                    "..I..\n" +
                    ".....\n", shape.toString());
        }

        public void testRotatingTwiseWillReturnToTheOriginalShape() {
            String originalShape = shape.toString();
            shape = shape.rotateRight().rotateRight();
            assertEquals(originalShape, shape.toString());
            shape = shape.rotateLeft().rotateLeft();
            assertEquals(originalShape, shape.toString());
        }
    }

    public static class TheTShape extends TestCase {

        private Tetrominoe shape;

        protected void setUp() throws Exception {
            shape = new Tetrominoe(4, 0, "" +
                    ".T.\n" +
                    "TTT\n" +
                    "...\n");
        }

        public void testIsShapedLikeT() {
            assertEquals("" +
                    ".T.\n" +
                    "TTT\n" +
                    "...\n", shape.toString());
        }

        public void testCanBeRotatedRightThreeTimes() {
            shape = shape.rotateRight();
            assertEquals("" +
                    ".T.\n" +
                    ".TT\n" +
                    ".T.\n", shape.toString());
            shape = shape.rotateRight();
            assertEquals("" +
                    "...\n" +
                    "TTT\n" +
                    ".T.\n", shape.toString());
            shape = shape.rotateRight();
            assertEquals("" +
                    ".T.\n" +
                    "TT.\n" +
                    ".T.\n", shape.toString());
        }
    }
}
