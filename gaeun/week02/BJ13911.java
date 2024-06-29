package week02;

// 상혁이가 안양에 산다니! 나랑 같은 고향이군.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class BJ13911 {
    static int numNodes;
    static ArrayList<Edge>[] graph;
    static PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        numNodes = Integer.parseInt(input[0]);
        int numEdges = Integer.parseInt(input[1]);

        graph = new ArrayList[numNodes + 1];
        for (int i = 1; i <= numNodes; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < numEdges; i++) {
            input = reader.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);
            graph[start].add(new Edge(end, cost));
            graph[end].add(new Edge(start, cost));
        }

        int[] macDistances = initializeDistances(reader);
        int macMin = Integer.parseInt(reader.readLine().split(" ")[1]);
        int[] starDistances = initializeDistances(reader);
        int starMin = Integer.parseInt(reader.readLine().split(" ")[1]);

        int result = findMinDistance(macDistances, macMin, starDistances, starMin);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    private static int[] initializeDistances(BufferedReader reader) throws IOException {
        String[] input = reader.readLine().split(" ");
        int count = Integer.parseInt(input[0]);
        int[] distances = new int[numNodes + 1];
        for (int i = 0; i <= numNodes; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        input = reader.readLine().split(" ");
        for (int i = 0; i < count; i++) {
            int node = Integer.parseInt(input[i]);
            distances[node] = 0;
            priorityQueue.add(new Edge(node, 0));
        }
        computeShortestPaths(distances);
        return distances;
    }

    private static void computeShortestPaths(int[] distances) {
        while (!priorityQueue.isEmpty()) {
            Edge current = priorityQueue.poll();
            for (Edge neighbor : graph[current.end]) {
                if (distances[neighbor.end] > current.cost + neighbor.cost) {
                    distances[neighbor.end] = current.cost + neighbor.cost;
                    priorityQueue.add(new Edge(neighbor.end, distances[neighbor.end]));
                }
            }
        }
    }

    private static int findMinDistance(int[] macDistances, int macMin, int[] starDistances, int starMin) {
        int minDistance = Integer.MAX_VALUE;
        for (int i = 1; i <= numNodes; i++) {
            if (macDistances[i] > 0 && macDistances[i] <= macMin && starDistances[i] > 0 && starDistances[i] <= starMin) {
                minDistance = Math.min(minDistance, macDistances[i] + starDistances[i]);
            }
        }
        return minDistance;
    }

    public static class Edge implements Comparable<Edge> {
        int end;
        int cost;

        public Edge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.cost, other.cost);
        }
    }
}
