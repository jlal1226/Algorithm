package BaekJoon;

import java.io.*;
import java.util.Scanner;

public class Sequence_1065_BufferReader {
    static int func(int n) {
        int cnt = 0; // 1 ~ 99까지 모두 한수
        if (n < 100){
            return n;
        }else{ // 3자리 수
            cnt = 99;
            if (n > 1000)
                n = 999;
            // 100 ~ 1000를 고려하면 됌
            for (int i = 100; i <= n; i++ ) {
                int hun = i / 100;
                int ten = (i / 10) % 10;
                int one = i % 10;

                if((hun - ten) == (ten - one))
                    cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        // Buffer에 있는 IO 클래스
        // BufferReader를 사용하여 많은 데이터를 입출력 할 경우 Scanner 보다 효율이 좋음
        // 예외처리를 꼭 해줘야 한다.
        // 버퍼스트림 (InputStreamReader, OutputStreamWriter)를 같이 사용함
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(bf.readLine()); // readLine()의 return은 String 타입이라서 형변환을 해줘야함
        // 입력받은 데이터 가공하는 방법
        // 1. StringTokenizer를 활용
        // 2. String.split() 함수 활용
        int result = func(num);

        // 버퍼를 활용하여 출력하기 -> 자동 개행(줄넘김)이 없기 때문에 \n을 추가적으로 적어야됌
        bw.write(String.valueOf(result));
        bw.flush(); // 반드시 flush()와 close()를 호출해줘야됌
        bw.close();
    }
}
