package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalMoney = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String kind = st.nextToken();
            int money = Integer.parseInt(st.nextToken());

            if ("deposit".equals(kind)) {
                totalMoney += money;
                while (!q.isEmpty() && q.peek() <= totalMoney)
                    totalMoney -= q.poll();

            } else if ("pay".equals(kind)) {
                if (totalMoney >= money) totalMoney -= money;

            } else if ("reservation".equals(kind)) {
                if (q.isEmpty() && totalMoney >= money)
                    totalMoney -= money;
                else
                    q.add(money);
            }
        }
        System.out.println(totalMoney);
    }
}
