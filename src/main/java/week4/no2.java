package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class no2 {
    static final int[] dx = new int[]{-1, 1, 0, 0};
    static final int[] dy = new int[]{0, 0, -1, 1};
    static int[][] park;
    static int[][] update;

    //물들지 않은 나무가 있으면 false
    //모두 물들었다면 true 반환
    public static boolean isColored(int parkSize) {
        for (int i = 1; i < parkSize + 1; i++) {
            for (int j = 1; j < parkSize + 1; j++) {
                if (park[i][j] != 0) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int parkSize = Integer.parseInt(br.readLine());
        park = new int[parkSize + 1][parkSize + 1];
        update = new int[parkSize + 1][parkSize + 1];

        for (int i = 1; i < parkSize + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < parkSize + 1; j++) {
                park[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //이미 모두 물들어있다면 종료 (예외처리)
        if (isColored(parkSize)) {
            System.out.println(0);
            return;
        }

        int day = 1;
        while (true) { //나무가 모두 물들때까지 시뮬레이션을 계속한다.
            for (int i = 1; i < parkSize + 1; i++) {
                for (int j = 1; j < parkSize + 1; j++) {
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dx[k]; //x축 인접 좌표
                        int nj = j + dy[k]; //y축 인접 좌표
                        if (ni < 1 || nj < 1 || ni > parkSize || nj > parkSize) continue; //유효한 좌표가 아니면 continue;
                        if (park[ni][nj] == 0) update[i][j]++; //단풍나무가 모두 물들어있는 구역의 수 세기
                    }
                }
            }
            for (int i = 1; i < parkSize + 1; i++) {
                for (int j = 1; j < parkSize + 1; j++) {
                    park[i][j] = max(0, park[i][j] - update[i][j]); //물들이기
                }
            }
            if (isColored(parkSize)) break; //나무가 모두 물들었다면 탈출

            day++;
            initUpdateArr(); //업데이트 값 초기화
        }
        System.out.println(day);
    }

    private static void initUpdateArr() {
        for (int[] i : update) {
            Arrays.fill(i, 0);
        }
    }
}
