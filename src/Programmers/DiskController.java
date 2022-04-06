package Programmers;

import java.util.PriorityQueue;

public class DiskController {
    public static void main(String[] args) {

    }

    public int solution(int[][] jobs) {
        int answer = 0;

        // jobs 순서 정렬

        // heap에서 검색 -> 작업이 짧은 순
        PriorityQueue<JobNode> q = new PriorityQueue<>();
        for (int i = 0; i < jobs.length; i++) {
            q.add(new JobNode(jobs[i][0], jobs[i][1]));
        }
        // 평균 대기 시간 계산



        return answer;
    }
}

class JobNode {
    private int index;
    private int job;

    public JobNode(int index, int job) {
        this.index = index;
        this.job = job;
    }

    public int getIndex() {
        return index;
    }

    public int getJob() {
        return job;
    }
}
