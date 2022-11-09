package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no4 {
    static int n;
    static int m;
    static int k;

    static int MAX = 1004;
    static long MOD = (long) (1e8 + 7);
    static long[][] dp = new long[MAX][204];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= k; ++i) {
            for (int j = 0; j <= n + m; ++j) {
                dp[i][j] %= MOD;

                if (j == 0 || j == n + m) dp[i][j] = 1;
                if (0 < j - 1 && j - 1 < n + m) dp[i + 1][j - 1] += dp[i][j];
                if (0 < j && j < n + m) dp[i + 1][j] += dp[i][j];
                if (0 < j + 1 && j + 1 < n + m) dp[i + 1][j + 1] += dp[i][j];
            }
        }
        System.out.println(dp[k][n]);
    }
}
