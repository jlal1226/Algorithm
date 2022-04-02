package Programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TruckOnBridge {
    public static void main(String[] args) {
        int[] list = {10,10,10,10,10,10,10,10,10,10};
        int weight = 100;
        int len = 100;
        int result = solution(len, weight, list);
        System.out.println(result);
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int day = 0;
        int len = truck_weights.length;
        int limit = weight;
        List<TruckNode> list = new ArrayList<>();
        List<TruckNode> bridgeList = new CopyOnWriteArrayList<>(); // 동시성 문제 해결
        List<TruckNode> resultList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(new TruckNode(truck_weights[i], 0));
        }

        while (resultList.size() != len) {
            day += 1;
            // 다리위 관리
            for (TruckNode n : bridgeList) {
                if (n.getTime() == bridge_length) {
                    limit += n.getWeight();
                    bridgeList.remove(n);
                    resultList.add(n);
                }
                n.addTime();
            }
            TruckNode truck = null;
            if (!list.isEmpty()) {
                truck = list.get(0);
            }

            // 다리에 추가
            if (truck != null) {
                if (limit >= truck.getWeight()) {
                    limit -= truck.getWeight();
                    bridgeList.add(truck);
                    truck.addTime();
                    list.remove(0);
                }
            }
        }

        answer = day;
        return answer;
    }
}

class TruckNode {
    private int weight;
    private int time;

    public TruckNode(int weight, int time) {
        this.weight = weight;
        this.time = time;
    }

    public int getWeight() {
        return weight;
    }

    public int getTime() {
        return time;
    }

    public void addTime() {
        this.time += 1;
    }
}
