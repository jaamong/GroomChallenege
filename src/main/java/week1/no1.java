package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class no1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        long[] bridges = Arrays.stream((br.readLine()).split(" "))
                .mapToLong(Long::parseLong).toArray();

        long res = 1;
        for (long bridge : bridges) res *= bridge;

        System.out.println(res);
    }
}
