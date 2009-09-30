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
public class RotatingTetrominoesTest extends Assert {

    private Tetromino shape;


    public class All_shape_instances {

        @Before
        public void createAnyShape() {
            shape = Tetromino.T_SHAPE;
        }

        @Test
        public void are_immutable() {
            String original = shape.toString();
            shape.rotateClockwise();
            assertEquals(original, shape.toString());
            shape.rotateCounterClockwise();
            assertEquals(original, shape.toString());
        }
    }

    public class The_T_shape {

        @Before
        public void createTShape() {
            shape = Tetromino.T_SHAPE;
        }

        @Test
        public void is_shaped_like_T() {
            assertEquals("" +
                    ".T.\n" +
                    "TTT\n" +
                    "...\n", shape.toString());
        }

        @Test
        public void can_be_rotated_clockwise_3_times() {
            shape = shape.rotateClockwise();
            assertEquals("" +
                    ".T.\n" +
                    ".TT\n" +
                    ".T.\n", shape.toString());
            shape = shape.rotateClockwise();
            assertEquals("" +
                    "...\n" +
                    "TTT\n" +
                    ".T.\n", shape.toString());
            shape = shape.rotateClockwise();
            assertEquals("" +
                    ".T.\n" +
                    "TT.\n" +
                    ".T.\n", shape.toString());
        }

        @Test
        public void can_be_rotated_counterclockwise_3_times() {
            shape = shape.rotateCounterClockwise();
            assertEquals("" +
                    ".T.\n" +
                    "TT.\n" +
                    ".T.\n", shape.toString());
            shape = shape.rotateCounterClockwise();
            assertEquals("" +
                    "...\n" +
                    "TTT\n" +
                    ".T.\n", shape.toString());
            shape = shape.rotateCounterClockwise();
            assertEquals("" +
                    ".T.\n" +
                    ".TT\n" +
                    ".T.\n", shape.toString());
        }

        @Test
        public void rotating_it_4_times_will_go_back_to_the_original_shape() {
            String originalShape = shape.toString();
            shape = shape.rotateClockwise().rotateClockwise().rotateClockwise().rotateClockwise();
            assertEquals(originalShape, shape.toString());
            shape = shape.rotateCounterClockwise().rotateCounterClockwise().rotateCounterClockwise().rotateCounterClockwise();
            assertEquals(originalShape, shape.toString());
        }
    }

    public class The_I_shape {

        @Before
        public void createIShape() {
            shape = Tetromino.I_SHAPE;
        }

        @Test
        public void is_shaped_like_I() {
            assertEquals("" +
                    ".....\n" +
                    ".....\n" +
                    "IIII.\n" +
                    ".....\n" +
                    ".....\n", shape.toString());
        }

        @Test
        public void can_be_rotated_clockwise_once() {
            shape = shape.rotateClockwise();
            assertEquals("" +
                    ".....\n" +
                    "..I..\n" +
                    "..I..\n" +
                    "..I..\n" +
                    "..I..\n", shape.toString());
        }

        @Test
        public void can_be_rotated_counterclockwise_once() {
            shape = shape.rotateCounterClockwise();
            assertEquals("" +
                    ".....\n" +
                    "..I..\n" +
                    "..I..\n" +
                    "..I..\n" +
                    "..I..\n", shape.toString());
        }

        @Test
        public void rotating_it_twise_will_get_back_to_the_original_shape() {
            String originalShape = shape.toString();
            shape = shape.rotateClockwise().rotateClockwise();
            assertEquals(originalShape, shape.toString());
            shape = shape.rotateCounterClockwise().rotateCounterClockwise();
            assertEquals(originalShape, shape.toString());
        }
    }

    public class The_O_shape {

        @Before
        public void createOShape() {
            shape = Tetromino.O_SHAPE;
        }

        @Test
        public void is_shaped_like_O() {
            assertEquals("" +
                    ".OO\n" +
                    ".OO\n" +
                    "...\n", shape.toString());
        }

        @Test
        public void can_not_be_rotated_clockwise() {
            shape = shape.rotateClockwise();
            assertEquals("" +
                    ".OO\n" +
                    ".OO\n" +
                    "...\n", shape.toString());
        }

        @Test
        public void can_not_be_rotated_counterclockwise() {
            shape = shape.rotateCounterClockwise();
            assertEquals("" +
                    ".OO\n" +
                    ".OO\n" +
                    "...\n", shape.toString());
        }
    }
}
