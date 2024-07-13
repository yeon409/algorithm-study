package week04;

import java.util.*;
import java.io.*;
import java.math.*;

public class BJ3687 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        HashMap<Integer, List<String>> matchsticksToNumbers = new HashMap<>();

        matchsticksToNumbers.put(2, Collections.singletonList("1"));
        matchsticksToNumbers.put(3, Collections.singletonList("7"));
        matchsticksToNumbers.put(4, Collections.singletonList("4"));
        matchsticksToNumbers.put(5, Arrays.asList("2", "3", "5"));
        matchsticksToNumbers.put(6, Arrays.asList("0", "6", "9"));
        matchsticksToNumbers.put(7, Collections.singletonList("8"));

        BigInteger[] maxValues = new BigInteger[101];
        maxValues[2] = new BigInteger("1");
        maxValues[3] = new BigInteger("7");
        maxValues[4] = new BigInteger("11");
        maxValues[5] = new BigInteger("71");
        maxValues[6] = new BigInteger("111");
        maxValues[7] = new BigInteger("711");
        maxValues[8] = new BigInteger("1111");

        for (int i = 9; i <= 100; i++) {
            for (int key : matchsticksToNumbers.keySet()) {
                if (maxValues[i - key] != null) {
                    BigInteger num = new BigInteger(maxValues[i - key].toString() + matchsticksToNumbers.get(key).get(matchsticksToNumbers.get(key).size() - 1));
                    if (maxValues[i] == null || maxValues[i].compareTo(num) < 0) {
                        maxValues[i] = num;
                    }
                }
            }
        }

        BigInteger[] minValues = new BigInteger[101];
        minValues[2] = new BigInteger("1");
        minValues[3] = new BigInteger("7");
        minValues[4] = new BigInteger("4");
        minValues[5] = new BigInteger("2");
        minValues[6] = new BigInteger("6");
        minValues[7] = new BigInteger("8");
        minValues[8] = new BigInteger("10");

        for (int i = 9; i <= 100; i++) {
            for (int key : matchsticksToNumbers.keySet()) {
                if (minValues[i - key] != null) {
                    BigInteger num = new BigInteger(minValues[i - key].toString() + matchsticksToNumbers.get(key).get(0));
                    if (minValues[i] == null || minValues[i].compareTo(num) > 0) {
                        minValues[i] = num;
                    }
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int t = 0; t < testCases; t++) {
            int numMatchsticks = Integer.parseInt(br.readLine());
            result.append(minValues[numMatchsticks]);
            result.append(" ");
            result.append(maxValues[numMatchsticks]);
            result.append("\n");
        }
        System.out.println(result.toString());
    }
}
