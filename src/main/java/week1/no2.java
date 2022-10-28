package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nAndS = (br.readLine()).split(" ");
        int n = Integer.parseInt(nAndS[0]);

        String[] names = new String[n];
        for (int i = 0; i < n; i++) names[i] = br.readLine();

        int res = 0;
        for (String name : names) {
            if (name.contains(nAndS[1])) res++;
        }

        System.out.println(res);
    }
}
