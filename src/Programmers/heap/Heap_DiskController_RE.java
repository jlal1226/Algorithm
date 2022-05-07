package Programmers.heap;

import java.util.ArrayList;
import java.util.Comparator;

public class Heap_DiskController_RE {
    public static void main(String[] args) {
        // {{0,2}, {0,2}, {0,2}}
        // {{0,3}, {1,9}, {2,6}}
        // {{0,2}, {0,2}, {6,2}}
        // {{0,2}, {0,2}, {6,6}, {8,2}}
        // {{1,3}, {1,9}, {2,6}}
        // {{0,10}, {4,10}, {15,2}, {5,11}}
        int[][] jobs = {{0,10}, {4,10}, {15,2}, {5,11}};
        System.out.println(solution(jobs));
    }
    static ArrayList<Job> jobList;
    public static int solution(int[][] jobs) {
        int answer = 0;

        jobList = new ArrayList<>();

        for (int i = 0; i < jobs.length; i++) {
            jobList.add(new Job(jobs[i][0], jobs[i][1]));
        }
        sortByStart();
        // 시작시 1순위 : 제일 먼저 들어온 요청
        // 동작시 1순위 : 짧은 작업 먼저
        // 쉬는시간 1순위 : 먼저 들어온 요청

        int time = 0;
        int waitingTime = 0;
        // 첫번째 요청 작업 처리
        Job firstJob = jobList.get(0);
        time += firstJob.start + firstJob.workTime;
        waitingTime = firstJob.workTime;
        jobList.remove(firstJob);

        // 작업 시간 기준 정렬
        sortByWork();

        while (jobList.size() > 0) {
            Job job = null;
            for (Job j : jobList) {
                if (j.start <= time) {
                    job = j;
                    break;
                }
            }
            if (job != null) {
                waitingTime += (time - job.start) + job.workTime;
                time += job.workTime;
            } else {
                // 먼저 들어온 요청 처리
                sortByStart();
                job = jobList.get(0);
                int tmp = job.start - time; // 잔여 대기 시간
                waitingTime += (time - job.start) + job.workTime ;
                time += tmp + job.workTime;

                sortByWork();
            }
            jobList.remove(job);
        }

        return waitingTime/jobs.length;
    }

    static void sortByStart() {
        jobList.sort(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                if (o1.start == o2.start) {
                    return o1.workTime - o2.workTime;
                }
                return o1.start - o2.start;
            }
        });
    }

    static void sortByWork() {
        jobList.sort(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                if (o1.workTime == o2.workTime) {
                    return o1.start - o2.start;
                }
                return o1.workTime - o2.workTime;
            }
        });
    }

}

class Job {
    int start;
    int workTime;

    public Job(int start, int workTime) {
        this.start = start;
        this.workTime = workTime;
    }

}
