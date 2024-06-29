package week02;

import java.io.*;
import java.util.*;

public class BJ15831 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int totalPebbles = Integer.parseInt(tokenizer.nextToken());
        int maxBlackPebbles = Integer.parseInt(tokenizer.nextToken());
        int minWhitePebbles = Integer.parseInt(tokenizer.nextToken());

        char[] path = reader.readLine().toCharArray();

        int start = 0;
        int end = 0;

        int blackCount = 0;
        int whiteCount = 0;
        int currentLength = 0;
        int maxLength = 0;

        while (end < totalPebbles) {
            if (blackCount > maxBlackPebbles) {
                if (path[start] == 'W') {
                    whiteCount--;
                } else {
                    blackCount--;
                }
                currentLength--;
                start++;
            } else {
                if (path[end] == 'W') {
                    whiteCount++;
                } else {
                    blackCount++;
                }
                currentLength++;
                end++;
            }

            if (blackCount <= maxBlackPebbles && whiteCount >= minWhitePebbles) {
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        System.out.println(maxLength);
    }
}
