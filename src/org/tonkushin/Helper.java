package org.tonkushin;

import java.math.BigInteger;

public class Helper {
//    public static final BigInteger limit = BigInteger.valueOf(2).pow(63).subtract(BigInteger.ONE);
    public static final BigInteger limit = new BigInteger("18446744073709551615");

    public static int popcnt(BigInteger mask){
        int counter=0;

        while (mask.compareTo(BigInteger.ZERO) > 0) {
            counter++;

            mask = mask.and(mask.subtract(BigInteger.ONE));
        }

        return counter;
    }

    public static int popcnt2(BigInteger mask){
        int counter=0;

        while (mask.compareTo(BigInteger.ZERO) > 0) {
            if (mask.and(BigInteger.ONE).equals(BigInteger.ONE)){
                counter++;
            }

            mask = mask.shiftRight(1);
        }

        return counter;
    }
}
