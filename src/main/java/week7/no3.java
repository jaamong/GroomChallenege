package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class no3 {

    public static void putEdge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
        graph.get(u).add(v); //단방향
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nmk = Arrays.stream((br.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = nmk[2];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < nmk[0] + 1; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < nmk[1]; i++) {
            int[] uv = Arrays.stream((br.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray();
            putEdge(graph, uv[0], uv[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(k); //k부터 탐색

        int[] visited = new int[nmk[0] + 1];

        while (!queue.isEmpty()) { //bfs
            int searchPoint = queue.poll();

            for (Integer newPoint : graph.get(searchPoint)) {
                if (visited[newPoint] == 0) {
                    visited[newPoint] = visited[searchPoint] + 1;
                    queue.add(newPoint);
                }
                if (newPoint == k) break;
            }
        }

        if (visited[k] == 0) System.out.println(-1);
        else System.out.println(visited[k]);
    }
}
