package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no4 {

    static final int MAX = 1004;
    static int[][] S = new int[MAX][MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nk = Arrays.stream((br.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < nk[0]; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            S[y1][x1]++;
            S[y1][x2]--;
            S[y2][x1]--;
            S[y2][x2]++;
        }

        for (int i = 0; i < MAX; i++) for (int j = 1; j < MAX; j++) S[i][j] += S[i][j - 1];
        for (int j = 0; j < MAX; ++j) for (int i = 1; i < MAX; ++i) S[i][j] += S[i - 1][j];

        int ans = 0;
        for (int i = 0; i < MAX; ++i)
            for (int j = 0; j < MAX; ++j)
                if (S[i][j] == nk[1]) ans++;

        System.out.println(ans);
    }
}
