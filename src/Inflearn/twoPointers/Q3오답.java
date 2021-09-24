package Inflearn.twoPointers;

import java.util.Scanner;

public class Q3오답 {
    public static int solution(int k , int[] arr){
        int res = 0;
        int temp = 0;

        for(int i = 0 ; i < arr.length ; i++){
            // 0 ~ k 까지 먼저 계산 후 res 에 대입
            if(i < k) temp += arr[i];
            else {
                // res 의 맨 앞 원소를 빼고 맨 뒤 원소를 더한다.
                // 그리고 temp 와 비교 후 더 큰 값을 res로 교체
                temp +=(arr[i] - arr[i - k]);
                if(temp > res) res = temp;
            }
        }

        if(arr.length == k) res = temp;

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scanner.nextInt();
        }

        System.out.println(solution(k, arr));
    }
}
