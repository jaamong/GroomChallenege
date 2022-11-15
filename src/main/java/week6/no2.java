package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());
        String s = br.readLine();


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i += 2) {

            int cn = s.charAt(i + 1) - '0';

            char ca = s.charAt(i);
            for (int j = 0; j < cn * cn; j++) {
                if (ca == 'z') ca = 'a';
                else ca++;
            }
            sb.append(ca);
        }
        System.out.println(sb);
    }
}
