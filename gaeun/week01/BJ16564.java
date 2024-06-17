package week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 28032KB	336ms

//1. 캐릭터 레벨 sort
//2. diff = 가장 낮은 캐릭터 레벨(idx-1) & 그 다음으로 낮은 캐릭터 레벨의 차(idx)
//  2-1. diff * idx < K일 경우
//        => T = levels[idx]
//           K -= diff * idx, idx++
//  2-2. diff * idx >= K일 경우
//        => T = 가장 낮은 캐릭터 레벨 + K/idx
//           K = 0, idx++

public class BJ16564 {
    static int N, K;
    static List<Integer> levels;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // input
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        levels = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            levels.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(levels);

        int idx = 1; // 현재 2번째로 낮은 캐릭터의 레벨
        int T = levels.get(0);
        while (true) {
            if (K == 0) break;
            else if (idx == N) {
                T += (K / N);
                break;
            }

            int diff = levels.get(idx) - levels.get(idx-1);

            if (diff * idx < K) {
                T = levels.get(idx);
                K -= diff * idx;
            } else {
                T = levels.get(idx-1) + (K/idx);
                K = 0;
            }

            idx++;
        }
        System.out.println(T);
    }
}