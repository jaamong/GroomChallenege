package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

class Pos {
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class no1 {

    // 0 : nothing
    // 1 : 개미집
    // 2 : 진딧물

    public static int manhattan(Pos pos1, Pos pos2) {
        return abs(pos1.x - pos2.x) + abs(pos1.y - pos2.y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Pos> list1 = new ArrayList<>();
        ArrayList<Pos> list2 = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> temps = new ArrayList<>();
            while (st.hasMoreTokens()) temps.add(Integer.valueOf(st.nextToken()));

            for (int j = 0; j < size; j++) {
                if (temps.get(j) == 1) list1.add(new Pos(i, j));
                else if (temps.get(j) == 2) list2.add(new Pos(i, j));
            }
        }

        int cnt = 0;
        for (Pos pos1 : list1) {
            int idx = 0;
            while (true) {
                if (idx == list2.size()) break;

                Pos pos2 = list2.get(idx);
                if (manhattan(pos1, pos2) <= m) {
                    cnt++;
                    break;
                } else {
                    idx++;
                }
            }
        }

        System.out.println(cnt);
    }
}
