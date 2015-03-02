// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

/**
 * @author Esko Luontola
 */
public class Tetromino implements RotatableGrid, Grid {

    // Some Tetris rotation systems:
    // http://tetris.wikia.com/wiki/Category:Rotation_Systems
    // http://tetris.wikia.com/wiki/Nintendo_Rotation_System
    // http://bsixcentdouze.free.fr/tc/tgm-en/tgm.html#rotations

    public static final Tetromino I_SHAPE = new Tetromino(2, 0, "" +
            ".....\n" +
            ".....\n" +
            "IIII.\n" +
            ".....\n" +
            ".....\n");
    public static final Tetromino J_SHAPE = new Tetromino(4, 0, "" +
            "..J\n" +
            "JJJ\n" +
            "...\n");
    public static final Tetromino L_SHAPE = new Tetromino(4, 0, "" +
            "L..\n" +
            "LLL\n" +
            "...\n");
    public static final Tetromino O_SHAPE = new Tetromino(1, 0, "" +
            ".OO\n" +
            ".OO\n" +
            "...\n");
    public static final Tetromino S_SHAPE = new Tetromino(2, 0, "" +
            "...\n" +
            ".SS\n" +
            "SS.\n");
    public static final Tetromino T_SHAPE = new Tetromino(4, 0, "" +
            ".T.\n" +
            "TTT\n" +
            "...\n");
    public static final Tetromino Z_SHAPE = new Tetromino(2, 1, "" +
            "...\n" +
            "ZZ.\n" +
            ".ZZ\n");

    private final Grid[] rotations;
    private final int currentRotation;

    public Tetromino(int maxRotations, int currentRotation, String blocks) {
        Piece firstRotation = firstRotation(new Piece(blocks), currentRotation);
        this.rotations = allRotations(firstRotation, maxRotations);
        this.currentRotation = currentRotation;
    }

    private static Piece firstRotation(Piece piece, int currentRotation) {
        for (int i = 0; i < currentRotation; i++) {
            piece = piece.rotateLeft();
        }
        return piece;
    }

    private static Grid[] allRotations(Piece firstRotation, int maxRotations) {
        Piece[] x = new Piece[maxRotations];
        x[0] = firstRotation;
        for (int i = 1; i < x.length; i++) {
            x[i] = x[i - 1].rotateRight();
        }
        return x;
    }

    private Tetromino(Grid[] rotations, int currentRotation) {
        while (currentRotation < 0) {
            currentRotation += rotations.length;
        }
        this.rotations = rotations;
        this.currentRotation = currentRotation % rotations.length;
    }

    public Tetromino rotateRight() {
        return new Tetromino(rotations, currentRotation + 1);
    }

    public Tetromino rotateLeft() {
        return new Tetromino(rotations, currentRotation - 1);
    }

    public int rows() {
        return self().rows();
    }

    public int columns() {
        return self().columns();
    }

    public char cellAt(Point point) {
        return self().cellAt(point);
    }

    private Grid self() {
        return rotations[currentRotation];
    }

    public String toString() {
        return Grids.toString(this);
    }
}
