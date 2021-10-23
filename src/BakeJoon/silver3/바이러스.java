package BakeJoon.silver3;

import java.util.*;

public class 바이러스 {

    static Queue<Integer> queue = new LinkedList<>();

    private static void solution(int n , int[][] arr){
        queue.add(1);
        int count = 0;
        while (!queue.isEmpty()){
            count++;
            int poll = queue.poll();
            search(poll, arr);
        }
        System.out.println(count - 1);
    }

    private static void search(int n , int[][] arr){
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i][0] == n && arr[i][0] < arr[i][1]){
                queue.add(arr[i][1]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[m][2];
        for(int i = 0  ; i < m ; i ++){
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }

        solution(n, arr);
    }
}
