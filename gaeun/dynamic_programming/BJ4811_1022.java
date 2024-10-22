package dynamic_programming;

import java.io.*;
import java.math.BigDecimal;

public class BJ4811_1022 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        double[][] grid = new double[31][31];
        int lastN = 0;

        while (true) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) break;

            if (lastN < N) {

                for (int i = lastN + 1; i <= N; i++) {
                    for (int j = 0; j <= i; j++) {
                        if (j == 0) grid[i][j] = 1;
                        else grid[i][j] = grid[i][j-1] + grid[i-1][j];
                    }
                }

                lastN = N;
            }

            // Double을 int처럼 보이게 표현
            BigDecimal bigDecimal = new BigDecimal(grid[N][N]);
            BigDecimal noDecimal = bigDecimal.setScale(0, BigDecimal.ROUND_DOWN);

            sb.append(noDecimal).append("\n");
        }

        System.out.println(sb);
    }
}
