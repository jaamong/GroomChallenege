package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class no4 {

    public static void putEdge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream((br.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] A = Arrays.stream((br.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); //양방향 그래프
        for (int i = 0; i < nm[0] + 1; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < nm[1]; i++) {
            int[] uv = Arrays.stream((br.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray();
            putEdge(graph, uv[0], uv[1]);
        }

        long[][] D = new long[100007][10];
        D[1][0] = 0;
        Map<Long, Map<Long, Long>> pq = new TreeMap<>();
//        pq.put(D[1][0], new TreeMap<>(1, 0));

        for (Map.Entry<Long, Map<Long, Long>> entry : pq.entrySet()) {
            entry.getValue();
        }
    }
}
