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
 */
public class RotatingPiecesOfBlocksTest {

    public static Test suite() {
        return new TestSuite(RotatingPiecesOfBlocksTest.class.getDeclaredClasses());
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
