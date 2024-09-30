package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ10799_0930 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");

        Stack<String> stack = new Stack<>();
        stack.push("(");
        String prevMark = "(", currMark;
        int pieceCnt = 0;
        for (int i = 1; i < input.length; i++) {
            currMark = input[i];
            if (currMark.equals(")")) {
                if (prevMark.equals(")")) {
                    pieceCnt++;
                    stack.pop();
                } else if (prevMark.equals("(")) {
                    stack.pop();
                    pieceCnt += stack.size();
                }
            } else {
                stack.push(currMark);
            }
            prevMark = currMark;
        }

        System.out.println(pieceCnt);
    }
}
