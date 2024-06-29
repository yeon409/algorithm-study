package week02;

import java.io.*;
import java.util.*;

public class BJ2252 {
    static List<List<Integer>> adjacencyList = new ArrayList<>();
    static StringBuilder result = new StringBuilder();
    static int numNodes;
    static int[] inDegree;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        numNodes = Integer.parseInt(tokenizer.nextToken());
        int numEdges = Integer.parseInt(tokenizer.nextToken());

        inDegree = new int[numNodes + 1];
        for (int i = 0; i <= numNodes; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < numEdges; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int fromNode = Integer.parseInt(tokenizer.nextToken());
            int toNode = Integer.parseInt(tokenizer.nextToken());

            adjacencyList.get(fromNode).add(toNode);
            inDegree[toNode]++;
        }

        performTopologicalSort();
        System.out.println(result);
    }

    static void performTopologicalSort() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= numNodes; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            result.append(currentNode).append(" ");

            for (int adjacentNode : adjacencyList.get(currentNode)) {
                inDegree[adjacentNode]--;

                if (inDegree[adjacentNode] == 0) {
                    queue.offer(adjacentNode);
                }
            }
        }
    }
}
