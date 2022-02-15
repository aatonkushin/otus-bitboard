package org.tonkushin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Tester {
    String path;
    Task task;
    Stopwatch stopwatch = new Stopwatch();

    String[] expectedResult;
    String[] calculated;

    public Tester(Task task, String path) {
        this.task = task;
        this.path = path;
    }

    public void runTests() {
        int nr = 0;
        while (true) {
            Path inFile = Paths.get(path + "test." + nr + ".in");
            Path outFile = Paths.get(path + "test." + nr + ".out");

            if (!Files.exists(inFile) || !Files.exists(outFile)) {
                break;
            }

            System.out.printf("Test #%d: ", nr);

            boolean result = runTest(inFile, outFile);

            System.out.printf("%b, %d ms%n", result, stopwatch.getElapsedTime());

            nr++;
        }
    }

    private boolean runTest(Path inFile, Path outFile) {
        boolean retVal = false;
        try {
            String[] data = Files.readAllLines(inFile).toArray(new String[0]);

            System.out.printf("(%s): ", String.join("; ", data));

            expectedResult = Files.readAllLines(outFile).toArray(new String[0]);

            stopwatch.start();
            calculated = task.run(data);
            stopwatch.stop();

            retVal = true;
            for (int i = 0; i < expectedResult.length; i++) {
                if (!calculated[i].equals(expectedResult[i])) {
                    retVal = false;
                    break;
                }
            }

            if (!retVal) {
                for (String s : calculated) {
                    System.out.printf(" %s; ", s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return retVal;
    }
}
