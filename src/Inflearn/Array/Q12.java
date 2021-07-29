package Inflearn.Array;

import java.util.Arrays;
import java.util.Scanner;

public class Q12 {
    static int solution(int[][] arr){
        int res = 0;

        int[] students = new int[arr[0].length];

        boolean flag = false;

        for(int i = 0 ; i < arr[0].length ; i++){
            int temp = arr[0][i];
            for(int j = 0 ; j < arr.length ; j++){
                for(int k = 0 ; k < arr[0].length ; k++){
                    if(flag){
                        students[arr[j][k]-1]++;
                    }
                    if(temp == arr[j][k]) {
                        flag = true;
                    }
                }
                flag = false;
            }


            for(int z = 0 ; z < students.length ; z++){
                if(students[z] == arr.length){
                    res++;
                }
            }
            students = new int[arr[0].length];
        }



        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int y = scanner.nextInt();
        int x = scanner.nextInt();
        int[][] arr = new int[x][y];

        for(int i = 0 ; i < x ; i++){
            for(int j =0  ; j < y ; j++){
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println(solution(arr));
    }
}
