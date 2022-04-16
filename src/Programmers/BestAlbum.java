package Programmers;

import java.util.*;

public class BestAlbum {
    public static void main(String[] args) {
        String[] g = {"classic", "pop", "classic", "classic", "pop"};
        int[] p = {500, 600, 150, 800, 2500};
        int[] answer = solution(g, p);
    }
    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        List<MusicNode> list = new ArrayList<>();

        // 1. 장르별 순서 구하기
        int tmp = 0;
        for (String g : genres) {
            list.add(new MusicNode(g, plays[tmp], tmp));
            map.put(g, map.getOrDefault(g, 0) + plays[tmp++]);
        }
        System.out.println(map.values());

        // 2. 장르 내 순서 구하기
        // 3. 2개씩 선택 후 최종 배열에 삽입

        List<String> keyList = new ArrayList<>(map.keySet());

        return answer;
    }

}
class MusicNode {
    private String genre;
    private int index;
    private int play;

    public MusicNode(String g, int i, int p) {
        this.genre = g;
        this.index = i;
        this.play = p;
    }

    public String getGenre() {
        return genre;
    }

    public int getIndex() {
        return index;
    }

    public int getPlay() {
        return play;
    }
}
