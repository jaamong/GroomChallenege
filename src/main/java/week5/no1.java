package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1 {

    // 0 : nothing
    // 1 : 개미집
    // 2 : 진딧물

    final static int[] dx = {-1, 1, 0, 0};
    final static int[] dy = {0, 0, -1, 1};
    static int[][] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        house = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j < n + 1; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int restAnt = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {

                if (house[i][j] == 1) { //개미집이면

                    boolean flag = false;
                    for (int k = 0; k < 4; k++) {
                        // 상하좌우로 m만큼 거리에서 진딧물집이 있는지 확인한다
                        int ni = i + dx[k]; //x축 인접 좌표
                        int nj = j + dy[k]; //y축 인접 좌표

                        for (int h = 0; h < m; h++) { //m만큼 이동
                            if ((1 <= ni && ni <= n) && (1 <= nj && nj <= n)) { //좌표가 유효하면
                                if (house[ni][nj] == 2) { //진딧물 집이면
                                    restAnt++;
                                    flag = true;
                                    break;
                                }
                            }
                            ni += dx[k];
                            nj += dy[k];
                        }
                        if(flag) break;
                    }
                }
            }
        }
        System.out.println("restAnt = " + restAnt);
    }
}
