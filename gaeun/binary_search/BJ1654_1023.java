package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1654_1023 {
    static int K; // 가지고 있는 랜선의 개수
    static int N; // 필요한 랜선의 개수
    static int[] lengths; // 랜선 길이의 집합
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        lengths = new int[K];

        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());
            maxNum = Math.max(maxNum, num);
            lengths[i] = num;
        }

        long left = 1;
        long right = Integer.MAX_VALUE;
        long mid = (left + right) / 2;

        long result = mid;
        while (true) {
            if (left > right) { // == -> >
                break;
            }

            int lanCnt = 0;

            mid = (left + right) / 2;

            for (int i = 0; i < K; i++) {
                lanCnt += lengths[i] / mid;
            }

            if (lanCnt < N) {
                right = mid - 1; // right = mid -> right = mid - 1;
            } else {
                result = mid;
                left = mid + 1;
            }
        }

        System.out.println(result);
//        solve();
    }
    static void solve() {

        long left = 1;
        long right = Integer.MAX_VALUE;

        long count, mid;

        while (left <= right) {
            count = 0;
            mid = (left+right) / 2;
            for (int i = 0; i < K; i++) count += lengths[i] / mid;
            if (count < N) right = mid - 1;
            else left = mid + 1;
        }
        System.out.println(right);
    }
}
