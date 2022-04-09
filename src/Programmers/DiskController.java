package Programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DiskController {
    public static void main(String[] args) {
        int[][] j = {{0,3}, {1,9}, {2,6}};
        int result = solution(j);
        //System.out.println(result);
    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        int minStart = 1001;
        int minJob = 1001;
        List<JobNode> nodeList = new ArrayList<>();
        JobNode first;
        for (int i = 0; i < jobs.length; i++) {
            // 요청이 먼저 들어온 작업
            JobNode tmp = new JobNode(jobs[i][0], jobs[i][1]);
            if (tmp.getIndex() < minStart) {
                minStart = tmp.getIndex();
                first = tmp;
            } else if (tmp.getIndex() == minStart) {

            }
        }
        // jobs 순서 정렬
        // 작업 소요시간이 작은 순서대로 정렬
        PriorityQueue<JobNode> q = new PriorityQueue<>(new Comparator<JobNode>() {
            @Override
            public int compare(JobNode o1, JobNode o2) {
                return o1.getJob() - o2.getJob();
            }
        });
        for (int i = 0; i < jobs.length; i++) {
            q.add(new JobNode(jobs[i][0], jobs[i][1]));
        }
        // heap에서 검색 -> 작업이 짧은 순

        // 평균 대기 시간 계산
        int time = 0;
        while (true) {
            time++;
            JobNode node = q.poll();

            // 작업중인 node가 없는 경우 -> 요청시간이 가장 짧은 노드


            // 작업중인 node가 있는 경우 -> 작업시간이 가장 짧은 노드

            break;

        }


        return answer;
    }
}

class JobNode {
    private int index; // 요청 시간
    private int job; // 작업 시간

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
