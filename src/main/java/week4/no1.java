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

        Queue<Integer> rq = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String kind = st.nextToken();
            int money = Integer.parseInt(st.nextToken());

            if ("deposit".equals(kind)) {
                totalMoney += money;
            } else if ("pay".equals(kind)) {
                if (totalMoney >= money) totalMoney -= money;
            } else if ("reservation".equals(kind)) {
                if (rq.size() >= 1) {//대기 요금이 있다면
                    rq.add(money); //감소하지 않고 큐에 넣는다
                } else {
                    if (totalMoney >= money) totalMoney -= money;
                    else rq.add(money);
                }
            }
        }

        if (rq.isEmpty() || totalMoney == 0) {
            System.out.println(totalMoney);
            return;
        }

        while (!rq.isEmpty()) {
            int money = rq.peek();
            if (totalMoney >= money) {
                totalMoney -= money;
                rq.poll();
            } else break;
        }
        System.out.println(totalMoney);
    }
}
