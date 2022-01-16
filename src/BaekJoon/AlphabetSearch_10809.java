package BaekJoon;
import java.io.*;
import java.util.Arrays;

public class AlphabetSearch_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        int[] alpha = new int[26];
/*        for (int i = 0; i < 26; i++) {
            alpha[i] = -1;
        }*/
        Arrays.fill(alpha, -1);
        System.out.println(Arrays.toString(alpha));

        for (int i = 0; i < input.length(); i++){
            int tmp = input.charAt(i) - 'a';
            if (alpha[tmp] == -1)
                alpha[tmp] = i;
        }

        for (int value : alpha){
            bw.write(String.valueOf(value)+" ");
        }
        bw.flush();
        bw.close();
    }
}
