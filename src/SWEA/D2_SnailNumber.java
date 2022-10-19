package SWEA;

import java.util.Scanner;

public class D2_SnailNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        for (int test_case = 1; test_case <= T; test_case++) {
            int input = sc.nextInt();
            int[][] board = new int[input][input];
            int index = 1;
            int dir = 0;
            int x = 0;
            int y = 0;

            while (true) {
                if (index == input * input + 1) {
                    break;
                }

                if (check(input, x, y)) {
                    board[x][y] = index;
                    int nextX = dx[dir] + x;
                    int nextY = dy[dir] + y;

                    if (check(input, nextX, nextY) && board[nextX][nextY] == 0) {
                        x = nextX;
                        y = nextY;
                    } else {
                        if (dir == 3) {
                            dir = 0;
                        } else {
                            dir++;
                        }
                        x = dx[dir] + x;
                        y = dy[dir] + y;
                    }
                }
                index++;
            }

            System.out.println("#" + test_case);
            for (int[] arr : board) {
                for (int n : arr) {
                    System.out.print(n + " ");
                }
                System.out.println();
            }
        }
    }

    private static boolean check(int n, int x, int y) {
        boolean check = false;

        if (x >= 0 && x < n && y >= 0 && y < n) {
            check = true;
        }

        return check;
    }
}
