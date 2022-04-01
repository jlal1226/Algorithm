package Programmers;

import java.util.*;

class Node {
    private int index;
    private int p;

    public Node(int index, int p) {
        this.index = index;
        this.p = p;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }
}
public class Printer {
    public static void main(String[] args) {
        int[] p = {2, 1, 3, 2};
        int l = 2;
        int[] p1 = {1, 1, 9, 1, 1, 1};
        int l1 = 0;
        int result = solution(p1, l1);
        System.out.print(result);
    }
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        int len = priorities.length;
        Node node;
        List<Node> list = new Vector<>();
        List<Node> result = new ArrayList<>();
        for (int i = 0; i < priorities.length; i++) {
            node = new Node(i, priorities[i]);
            list.add(node);
        }
        while (result.size() != len) {
            Node n = list.get(0);
            list.remove(0);
            if (check(n, list)) {
                result.add(n);
            } else {
                list.add(n);
            }

        }

        for (int i = 0; i < result.size(); i++) {
            if (location == result.get(i).getIndex()) {
                return i + 1;
            }
        }
        return answer;
    }

    public static boolean check(Node n, List<Node> list) {
        for (int i = 0; i < list.size(); i++) {
            Node tmp = list.get(i);
            if (n.getP() < tmp.getP()) {
                return false;
            }
        }
        return true;
    }
}
