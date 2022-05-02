package Programmers;

public class Greedy_GymSuit {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2,4,5};
        int[] reserve = {1};
        int result = solution(n, lost, reserve);
        System.out.println(result);
    }

    /**
     * 전체 학생 수 : n
     * 도난 당한 학생 배열 : lost
     * 여벌 옷 가지고 있는 학생 배열 : reverse
     * [2,3,4] [3,5]
     *
     * 번호 앞 뒤로만 옷을 빌려 입을 수 있음
     */
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] students = new int[n];
        /**
         *  0 : 옷 1개보유
         *  1 : 여분 옷 보우
         *  -1 : 옷 없음
         */
        // 0 -1 0 -1 0
        for (int j : lost) {
            students[j - 1] += -1;
        }
        for (int i : reserve) {
            students[i - 1] += 1;
        }
        // 1 -1 0 -1 1
        for (int i = 0; i < n; i++) {
            if (students[i]  == -1) {
                // 왼쪽 조회
                if (i > 0 && students[i - 1] == 1) {
                    students[i] += 1;
                    students[i - 1] -= 1;
                    continue;
                }
                // 오른쪽 조회
                if (i < n - 1 && students[i + 1] == 1) {
                    students[i] += 1;
                    students[i + 1] -= 1;
                }
            }
        }
        for (int i : students) {
            if (i > -1) {
                answer++;
            }
        }

        return answer;
    }
}
