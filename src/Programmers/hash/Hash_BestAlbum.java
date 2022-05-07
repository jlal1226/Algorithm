package Programmers.hash;

import java.util.*;

public class Hash_BestAlbum {
    public static void main(String[] args) {
        String[] g = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] result = solution(g, plays);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();

        // 1. 장르별 총합 구해서 정렬

        HashMap<String, Integer> genreMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        ArrayList<String> orderedGenres = new ArrayList<>();
        for (String str : genreMap.keySet()) {
            orderedGenres.add(str);
        }
        Collections.sort(orderedGenres, (o1, o2) -> genreMap.get(o2) - genreMap.get(o1));

        // 2. 장르내 정렬
        ArrayList<Song> songList = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            songList.add(new Song(genres[i], plays[i], i));
        }

        for (String str : orderedGenres) {
            ArrayList<Song> tmp = new ArrayList<>();
            for (Song s : songList) {
                if (s.genre.equals(str)) {
                    tmp.add(s);
                }
            }
            tmp.sort((o1, o2) -> o2.plays - o1.plays);
            if (tmp.size() > 1) {
                answer.add(tmp.get(0).index);
                answer.add(tmp.get(1).index);
            } else {
                answer.add(tmp.get(0).index);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

class Song {
    String genre;
    int plays;
    int index;

    public Song(String genre, int plays, int index) {
        this.genre = genre;
        this.plays = plays;
        this.index = index;
    }
}
