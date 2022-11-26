package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class no2 {

    static int cnt = 1;
    static int N, M;
    static boolean[] visited;

    public static void dfs(int w, ArrayList<ArrayList<Integer>> graph) {
        for (Integer e : graph.get(w)) {
            if (visited[e]) continue;

            cnt++;
            visited[e] = true;
            dfs(e, graph);
        }
    }

    public static void putEdge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); //양방향 그래프
        for (int i = 0; i < N + 1; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            int[] uv = Arrays.stream((br.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray();
            putEdge(graph, uv[0], uv[1]);
        }

        visited = new boolean[N + 1];
        Arrays.fill(visited, Boolean.FALSE);
        visited[1] = true;
        dfs(1, graph);

        System.out.println(cnt);
    }
}