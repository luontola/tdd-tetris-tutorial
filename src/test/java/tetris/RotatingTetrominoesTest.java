/*
 * Copyright (c) 2008-2009  Esko Luontola, www.orfjackal.net
 *
 * You may use and modify this source code freely for personal non-commercial use.
 * This source code may NOT be used as course material without prior written agreement.
 */

package tetris;

import junit.framework.*;

/**
 * @author Esko Luontola
 * @since 13.6.2008
 */
public class RotatingTetrominoesTest {

    public static Test suite() {
        return new TestSuite(RotatingTetrominoesTest.class.getDeclaredClasses());
    }

/*
    public static class AllShapeInstances extends TestCase {

        private Tetrominoe shape;

        protected void setUp() throws Exception {
            shape = Tetrominoe.T_SHAPE;
        }

        public void testAreImmutable() {
            String original = shape.toString();
            shape.rotateRight();
            assertEquals(original, shape.toString());
            shape.rotateLeft();
            assertEquals(original, shape.toString());
        }
    }
*/

/*
    public static class TheTShape extends TestCase {

        private Tetrominoe shape;

        protected void setUp() throws Exception {
            shape = Tetrominoe.T_SHAPE;
        }

        public void testIsShapedLikeT() {
            assertEquals("" +
                    ".T.\n" +
                    "TTT\n" +
                    "...\n", shape.toString());
        }

//        public void testCanBeRotatedRightThreeTimes() {
//            shape = shape.rotateRight();
//            assertEquals("" +
//                    ".T.\n" +
//                    ".TT\n" +
//                    ".T.\n", shape.toString());
//            shape = shape.rotateRight();
//            assertEquals("" +
//                    "...\n" +
//                    "TTT\n" +
//                    ".T.\n", shape.toString());
//            shape = shape.rotateRight();
//            assertEquals("" +
//                    ".T.\n" +
//                    "TT.\n" +
//                    ".T.\n", shape.toString());
//        }

//        public void testCanBeRotatedLeftThreeTimes() {
//            shape = shape.rotateLeft();
//            assertEquals("" +
//                    ".T.\n" +
//                    "TT.\n" +
//                    ".T.\n", shape.toString());
//            shape = shape.rotateLeft();
//            assertEquals("" +
//                    "...\n" +
//                    "TTT\n" +
//                    ".T.\n", shape.toString());
//            shape = shape.rotateLeft();
//            assertEquals("" +
//                    ".T.\n" +
//                    ".TT\n" +
//                    ".T.\n", shape.toString());
//        }

//        public void testRotatingItFourTimesWillGoBackToTheOriginalShape() {
//            String originalShape = shape.toString();
//            shape = shape.rotateRight().rotateRight().rotateRight().rotateRight();
//            assertEquals(originalShape, shape.toString());
//            shape = shape.rotateLeft().rotateLeft().rotateLeft().rotateLeft();
//            assertEquals(originalShape, shape.toString());
//        }
    }
*/

/*
    public static class TheIShape extends TestCase {

        private Tetrominoe shape;

        protected void setUp() throws Exception {
            shape = Tetrominoe.I_SHAPE;
        }

        public void testIsShapedLikeI() {
            assertEquals("" +
                    ".....\n" +
                    ".....\n" +
                    "IIII.\n" +
                    ".....\n" +
                    ".....\n", shape.toString());
        }

//        public void testCanBeRotatedRightOnce() {
//            shape = shape.rotateRight();
//            assertEquals("" +
//                    ".....\n" +
//                    "..I..\n" +
//                    "..I..\n" +
//                    "..I..\n" +
//                    "..I..\n", shape.toString());
//        }

//        public void testCanBeRotatedLeftOnce() {
//            shape = shape.rotateLeft();
//            assertEquals("" +
//                    ".....\n" +
//                    "..I..\n" +
//                    "..I..\n" +
//                    "..I..\n" +
//                    "..I..\n", shape.toString());
//        }

//        public void testRotatingItTwiseWillGetBackToTheOriginalShape() {
//            String originalShape = shape.toString();
//            shape = shape.rotateRight().rotateRight();
//            assertEquals(originalShape, shape.toString());
//            shape = shape.rotateLeft().rotateLeft();
//            assertEquals(originalShape, shape.toString());
//        }
    }
*/

/*
    public static class TheOShape extends TestCase {

        private Tetrominoe shape;

        protected void setUp() throws Exception {
            shape = Tetrominoe.O_SHAPE;
        }

        public void testIsShapedLikeO() {
            assertEquals("" +
                    ".OO\n" +
                    ".OO\n" +
                    "...\n", shape.toString());
        }

//        public void testCanNotBeRotatedRight() {
//            shape = shape.rotateRight();
//            assertEquals("" +
//                    ".OO\n" +
//                    ".OO\n" +
//                    "...\n", shape.toString());
//        }

//        public void testCanNotBeRotatedLeft() {
//            shape = shape.rotateLeft();
//            assertEquals("" +
//                    ".OO\n" +
//                    ".OO\n" +
//                    "...\n", shape.toString());
//        }
    }
*/
}
