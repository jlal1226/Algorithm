package Programmers;

public class Carpet_RE {
    public static void main(String[] args) {
        solution(24, 24);
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // 노란색의 약수
        for (int row = 1; row*row <= yellow; row++) {
            int col = yellow / row;
            if ((row + 2) * (col + 2) == brown + yellow) {
                answer[0] = col + 2;
                answer[1] = row + 2;
                break;
            }
        }

        return answer;
    }
}
