package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class no4 {
    public static void isPrime(int[] primes, int a) {
        primes[0] = primes[1] = 0;

        for (int i = 2; i < Math.sqrt(a); i++) {
            if (primes[i] != 0) {
                for (int j = i + i; j <= primes.length; j += i) {
                    primes[j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        int[] primes = new int[a + 1];
        Arrays.setAll(primes, i -> i + 1);
        isPrime(primes, a);

        int[] nums = Arrays.stream((br.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> ais = IntStream.of(nums).boxed().collect(Collectors.toList());

        int res = 0;
        for (int i : primes) res += ais.get(i - 1);

        System.out.println(res);
    }
}
