package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] K = new String[5];

        for (int i = 0; i < 5; i++) K[i] = br.readLine();

        int a;
        for (int i = 0; i < 5; i++) {
            a = 0;
            for (int j = 0; j < K[i].length(); j += 2)
                a += K[i].charAt(j) - '0';
            for (int j = 1; j < K[i].length(); j += 2) {
                int c = K[i].charAt(j) - '0';
                if (c != 0) a *= c;
            }
            System.out.println(a % 10);
        }
    }
}
