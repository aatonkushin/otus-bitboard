package org.tonkushin;

import java.math.BigInteger;

/**
 * Ходы ладьи
 */
public class Rook implements Task {
    @Override
    public String[] run(String[] data) {
        int number = Integer.parseInt(data[0]);

        String[] retVal = new String[2];

        BigInteger mask = getMoves(number);
        retVal[1] = String.valueOf(mask);
        retVal[0] = String.valueOf(Helper.popcnt(mask));

        return retVal;
    }

    public BigInteger getMoves(int pos) {
        BigInteger k = BigInteger.ONE.shiftLeft(pos); // нужно нулевой бит сдвинуть влево на указанное количество позиций

        BigInteger a = new BigInteger("72340172838076673"); // Вертикальная линия
        BigInteger one = new BigInteger("255");             // Горизонтальная линия

        //Смещение по вертикали
        while (!a.and(k).equals(k)) {
            a = a.shiftLeft(1);
        }

        // Смещение по горизонтали
        while (!one.and(k).equals(k)) {
            one = one.shiftLeft(8);
        }

        return a.xor(one);
    }
}
