package data_structure;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BJ1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> answer = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        stack.push(1);

        int currN;
        int seqN = Integer.parseInt(br.readLine());
        int seqCnt = 1;
        boolean success = true;
        Loop1:
        for (int i = 1; i <= N; i++) {
            currN = i;
            stack.push(currN);
            answer.add("+");
//            System.out.println("[1] currN: " + currN + ", seqN: " + seqN + " => +");

            while (true) {
                if (currN == 1 && seqN == 1 && i == N) {
                    answer.add("-");
                    break Loop1;
                }

                if (currN < seqN) {
                    break;
                } else if (currN == seqN) {
//                    System.out.println("[2] currN: " + currN + ", seqN: " + seqN + " => -");
                    answer.add("-");
                    stack.pop();
                    currN = stack.peek();
                    seqN = Integer.parseInt(br.readLine());
                    seqCnt++;
                } else {
//                    System.out.println("[3] currN: " + currN + ", seqN: " + seqN);
                    success = false;
                    break Loop1;
                }
            }
        }

        if (!success) {
            System.out.println("NO");
        } else {
            for (String elem : answer) {
                System.out.println(elem);
            }
        }

    }
}
