package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class no4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream((br.readLine()).split(" "))
                .mapToInt(Integer::parseInt).toArray();

        if (arr[0] == 1) { //한 칸이라 방향이 없으니 폭탄 터지는 수 만큼 반환
            System.out.println(arr[1]);
            return;
        }

        int cnt = 0;
        for (int i = 0; i < arr[1]; i++) {
            int[] input = Arrays.stream((br.readLine()).split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int x = input[0];
            int y = input[1];

            if (x == 1 || x == arr[0]) cnt += 2; //좌우 벽이 막혔을 때
            else cnt += 3; //자기 자신과 좌우 카운트 증가

            if (y == 1 || y == arr[0]) ++cnt;
            else cnt += 2;
        }

        System.out.println(cnt);
    }
}
