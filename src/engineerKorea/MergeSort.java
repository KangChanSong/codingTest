package engineerKorea;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3,6,4,5,8,9,7,1,2};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void mergeSort(int[] arr){
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length-1);
    }

    private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
        if(start < end){
            int mid  = (start + end) / 2;
            mergeSort(arr, tmp , start, mid);
            mergeSort(arr, tmp, mid+1, end);
            merge(arr, tmp, start ,mid , end);
        }
    }

    private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
        for(int i = start ; i<= end ; i++){
            tmp[i] = arr[i];
        }
        // 첫번쨰 배열 방의 첫번째 인덱스
        int part1 = start;
        // 두번째 배열 방의 첫번째 인덱스
        int part2 = mid + 1;
        // 결과 배열의 인덱스
        int index = start;
        while (part1 <= mid && part2 <= end){
            if(tmp[part1] <= tmp[part2]){
                arr[index] = tmp[part1];
                part1++;
            } else {
                arr[index] = tmp[part2];
                part2++;
            }
            index++;
        }
        for(int i = 0 ; i < mid - part1; i++){
            arr[index + i] = tmp[part1 + i];
        }
    }
}
