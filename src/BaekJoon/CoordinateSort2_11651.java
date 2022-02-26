package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class CoordinateSort2_11651 {
    static class Point {
        private int x;
        private int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static Comparator<Point> comparator = new Comparator<Point>() {
        @Override
        public int compare(Point o1, Point o2) {
            if (o1.y == o2.y)
                return o1.x - o2.x;
            return o1.y - o2.y;
        }
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Point> list = new ArrayList<>();
        Point p;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            p = new Point(x, y);
            list.add(p);
        }
        Collections.sort(list, comparator);
        StringBuilder sb = new StringBuilder();
        for (Point point : list) {
            sb.append(point.x).append(" ").append(point.y).append("\n");
        }
        System.out.println(sb);
    }
}
