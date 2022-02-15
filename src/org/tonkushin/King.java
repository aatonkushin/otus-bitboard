package org.tonkushin;

import java.math.BigInteger;

/**
 * Ходы короля
 */
public class King implements Task {
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
        BigInteger k = BigInteger.ONE.shiftLeft(pos);

        BigInteger noA = new BigInteger("18374403900871474942");
        BigInteger kA = k.and(noA);

        BigInteger noH = new BigInteger("9187201950435737471");
        BigInteger kH = k.and(noH);

        BigInteger mask =
                kA.shiftLeft(7).or(k.shiftLeft(8)).or(kH.shiftLeft(9))
                        .or(kA.shiftRight(1)).or(kH.shiftLeft(1))
                        .or(kA.shiftRight(9)).or(k.shiftRight(8)).or(kH.shiftRight(7));
        return mask.and(Helper.limit);
    }
}
