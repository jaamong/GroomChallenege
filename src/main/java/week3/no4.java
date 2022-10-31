package week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class no4 {
    public static final int MAX = 10_000;
    private static final ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static final ArrayList<Integer> cycle = new ArrayList<>();
    private static boolean[] visited;
    private static int found = -1;

    public static void putEdge(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public static void findCycle(int nodeIdx, int prevNodeIdx) {

        if (visited[nodeIdx]) {
            found = nodeIdx;
            if (!cycle.contains(nodeIdx)) cycle.add(nodeIdx);
            return;
        }

        visited[nodeIdx] = true;
        for (Integer i : graph.get(nodeIdx)) {
            if (i == prevNodeIdx) continue;

            findCycle(i, nodeIdx);

            if (found == -2) return;

            if (found == nodeIdx) {
                found = -2;
                return;
            }

            if (found >= 0) {
                if (!cycle.contains(nodeIdx)) cycle.add(nodeIdx);
                return;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < MAX; i++) graph.add(new ArrayList<>());

        int[] uv;
        for (int i = 0; i < num; i++) {
            uv = Arrays.stream((br.readLine()).split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            putEdge(uv[0], uv[1]);
        }
        visited = new boolean[num + 1];
        Arrays.fill(visited, false);

        findCycle(1, 1);

        System.out.println(cycle.size());

        Collections.sort(cycle);
        for (Integer i : cycle)
            System.out.print(i + " ");
    }
}
