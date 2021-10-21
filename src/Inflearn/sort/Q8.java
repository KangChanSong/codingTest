package Inflearn.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Q8 {
    private static void solution(int target, int[] arr){
        Arrays.sort(arr);
        binarySearch(target, arr);
    }

    private static void binarySearch(int target, int[] arr) {
        int high = arr.length - 1;
        int low = 0;
        int mid = (high + low) / 2;

        boolean flag = true;
        while (flag){
            int temp = arr[mid];
            if(target == temp) {
                System.out.println(mid + 1);
                return;
            };
            if(target > temp) low = mid + 1;
            if(target < temp) high = mid - 1;
            mid = (high + low) / 2;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int target = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scanner.nextInt();
        }
        solution(target, arr);
    }
}
