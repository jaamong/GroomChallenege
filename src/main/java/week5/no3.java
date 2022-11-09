package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Math.min;

public class no3 {
    static final int MAX = 8;
    static int N; //카드의 개수
    static long answer = (long) 1e18;
    static boolean[] visited = new boolean[MAX]; //중복해서 뽑지 않기 위해 체크

    public static int calculate(int[] output) {
        int res = output[0];

        for (int i = 1; i < N; i++) {
            if (res % 10 == output[i] / 10) //n번째의 일의 자리와 n+1번째의 십의 자리가 같으면
                res = res * 10 + output[i] % 10; //일의 자리만 이어 붙이기
            else
                res = res * 100 + output[i]; //n번째 수에 100 곱하고(최대 2자리니까) 더하기
        }
        return res;
    }

    public static void permute(int[] input, int[] output, int depth) {
        if (input.length == depth) {
            answer = min(answer, calculate(output));
            return;
        }

        for (int i = 0; i < input.length; i++) {
            if (visited[i]) continue; // output에 이미 방문한(할당한) idx

            //if false
            visited[i] = true;
            output[depth] = input[i];
            permute(input, output, depth + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] input = Arrays.stream((br.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(input);

        int[] output = new int[MAX];
        permute(input, output, 0);

        System.out.println(answer);
    }
}
