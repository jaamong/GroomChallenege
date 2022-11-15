package bonus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindPrimeNumber {

    public static boolean isPrime(int num) {
        if (num >= 2) {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) return false;
            }
            return true;
        } else
            return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        int[] seq = Arrays.stream((br.readLine()).split(" ")).mapToInt(Integer::parseInt).toArray();

        int sum = 0;
        for (int i : seq) {
            if (isPrime(i)) sum += i;
        }
        System.out.println(sum);
    }
}
