package Inflearn.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Q9_강사님답 {

    private static void solution(int m , int[] arr){

        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();

        int answer = 0;

        while (low <= high){
            int mid = (high + low) / 2;
            if(count(arr, mid) <= m){
                answer = mid;
            } else low = mid + 1;
        }
        System.out.println(answer);
    }

    private static int count(int[] arr, int capacity) {
        int cnt = 1, sum = 0;
        for(int x : arr){
            if(sum + x > capacity){
                cnt++;
                sum = x;
            } else sum += x;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = scanner.nextInt();
        }
        solution(m, arr);
    }
}
