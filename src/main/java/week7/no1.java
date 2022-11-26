package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class no1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> events = new HashMap<>();

        for (int i = 0; i < M; i++) {
            int[] eventNum = Arrays.stream((br.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray();
            int len = eventNum.length;
            for (int j = 1; j < len; j++) {
                events.put(eventNum[j], events.getOrDefault(eventNum[j], 0) + 1);
            }
        }

        List<Integer> keySetList = new ArrayList<>(events.keySet());
        keySetList.sort((o1, o2) -> {
            //이벤트 수가 같으면 이벤트 번호로 비교
            if (events.get(o2).equals(events.get(o1))) return o2.compareTo(o1);
            return events.get(o2).compareTo(events.get(o1));
        });

        System.out.print(keySetList.get(0));
        for (int i = 1; i < N; i++) {

            Integer value = events.get(keySetList.get(i));
            Integer prevValue = events.get(keySetList.get(i - 1));

            if (!value.equals(prevValue)) break;
            System.out.print(" " + keySetList.get(i));
        }
    }
}
