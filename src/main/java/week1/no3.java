package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class no3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] distance = Arrays.stream((br.readLine()).split(" "))
                .mapToInt(Integer::parseInt).toArray();

        Arrays.sort(distance);
        int x = Math.abs(distance[0] - distance[3]);
        int y = Math.abs(distance[1] - distance[2]);

        System.out.println(x + y);
    }
}
