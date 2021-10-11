package Inflearn.sort;

import java.util.Scanner;

public class Q5 {

    private static String solution(int[] arr){

        for(int i = 0 ; i < arr.length - 1 ; i++){
            int curr = arr[i];
            for(int j = (i + 1) ; j < arr.length ; j++){
                if(curr == arr[j]) return "D";
            }
        }

        return "U";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = scanner.nextInt();
        }
        System.out.println(solution(arr));
    }
}
