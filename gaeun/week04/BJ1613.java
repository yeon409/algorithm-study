package week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1613 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        StringBuilder result = new StringBuilder();

        int numEvents = Integer.parseInt(tokenizer.nextToken());
        int numRelationships = Integer.parseInt(tokenizer.nextToken());
        int[][] relations = new int[numEvents + 1][numEvents + 1];

        for (int i = 0; i < numRelationships; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int earlier = Integer.parseInt(tokenizer.nextToken());
            int later = Integer.parseInt(tokenizer.nextToken());
            relations[earlier][later] = -1;
            relations[later][earlier] = 1;
        }

        for (int k = 1; k <= numEvents; k++) {
            for (int i = 1; i <= numEvents; i++) {
                if (relations[i][k] == 0) continue;
                for (int j = 1; j <= numEvents; j++) {
                    if (relations[k][j] == 0) continue;
                    if (relations[i][k] == relations[k][j]) {
                        relations[i][j] = relations[i][k];
                    }
                }
            }
        }

        int numQueries = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numQueries; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int earlier = Integer.parseInt(tokenizer.nextToken());
            int later = Integer.parseInt(tokenizer.nextToken());
            result.append(relations[earlier][later]).append("\n");
        }

        System.out.println(result);
    }
}
