// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

/**
 * Rotation rules for
 * <a href="http://bsixcentdouze.free.fr/tc/tgm-en/tgm.html#rotations">Tetris the Grand Master</a>
 */
public class TgmRotationRules {

    public static final RotatableShape T_SHAPE = new RotatableShape(
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
    public static final RotatableShape L_SHAPE = new RotatableShape(
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
    public static final RotatableShape J_SHAPE = new RotatableShape(
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
    public static final RotatableShape I_SHAPE = new RotatableShape(
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
    public static final RotatableShape S_SHAPE = new RotatableShape(
            "" +
                    "....\n" +
                    ".SS.\n" +
                    "SS..\n",
            "" +
                    "S...\n" +
                    "SS..\n" +
                    ".S..\n"
    );
    public static final RotatableShape Z_SHAPE = new RotatableShape(
            "" +
                    "....\n" +
                    "ZZ..\n" +
                    ".ZZ.\n",
            "" +
                    "..Z.\n" +
                    ".ZZ.\n" +
                    ".Z..\n"
    );
    public static final RotatableShape O_SHAPE = new RotatableShape(
            "" +
                    ".OO.\n" +
                    ".OO.\n"
    );
}
