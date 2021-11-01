package Inflearn.treegraph;

import java.util.*;

public class 최대점수구하기 {

    static int timeLimit;
    static int answer = 0;
    static void solution(int[][] arr){
        dp(arr, 0, 0, 0);
    }

    private static void dp(int[][] arr, int index, int totalTime, int totalScore) {
        if(totalTime > timeLimit) return;
        if(index == arr.length){
            answer = Math.max(answer, totalScore);
            return;
        }
        // 시간
        int time = arr[index][0];
        dp(arr, index+1, totalTime + time , totalScore + arr[index][1]);
        dp(arr, index+1, totalTime , totalScore);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        timeLimit = scanner.nextInt();
        int[][] arr = new int[n][2];
        for(int i = 0 ; i < arr.length ; i++){
                arr[i][1] = scanner.nextInt();
                arr[i][0] = scanner.nextInt();
        }
        solution(arr);
        System.out.println(answer);
    }
}
