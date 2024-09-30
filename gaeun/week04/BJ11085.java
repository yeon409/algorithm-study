package week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ11085 {
    static ArrayList<Edge>[] graph;
    static int[] maxWidths;
    static int numPoints, numPaths, start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        numPoints = Integer.parseInt(tokenizer.nextToken());
        numPaths = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        start = Integer.parseInt(tokenizer.nextToken());
        end = Integer.parseInt(tokenizer.nextToken());

        graph = new ArrayList[numPoints];
        for (int i = 0; i < numPoints; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < numPaths; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());
            int width = Integer.parseInt(tokenizer.nextToken());
            graph[u].add(new Edge(v, width));
            graph[v].add(new Edge(u, width));
        }

        maxWidths = new int[numPoints];
        maxWidths[start] = Integer.MAX_VALUE;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (Edge edge : graph[current]) {
                int minWidth = Math.min(maxWidths[current], edge.width);
                if (maxWidths[edge.to] < minWidth) {
                    maxWidths[edge.to] = minWidth;
                    queue.add(edge.to);
                }
            }
        }
        System.out.println(maxWidths[end]);
    }

    private static class Edge {
        int to, width;

        public Edge(int to, int width) {
            this.to = to;
            this.width = width;
        }
    }
}

