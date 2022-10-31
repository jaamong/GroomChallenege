package bonus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

class Car {
    int v;
    int w;

    public Car(int v, int w) {
        this.v = v;
        this.w = w;
    }
}

public class DeadOrArrive {
    public static int solution(int n, ArrayList<Car> cars) {
        HashMap<Integer, int[]> map = new HashMap<>();
        int res = 0;

        for (int i = 1; i <= n; i++) {
            int nv = cars.get(i-1).v;
            int nw = cars.get(i-1).w;

            if (map.containsKey(nv)) { //속도가 중복이면
                int[] savedInfo = map.get(nv); //중복인 차의 내구도와 번호를 저장

                if (savedInfo[0] <= nw) { //내구도가 저장된 차의 내구도보다 크면
                    res -= savedInfo[1]; //저장된 차의 번호는 빼고
                    res += i; //큰 차의 번호를 더한다.
                    savedInfo[0] = nw;
                    savedInfo[1] = i;
                }
                continue;
            }
            res += i;
            map.put(nv, new int[]{nw, i});
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int carNum = Integer.parseInt(br.readLine());
        ArrayList<Car> cars = new ArrayList<>();

        for (int i = 0; i < carNum; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            cars.add(new Car(Integer.parseInt(st.nextToken()), (Integer.parseInt(st.nextToken()))));
        }

        System.out.println(solution(carNum, cars));
    }
}
