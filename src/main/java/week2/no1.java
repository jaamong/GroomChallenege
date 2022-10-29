package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class no1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < testNum; i++) {
            int people = Integer.parseInt(br.readLine());
            int[] scores = Arrays.stream((br.readLine()).split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            double avg = (double) Arrays.stream(scores).sum() / people;

            int cnt = 0;
            for (int score : scores) if (avg <= score) cnt++;

            System.out.println(cnt + "/" + people);
        }
    }
}
