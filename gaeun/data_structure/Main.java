package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * N개의 높이가 서로 다른 탑
 * 1. prevNum 보다 크면 Stack.push
 * 2. prevNum 보다 작으면 Stack.peek
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int prevNum = 0, currNum;
        int lastIdx = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= N; i++) {
            currNum = Integer.parseInt(st.nextToken());
            if (currNum > prevNum) {
                if (i != 1 && currNum < stack.peek()) {
                    sb.append(lastIdx).append(" ");
                    stack.push(currNum);
                    lastIdx = i;
                } else {
                    sb.append(0).append(" ");
                    stack.push(currNum);
                    lastIdx = i;
                }
            } else {
                sb.append(lastIdx).append(" ");
            }
            prevNum = currNum;
        }

        System.out.println(sb);
    }
}
