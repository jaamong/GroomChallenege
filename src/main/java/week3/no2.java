package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no2 {

    public static void revolver(StringBuilder sb, String[] keyboard, int last, int cnt) {
        cnt %= keyboard[last - 1].length();
        sb.append(keyboard[last - 1].charAt(cnt));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int len = Integer.parseInt(br.readLine());
        String s = br.readLine();

        String[] keyboard = new String[]{
                "1.,?!", "2ABC", "3DEF",
                "4GHI", "5JKL", "6MNO",
                "7PQRS", "8TUV", "9WXYZ"
        };

        int cnt = 0;
        int last = 0;
        for (int i = 0; i < len; i++) {
            if (last != s.charAt(i) - '0') {
                if (last != 0) revolver(sb, keyboard, last, cnt);
                last = s.charAt(i) - '0';
                cnt = 0;
            } else {
                ++cnt;
            }
        }

        if (last != 0) {
            revolver(sb, keyboard, last, cnt);
            System.out.println(sb);
        }
    }
}
