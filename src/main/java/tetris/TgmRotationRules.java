// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

/**
 * Rotation rules for
 * <a href="http://bsixcentdouze.free.fr/tc/tgm-en/tgm.html#rotations">Tetris the Grand Master</a>
 */
public class TgmRotationRules {

    public static final RotatablePiece T_SHAPE = new RotatablePiece(
            "" +
                    "....\n" +
                    "TTT.\n" +
                    ".T..\n",
            "" +
                    ".T..\n" +
                    "TT..\n" +
                    ".T..\n",
            "" +
                    "....\n" +
                    ".T..\n" +
                    "TTT.\n",
            "" +
                    ".T..\n" +
                    ".TT.\n" +
                    ".T..\n"
    );
    public static final RotatablePiece L_SHAPE = new RotatablePiece(
            "" +
                    "....\n" +
                    "LLL.\n" +
                    "L...\n",
            "" +
                    "LL..\n" +
                    ".L..\n" +
                    ".L..\n",
            "" +
                    "....\n" +
                    "..L.\n" +
                    "LLL.\n",
            "" +
                    ".L..\n" +
                    ".L..\n" +
                    ".LL.\n");
    public static final RotatablePiece J_SHAPE = new RotatablePiece(
            "" +
                    "....\n" +
                    "JJJ.\n" +
                    "..J.\n",
            "" +
                    ".J..\n" +
                    ".J..\n" +
                    "JJ..\n",
            "" +
                    "....\n" +
                    "J...\n" +
                    "JJJ.\n",
            "" +
                    ".JJ.\n" +
                    ".J..\n" +
                    ".J..\n");
    public static final RotatablePiece I_SHAPE = new RotatablePiece(
            "" +
                    "....\n" +
                    "IIII\n" +
                    "....\n" +
                    "....\n",
            "" +
                    "..I.\n" +
                    "..I.\n" +
                    "..I.\n" +
                    "..I.\n"
    );
    public static final RotatablePiece S_SHAPE = new RotatablePiece(
            "" +
                    "....\n" +
                    ".SS.\n" +
                    "SS..\n",
            "" +
                    "S...\n" +
                    "SS..\n" +
                    ".S..\n"
    );
    public static final RotatablePiece Z_SHAPE = new RotatablePiece(
            "" +
                    "....\n" +
                    "ZZ..\n" +
                    ".ZZ.\n",
            "" +
                    "..Z.\n" +
                    ".ZZ.\n" +
                    ".Z..\n"
    );
    public static final RotatablePiece O_SHAPE = new RotatablePiece(
            "" +
                    ".OO.\n" +
                    ".OO.\n"
    );
}
