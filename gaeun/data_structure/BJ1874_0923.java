package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Stack;

public class BJ1874_0923 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(br.readLine());
        }

        // Stack 생성
        Stack<Integer> stack = new Stack<>();

        int seqIdx = 0;
        int currN = 0;
        for (int i = 1; i <= N; i++) {
            // 스택에 숫자 추가하고, sb에 '+' 추가
            stack.push(i);

            while (true) {
                currN = stack.peek();
                // currN < seqN

                // currN == seqN

                // currN > seqN

            }

        }
    }
}
