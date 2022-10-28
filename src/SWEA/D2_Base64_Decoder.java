package SWEA;

import java.util.Base64;
import java.util.Scanner;

public class D2_Base64_Decoder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            String input = sc.next();
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] decode = decoder.decode(input);
            String result = new String(decode);
            System.out.println("#" + test_case + " " + result);
        }
    }
}
