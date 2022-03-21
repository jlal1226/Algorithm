package Programmers;

import java.util.*;

public class Kth_Num_Sort {
    static List<Integer> result = new ArrayList<>();
    static int[] buff;
    public static void main(String[] args) {
        int[] arr = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};
        int[] answer = solution(arr, commands);
        System.out.println(Arrays.toString(answer));
    }
    public static int[] solution(int[] array, int[][] commands) {
        int com_len = commands.length;
        int[] answer = new int[com_len];
        for (int i = 0; i < com_len; i++) {
            makeArr(array, commands[i][0], commands[i][1], commands[i][2]);
        }
        int tmp = 0;
        for (int i : result) {
            answer[tmp++] = i;
        }
        return answer;
    }

    public static void makeArr(int[] arr, int start, int end, int target) {
        List<Integer> list = new ArrayList<>();
        /*
        for (int i = start - 1; i <= end - 1; i++) {
            list.add(arr[i]);
        }
        Collections.sort(list); // list 정렬
        result.add(list.get(target - 1));
        */
        int[] tmp = new int[end - start + 1];
        int index = 0;
        for (int i = start - 1; i <= end - 1; i++) {
            tmp[index++] = arr[i];
        }
        mergeSort(tmp); // 병합 정렬
        for (int i : tmp) {
            list.add(i);
        }
        result.add(list.get(target - 1));
    }
    private static void mergeSort(int[] arr) {
        int len = arr.length;
        buff = new int[len];
        __mergeSort(arr, 0, len - 1);
    }

    private static void __mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            __mergeSort(arr, left, center);
            __mergeSort(arr, center + 1, right);
            merge(arr, left, right);
        }
    }

    private static void merge(int[] arr, int left, int right) {
        int b_start = 0;
        int b_end = 0;
        int center = (left + right) / 2;
        int pr = center + 1;
        int p = left;

        for (int i = left; i <= center; i++) {
            buff[b_end++] = arr[i];
        }

        while (pr <= right && b_start < b_end) {
            arr[p++] = (buff[b_start] <= arr[pr]) ? buff[b_start++] : arr[pr++];
        }

        while (b_start < b_end) {
            arr[p++] = buff[b_start++];
        }
    }
}
