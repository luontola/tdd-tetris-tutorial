// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

import net.orfjackal.nestedjunit.NestedJUnit;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(NestedJUnit.class)
public class RotatableShapeTest {

    private RotatableShape shape = new RotatableShape(
            "" +
                    ".T.\n" +
                    "TTT\n" +
                    "...\n",
            "" +
                    ".T.\n" +
                    ".TT\n" +
                    ".T.\n",
            "" +
                    "...\n" +
                    "TTT\n" +
                    ".T.\n",
            "" +
                    ".T.\n" +
                    "TT.\n" +
                    ".T.\n"
    );

    @Test
    public void starts_with_first_shape() {
        assertThat(shape.toString(), is("" +
                ".T.\n" +
                "TTT\n" +
                "...\n"));
    }

    @Test
    public void can_be_rotated_clockwise() {
        shape = shape.rotateCW();

        assertThat(shape.toString(), is("" +
                ".T.\n" +
                ".TT\n" +
                ".T.\n"));
    }

    @Test
    public void can_be_rotated_counterclockwise() {
        shape = shape.rotateCCW();

        assertThat(shape.toString(), is("" +
                ".T.\n" +
                "TT.\n" +
                ".T.\n"));
    }

    @Test
    public void loops_around_clockwise() {
        String original = shape.toString();

        for (int i = 0; i < 4; i++) {
            shape = shape.rotateCW();
        }

        assertThat(shape.toString(), is(original));
    }

    @Test
    public void loops_around_counterclockwise() {
        String original = shape.toString();

        for (int i = 0; i < 4; i++) {
            shape = shape.rotateCCW();
        }

        assertThat(shape.toString(), is(original));
    }
}
