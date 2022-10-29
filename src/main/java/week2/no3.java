package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class People {
    String name;
    double height;

    public People(String name, double height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }
}

public class no3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream((br.readLine()).split(" "))
                .mapToInt(Integer::parseInt).toArray();

        List<People> pList = new ArrayList<>();
        for (int i = 0; i < input[0]; i++) {
            String[] info = (br.readLine()).split(" ");
            pList.add(new People(info[0], Double.parseDouble(info[1])));
        }

        pList.sort((o1, o2) -> {
            if (o1.getName().equals(o2.getName())) {
                if (o1.getHeight() > o2.getHeight()) return 1;
                else return -1;
            } else {
                return o1.getName().compareTo(o2.getName());
            }
        });

        People people = pList.get(input[1] - 1);
        System.out.printf("%s %.2f%n", people.getName(), people.getHeight());
    }
}
