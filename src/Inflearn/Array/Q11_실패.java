package Inflearn.Array;

import java.util.Arrays;
import java.util.Scanner;

public class Q11_실패 {
    static int solution(int[][] arr){

        int[] students = new int[arr.length];

        //같은 반에 있엇는지 확인
        for(int j =0  ; j < 5 ; j ++){
            for(int i = 0 ; i < arr.length ; i++){
                for(int ii = 0 ; ii < arr.length ; ii++){
                    if(i != ii) {
                        if (arr[i][j] == arr[ii][j]) {
                            students[i]++;
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.toString(students));
        int result = 0;
        int temp = 0;
        for(int i = 0 ; i < students.length ; i++){
            if(students[i] > temp){
                temp = students[i];
                if(result < i){
                    result = i;
                }
            }
        }

        return result + 1;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[][] arr = new int[num][5];
        for(int i = 0 ; i < num ; i++){
            for(int j = 0 ; j < 5; j++){
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println(solution(arr));
    }
}
