package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class no4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> dp = new ArrayList<>();

        dp.add(0);
        dp.add(0);
        dp.add(1);

        for (int i = 3; i < n + 1; i++) {
            dp.add((2 * (i-1)+1) * dp.get(i-1) + dp.get(i - 2));
            dp.remove(0);
        }
        System.out.println(dp.get(n) % 100_000_007);
    }
}
