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
public class RotatingPiecesTest {

    public static Test suite() {
        return new TestSuite(RotatingPiecesTest.class.getDeclaredClasses());
    }

    public static class APieceOf3x3Blocks extends TestCase {

        private Piece piece;

        protected void setUp() throws Exception {
            piece = new Piece("" +
                    ".X.\n" +
                    ".X.\n" +
                    "...\n");
        }

        public void testConsistsOfManyBlocks() {
            assertEquals("" +
                    ".X.\n" +
                    ".X.\n" +
                    "...\n", piece.toString());
        }

        public void testCanBeRotatedRight() {
            piece = piece.rotateRight();
            assertEquals("" +
                    "...\n" +
                    ".XX\n" +
                    "...\n", piece.toString());
        }

        public void testCanBeRotatedLeft() {
            piece = piece.rotateLeft();
            assertEquals("" +
                    "...\n" +
                    "XX.\n" +
                    "...\n", piece.toString());
        }
    }

    public static class APieceOf5x5Blocks extends TestCase {

        private Piece piece;

        protected void setUp() throws Exception {
            piece = new Piece("" +
                    "..XXX\n" +
                    "..XX.\n" +
                    "..X..\n" +
                    ".....\n" +
                    ".....\n");
        }

        public void testConsistsOfManyBlocks() {
            assertEquals("" +
                    "..XXX\n" +
                    "..XX.\n" +
                    "..X..\n" +
                    ".....\n" +
                    ".....\n", piece.toString());
        }

        public void testCanBeRotatedRight() {
            piece = piece.rotateRight();
            assertEquals("" +
                    ".....\n" +
                    ".....\n" +
                    "..XXX\n" +
                    "...XX\n" +
                    "....X\n", piece.toString());
        }

        public void testCanBeRotatedLeft() {
            piece = piece.rotateLeft();
            assertEquals("" +
                    "X....\n" +
                    "XX...\n" +
                    "XXX..\n" +
                    ".....\n" +
                    ".....\n", piece.toString());
        }
    }
}
