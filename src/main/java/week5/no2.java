package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no2 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int length, width;
    static int[][] visit, upd, sand;

    public static void dfs(int y, int x) {

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (ny < 0 || nx < 0 || ny >= length || nx >= width) continue;
            if (visit[ny][nx] == 1 || sand[ny][nx] == 0) continue;

            visit[ny][nx] = 1;
            dfs(ny, nx);

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        length = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        sand = new int[length][width];
        for (int[] i : sand) Arrays.fill(i, 0);

        for (int i = 0; i < length; i++) {
            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> info = new ArrayList<>();
            while (st.hasMoreTokens()) info.add(Integer.valueOf(st.nextToken()));

            for (int j = 0; j < width; j++) {
                sand[i][j] = info.get(j);
            }
        }

        visit = new int[length][width];
        upd = new int[length][width];
        for (int[] i : visit) Arrays.fill(i, 0);
        for (int[] i : upd) Arrays.fill(i, 0);

        int time = 0;
        while (true) {
            int island = 0;
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    if (visit[i][j] == 1 || sand[i][j] == 0) continue;

                    visit[i][j] = 1;
                    island++;

                    dfs(i, j);
                }
            }
            if (island > 1) {
                System.out.println(time);
                return;
            }
            if (island == 0) {
                System.out.println(-1);
                return;
            }

            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dy[k];
                        int nj = j + dx[k];
                        if (ni < 0 || nj < 0 || ni >= length || nj >= width) continue;
                        if (sand[ni][nj] == 0) upd[i][j] = 1;
                    }
                }
            }

            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    if (upd[i][j] == 1) sand[i][j] = 0;
                }
            }

            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    upd[i][j] = visit[i][j] = 0;
                }
            }

            time++;
        }
    }
}
