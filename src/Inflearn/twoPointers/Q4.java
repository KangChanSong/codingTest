package Inflearn.twoPointers;

import java.util.Scanner;

public class Q4 {

    private static int solution(int m, int[] arr){
        int res = 0;
        int index = 0;

        // index 부터 더한다.
        while (index != arr.length - 1){
            int sum = 0;
            for(int i = index ; i < arr.length ; i++){
                sum += arr[i];
                if(sum > m) break;
                if(sum == m) {
                    res++;
                    break;}
                if(i == arr.length - 1) break;
            }
            index++;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] arr = new int[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = scanner.nextInt();
        }

        System.out.println(solution(m, arr));
    }
}
