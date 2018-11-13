package pl.andrzejd.blumblumshub;

import pl.andrzejd.blumblumshub.generator.BlumBlumShub;

import java.math.BigInteger;
import java.util.ArrayList;

public class MainClass {

    public static void main(String[] args) {
        ArrayList<BigInteger> sequence = new ArrayList<BigInteger>();
        BlumBlumShub bbs = new BlumBlumShub(7, 11);
        bbs.setSeed(57);
        
        for (int i = 0; i < 20000; ++i) {
            BigInteger number = bbs.generateNext();
            sequence.add(number);
            System.out.print((number.testBit(0) ? 1 : 0));
        }

        System.out.println();

        StringBuilder randomBitSequenceBuilder = new StringBuilder();

        for (BigInteger x : sequence) {
            randomBitSequenceBuilder.append(x.testBit(0) ? 1 : 0);
        }

        char[] bits = randomBitSequenceBuilder.toString().toCharArray();

        int ones = 0;

        for (int i = 0; i < 20000; i++) {
            if (bits[i] == '1') {
                ones++;
            }
        }
        System.out.println(ones);
        if (ones > 9725 && ones < 10250) {
            System.out.println("Test pojedyńczych bitów udany");
            System.out.println(ones + " jedynek");
        } else {
            System.out.println("Test pojedyńczych bitów nieudany");
            System.out.println(ones + " jedynek");
        }

        char start = bits[0];
        int[] seriesTable = new int[]{0, 0, 0, 0, 0, 0};
        int seriesCounter = 0;
        int max = 0;
        //test długiej serii i serii
        for (int i = 1; i < 20000; i++) {
            if (bits[i] == start) {
                seriesCounter++;
            } else {
                if (seriesCounter > max) {
                    max = seriesCounter;
                }
                switch (seriesCounter) {
                    case 0:
                        break;
                    case 1:
                        seriesTable[0]++;
                        break;
                    case 2:
                        seriesTable[1]++;
                        break;
                    case 3:
                        seriesTable[2]++;
                        break;
                    case 4:
                        seriesTable[3]++;
                        break;
                    case 5:
                        seriesTable[4]++;
                        break;
                    default:
                        seriesTable[5]++;
                }
                seriesCounter = 0;
            }
        }

        if (max < 26) {
            System.out.println("Test długiej serii udany - max=" + max);
        } else {
            System.out.println("Test długiej serii nieudany - max=" + max);
        }

        if ((seriesTable[0] > 2315 && seriesTable[0] < 2685)
                && (seriesTable[1] > 1114 && seriesTable[1] < 1386)
                && (seriesTable[2] > 527 && seriesTable[2] < 723)
                && (seriesTable[3] > 240 && seriesTable[3] < 384)
                && (seriesTable[4] > 103 && seriesTable[4] < 209)
                && (seriesTable[5] > 103 && seriesTable[5] < 209)) {
            System.out.println("Test serii udany");
            System.out.println(seriesTable[0] + ":"
                    + seriesTable[1] + ":"
                    + seriesTable[2] + ":"
                    + seriesTable[3] + ":"
                    + seriesTable[4] + ":"
                    + seriesTable[5] + ":");

        } else {
            System.out.println("Test serii nieudany");
            System.out.println(seriesTable[0] + ":"
                    + seriesTable[1] + ":"
                    + seriesTable[2] + ":"
                    + seriesTable[3] + ":"
                    + seriesTable[4] + ":"
                    + seriesTable[5] + ":");
        }


        int[] pokerTestArray = new int[16];

        for (int i = 0; i < 20000; i += 4) {


            int temp = ((bits[i] - 48) * 8)
                    + ((bits[i + 1] - 48) * 4)
                    + ((bits[i + 2] - 48) * 2)
                    + ((bits[i + 3] - 48));
            pokerTestArray[temp]++;
        }


        int pokerTestResultSum = 0;
        for (int i = 0; i < pokerTestArray.length; i++) {
            pokerTestArray[i] = pokerTestArray[i] * pokerTestArray[i];
            pokerTestResultSum = pokerTestResultSum + pokerTestArray[i];
        }

        double pokerTestResult = (0.0032 * pokerTestResultSum) - 5000;
        if (pokerTestResult < 46.17 && pokerTestResult > 2.16)
            System.out.println("Test pokerowy udany: " + pokerTestResult);
        else
            System.out.println("Test pokerowy nieudany: " + pokerTestResult);


    }

}
