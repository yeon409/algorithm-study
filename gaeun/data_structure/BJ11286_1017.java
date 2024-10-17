package data_structure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;

/**
 * 1. x != 0: 배열에 x 추가
 * 2. x == 0: 배열에서 절댓값이 가장 작은 값 출력(절대값이 같으면 가장 작은 수)
 *            그 값 배열에서 제거
 */
public class BJ11286_1017 {
    public static class Number implements Comparable<Number> {
        int num;

        public Number(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(Number o) {
            if (Math.abs(o.num) != Math.abs(this.num)) {
                return Math.abs(this.num) - Math.abs(o.num);
            }
            return this.num - o.num;
        }

        @Override
        public String toString() {
            return "num: " + this.num;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Number> pq = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll().num).append("\n");
                }
            } else {
                pq.add(new Number(num));
            }
        }

        System.out.println(sb);
    }
}
