package Inflearn.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q7 {
    private static void solution(Integer[][] arr){

        // x 좌표를 대상으로 정렬한다.
        Arrays.sort(arr, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0] > o2[0] ? 1 : (o1[0].equals(o2[0]) ? 0 : -1);
            }
        });
        // x 좌표를 참고하여 y 좌표를 정렬한다.
        Arrays.sort(arr, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                if(o1[0].equals(o2[0])){
                    return o1[1] > o2[1] ? 1 : (o1[1].equals(o2[1]) ? 0 : -1);
                }
                return 0;
            }
        });

        for(int i = 0 ; i < arr.length ; i++){
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[][] arr = new Integer[n][2];

        for(int i = 0 ; i < n; i++ ){
            for(int j = 0 ; j < 2 ; j++){
                arr[i][j] = scanner.nextInt();
            }
        }

        solution(arr);
    }
}
