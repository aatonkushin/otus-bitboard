package org.tonkushin;

import java.math.BigInteger;

/**
 * Ходы коня
 * https://habr.com/ru/company/otus/blog/476510/
 */
public class Knight implements Task{
    @Override
    public String[] run(String[] data) {
        int number = Integer.parseInt(data[0]);

        String[] retVal = new String[2];

        BigInteger mask = getMoves(number);
        retVal[1] = String.valueOf(mask);
        retVal[0] = String.valueOf(Helper.popcnt(mask));

        return retVal;
    }

    private BigInteger getMoves(int pos) {
        BigInteger k = BigInteger.ONE.shiftLeft(pos); // нужно нулевой бит сдвинуть влево на указанное количество позиций

        // Ограничения ходов коня
        BigInteger nA  = new BigInteger("18374403900871474942");
        BigInteger nAB = new BigInteger("18229723555195321596");
        BigInteger  nH = new BigInteger("9187201950435737471");
        BigInteger nGH = new BigInteger("4557430888798830399");

        BigInteger mask1 = nGH.and(k.shiftLeft(6).or(k.shiftRight(10)));
        BigInteger mask2 = nH.and(k.shiftLeft(15).or(k.shiftRight(17)));
        BigInteger mask3 = nA.and(k.shiftLeft(17).or(k.shiftRight(15)));
        BigInteger mask4 = nAB.and(k.shiftLeft(10).or(k.shiftRight(6)));

        return mask1.or(mask2).or(mask3).or(mask4);
    }
}
