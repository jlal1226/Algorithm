package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortInside_1427 {
    public static Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    };
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N.length(); i++) {
            list.add(N.charAt(i) - '0');
        }
        Collections.sort(list, comparator);

        StringBuilder sb = new StringBuilder();
        for (int i : list) {
            sb.append(i);
        }
        System.out.println(sb);
    }
}
