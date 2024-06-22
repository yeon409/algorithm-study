package week01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();
        char[] str3 = br.readLine().toCharArray();

        int[][] dp = new int[str1.length+1][str2.length+1];

        for (int i = 0; i < str1.length; i++) {
            for (int j = 0; j < str2.length; j++) {
                if (str1[i] == str2[j]) dp[i+1][j+1] = dp[i][j] + 1;
                else dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
            }
        }

        int i = str1.length;
        int j = str2.length;
        StringBuffer sb = new StringBuffer();
        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i][j-1])
                j--;
            else if (dp[i][j] == dp[i-1][j])
                i--;
            else if (dp[i][j] == dp[i-1][j-1] + 1) {
                i--;
                j--;
                sb.append(str1[i]);
            }
        }

        char[] temp = sb.reverse().toString().toCharArray();
        dp = new int[temp.length+1][str3.length+1];
        for (int k = 0; k < temp.length; k++) {
            for (int l = 0; l < str3.length; l++) {
                if (temp[k] == str3[l]) dp[k+1][l+1] = dp[k][l] + 1;
                else dp[k+1][l+1] = Math.max(dp[k][l+1], dp[k+1][l]);
            }
        }

        System.out.println(dp[temp.length][str3.length]);
    }
}
