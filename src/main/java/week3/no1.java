package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class no1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int people = Integer.parseInt(br.readLine());
        int[] scores = Arrays.stream((br.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray();

        int sum = 0;
        for(int score : scores) sum += score;

        System.out.println(sum);
    }
}
