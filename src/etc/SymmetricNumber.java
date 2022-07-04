package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SymmetricNumber {
    public static void main(String[] args) throws IOException {
        int num;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());

        int sum = 0;

        if (num < 0) {
            System.out.println(0);
        } else {
            for (int i = 1; i < num; i++) {
                String binaryString = Integer.toBinaryString(i);
                String octalString = Integer.toString(i);

                if (checkSymmetric(binaryString) && checkSymmetric(octalString)) {
                    sum += i;
                }
            }
            System.out.println(sum);
        }
    }

    public static boolean checkSymmetric(String str) {
        boolean check = true;
        int len = str.length();
        int mid = len/2;

        for (int i = 0; i < mid; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return false;
            }
        }

        return check;
    }
}
