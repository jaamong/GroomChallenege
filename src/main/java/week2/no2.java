package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        String[] str = (br.readLine()).split("");

        int cnt = 1;
        for (int i = 0; i < length - 1; i++) {
            if (!str[i].equals(str[i + 1])) cnt++;
        }

        System.out.println(cnt);
    }
}
