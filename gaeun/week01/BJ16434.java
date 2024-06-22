package week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//- MaxHP : 용사의 최대 생명력
//- CurHP : 용사의 현재 생명력
//- Atk   : 용사의 공격력
//
//- N개의 방, 방은 순서대로 이동 가능.
//- 방에는 포션 or 몬스터가 있음
//- 몬스터가 있을 경우 몬스터를 물리쳐야 다음방으로 이동 가능
//- N번째 반에는 공주와 용. 용을 물리쳐야 공주 구함.
//
//[몬스터가 있는 방 전투 과정]
//1. Atk만큼 몬스터의 생명력 깎임
//2. 몬스터의 생명력이 0 이하면 전투 종료, 용사 다음방으로 이동
//3. 몬스터의 공격력만큼 용사의 CurHP 깎임.
//4. 용사의 생명력이 0 이하면 전투 종료, 용사 사망
//5. 다시 1부터
//[포션이 있는 방]
//- CurHP와 Atk가 일정량만큼 증가
//- 회복된 생명력이 MaxHP보다 큰 경우, CurHP = MaxHP
//
//=> answer = N번 방에 있는 용을 쓰러트리기 위한 최소의 MaxHP?

public class BJ16434 {
    static int N; // 방의 개수
    static long Atk; // 용사의 초기 공격력
    static long[][] orders;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long orgAtk = Long.parseLong(st.nextToken());
        Atk = orgAtk;

        orders = new long[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            orders[i][0] = Long.parseLong(st.nextToken());
            orders[i][1] = Long.parseLong(st.nextToken());
            orders[i][2] = Long.parseLong(st.nextToken());
        }

        long L = 1L;
        long R = 123_456_000_000_000_000L;
        long ans = 1;
        while (L<=R) {
            long M = (L + R) / 2;
            Atk = orgAtk;
            if (run(M) < 1) {
                L = M + 1;
            } else {
                R = M - 1;
                ans = M;
            }
        }
        System.out.println(ans);
    }

    public static long run(long tempHP){
        long currHP = tempHP;
        for (long[] order : orders) {
            long t = order[0];
            long a = order[1];
            long h = order[2];

            if (t == 1) {
                if (h % Atk == 0) currHP -= a * (h / Atk - 1);
                else currHP -= a * (h / Atk);
            } else {
                Atk += a;
                if (currHP + h > tempHP) {
                    currHP = tempHP;
                } else {
                    currHP += h;
                }
            }
            if (currHP < 1) return -1;
        }
        return currHP;
    }
}
