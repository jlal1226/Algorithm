package BaekJoon;
// 33은 39의 생성자, 39는 51의 생성자 ...
// 33 -> 33 + 3 + 3 = 39
// 39 -> 39 + 3 + 9 = 51
// 예외) 101은 생성자가 2개 : 91, 100
// 생성자가 없다 -> 셀프 넘버
// 100보다 작은 생성자 13개
// 10000보다 작거나 같은 셀프 넘버를 한 줄에 하나씩 출력하시오
public class SelfNumber_4673 {
    static int selfNum(int n) {
        int tmp = n;

        while (n != 0) {
            tmp += (n % 10);
            n = n / 10;
        }
        return tmp;
    }
    public static void main(String[] args) {
        boolean[] check = new boolean[10001];

        for (int i = 1; i <= 10000; i++) {
            int n = selfNum(i);

            if (n <= 10000){
                check[n] = true;
            }
        }

        for (int i = 1; i <= 10000; i++){
            if (!check[i])
                System.out.println(i);
        }
    }
}
