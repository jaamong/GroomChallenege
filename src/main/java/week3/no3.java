package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class no3 {

    public static void putEdge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream((br.readLine()).split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[] uv;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 5_000; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < input[1]; i++) {
            uv = Arrays.stream((br.readLine()).split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            putEdge(graph, uv[0], uv[1]);
        }

        int[] visited = new int[input[0] + 1];
        Arrays.fill(visited, -1);

        Queue<Integer> q = new LinkedList<>(); //BFS

        visited[1] = 0; //1번 노드가 시작이므로 0으로 바꾸고,
        q.add(1); //queue에 추가

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int next : graph.get(curr)) {
                if (visited[next] != -1) continue; //방문한 적이 있다면, 검색

                q.add(next); //첫 방문, 다른 검색값 찾기
                visited[next] = visited[curr] + 1; //첫방문, 이전 방문 지점의 다리 이용 횟수 + 1
            }
        }

        if (1 <= visited[input[0]] && visited[input[0]] <= input[2])
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
