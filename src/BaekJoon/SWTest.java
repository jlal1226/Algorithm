package BaekJoon;

import java.util.Scanner;

public class SWTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int a = 0;
        int b = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(')
                a++;
            else if (input.charAt(i) == ')')
                b++;
        }
        if (a == b)
            System.out.println("YES");
        else
            System.out.println("NO");

    }
}
