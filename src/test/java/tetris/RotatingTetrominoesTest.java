// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

import net.orfjackal.nestedjunit.NestedJUnit;
import org.junit.*;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Esko Luontola
 */
@RunWith(NestedJUnit.class)
public class RotatingTetrominoesTest {

    private Tetromino shape;


    public class All_shape_instances {

        @Before
        public void createAnyShape() {
            shape = Tetromino.T_SHAPE;
        }

        @Test
        public void are_immutable() {
            String original = shape.toString();
            shape.rotateCW();
            assertThat(shape.toString(), is(original));
            shape.rotateCCW();
            assertThat(shape.toString(), is(original));
        }
    }

    public class The_T_shape {

        @Before
        public void createTShape() {
            shape = Tetromino.T_SHAPE;
        }

        @Test
        public void is_shaped_like_T() {
            assertThat(shape.toString(), is("" +
                    ".T.\n" +
                    "TTT\n" +
                    "...\n"));
        }

        @Test
        public void can_be_rotated_clockwise_3_times() {
            shape = shape.rotateCW();
            assertThat(shape.toString(), is("" +
                    ".T.\n" +
                    ".TT\n" +
                    ".T.\n"));
            shape = shape.rotateCW();
            assertThat(shape.toString(), is("" +
                    "...\n" +
                    "TTT\n" +
                    ".T.\n"));
            shape = shape.rotateCW();
            assertThat(shape.toString(), is("" +
                    ".T.\n" +
                    "TT.\n" +
                    ".T.\n"));
        }

        @Test
        public void can_be_rotated_counterclockwise_3_times() {
            shape = shape.rotateCCW();
            assertThat(shape.toString(), is("" +
                    ".T.\n" +
                    "TT.\n" +
                    ".T.\n"));
            shape = shape.rotateCCW();
            assertThat(shape.toString(), is("" +
                    "...\n" +
                    "TTT\n" +
                    ".T.\n"));
            shape = shape.rotateCCW();
            assertThat(shape.toString(), is("" +
                    ".T.\n" +
                    ".TT\n" +
                    ".T.\n"));
        }

        @Test
        public void rotating_it_4_times_will_go_back_to_the_original_shape() {
            String originalShape = shape.toString();
            shape = shape.rotateCW().rotateCW().rotateCW().rotateCW();
            assertThat(shape.toString(), is(originalShape));
            shape = shape.rotateCCW().rotateCCW().rotateCCW().rotateCCW();
            assertThat(shape.toString(), is(originalShape));
        }
    }

    public class The_I_shape {

        @Before
        public void createIShape() {
            shape = Tetromino.I_SHAPE;
        }

        @Test
        public void is_shaped_like_I() {
            assertThat(shape.toString(), is("" +
                    ".....\n" +
                    ".....\n" +
                    "IIII.\n" +
                    ".....\n" +
                    ".....\n"));
        }

        @Test
        public void can_be_rotated_clockwise_once() {
            shape = shape.rotateCW();
            assertThat(shape.toString(), is("" +
                    "..I..\n" +
                    "..I..\n" +
                    "..I..\n" +
                    "..I..\n" +
                    ".....\n"));
        }

        @Test
        public void can_be_rotated_counterclockwise_once() {
            shape = shape.rotateCCW();
            assertThat(shape.toString(), is("" +
                    "..I..\n" +
                    "..I..\n" +
                    "..I..\n" +
                    "..I..\n" +
                    ".....\n"));
        }

        @Test
        public void rotating_it_twice_will_get_back_to_the_original_shape() {
            String originalShape = shape.toString();
            shape = shape.rotateCW().rotateCW();
            assertThat(shape.toString(), is(originalShape));
            shape = shape.rotateCCW().rotateCCW();
            assertThat(shape.toString(), is(originalShape));
        }
    }

    public class The_O_shape {

        @Before
        public void createOShape() {
            shape = Tetromino.O_SHAPE;
        }

        @Test
        public void is_shaped_like_O() {
            assertThat(shape.toString(), is("" +
                    ".OO\n" +
                    ".OO\n" +
                    "...\n"));
        }

        @Test
        public void can_not_be_rotated_clockwise() {
            shape = shape.rotateCW();
            assertThat(shape.toString(), is("" +
                    ".OO\n" +
                    ".OO\n" +
                    "...\n"));
        }

        @Test
        public void can_not_be_rotated_counterclockwise() {
            shape = shape.rotateCCW();
            assertThat(shape.toString(), is("" +
                    ".OO\n" +
                    ".OO\n" +
                    "...\n"));
        }
    }
}
