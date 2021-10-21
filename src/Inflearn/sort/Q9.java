package Inflearn.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Q9 {

    private static void solution(int m , int[] arr){
        // 가능성이 있는 수의 범위를 찾는다.

        // DVD m장을 담을 수 있는 최솟값을 찾는다.

        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();
        boolean flag = true;
        int res = Integer.MAX_VALUE;
        while (flag){
            if(low == high) flag = false;
            int mid = (high + low) / 2;
            if(canMakeDVDs(m, arr, mid)){
                if(res > mid){
                    res = mid;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(res);
    }

    private static boolean canMakeDVDs(int m, int[] arr, int mid) {
        int sum = 0;
        int count = 0;
        for(int i = 0; i < arr.length ; i++){
            int temp = arr[i];
            sum += temp;
            if(sum > mid){
                count++;
                sum = temp;
            }
            if(count >= m){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = scanner.nextInt();
        }
        //boolean canMakeDVDs = canMakeDVDs(m, arr, 27);
        //System.out.println(canMakeDVDs);
        solution(m, arr);
    }
}
