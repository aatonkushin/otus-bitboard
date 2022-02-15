package org.tonkushin;

import java.math.BigInteger;

public class Main {
    private static final String kingPath = "D:\\temp\\otus\\0.BITS\\1.Bitboard - Король\\";
    private static final String knightPath = "D:\\temp\\otus\\0.BITS\\2.Bitboard - Конь\\";
    private static final String rookPath = "D:\\temp\\otus\\0.BITS\\3.Bitboard - Ладья\\";

    public static void main(String[] args) {
        System.out.println("Король:");
        Task task = new King();
        Tester tester = new Tester(task, kingPath);
        tester.runTests();

        System.out.println("=== === ===");

        System.out.println("Конь:");
        task = new Knight();
        tester = new Tester(task, knightPath);
        tester.runTests();

        System.out.println("=== === ===");

        System.out.println("Ладья:");
        task = new Rook();
        tester = new Tester(task, rookPath);
        tester.runTests();

        System.out.println("=== === ===");
    }
}
