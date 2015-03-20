// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class RotatableShape {

    private final String[] orientations;

    public RotatableShape(String... orientations) {
        this.orientations = orientations;
    }

    @Override
    public String toString() {
        return orientations[0];
    }
}
