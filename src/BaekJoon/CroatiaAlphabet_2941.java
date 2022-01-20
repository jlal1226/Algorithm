package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CroatiaAlphabet_2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp == 'c') {
                if (i < s.length() - 1){
                    if (s.charAt(i + 1) == '=' || s.charAt(i + 1) == '-') {
                        i += 1;
                    }
                }
            } else if (tmp == 'd') {
                if (i < s.length() - 2) {
                    if (s.charAt(i + 1) == 'z') {
                        if (s.charAt(i + 2) == '=') {
                            i += 1;
                        }
                    }
                }
                else if (s.charAt(i + 1) == '-') {
                    if (i < s.length() - 1) {
                        i += 1;
                    }
                }
            }
            else if (tmp == 'l' && s.charAt(i + 1) == 'j'){
                if (i < s.length() - 1) {
                    i += 1;
                }
            }
            else if (tmp == 'n' && s.charAt(i + 1) == 'j') {
                if (i < s.length() - 1)
                    i += 1;
            }
            else if (tmp == 's' && s.charAt(i + 1) == '=') {
                if (i < s.length() - 1)
                    i += 1;
            }
            else if (tmp == 'z' && s.charAt(i + 1) == '=')
                if (i < s.length() - 1)
                    i += 1;

        }
        System.out.println(cnt);
    }
}
