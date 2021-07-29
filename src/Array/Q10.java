package Array;

import java.util.Arrays;
import java.util.Scanner;

public class Q10 {
    static int solution(int[][] arr){

        int num = arr[0].length - 1;
        int count = 0;
        for(int i = 1 ; i < num ; i++){
            for(int j = 1 ; j < num ; j++){
                int temp = arr[i][j];
                boolean highAndLow = temp > arr[i-1][j] && temp > arr[i+1][j];
                boolean side = temp > arr[i][j-1] && temp > arr[i][j+1];
                if(highAndLow && side){
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int index = num+2;
        int[][] arr=  new int[index][index];

        for(int i = 0 ; i < index ; i++){

            if(i == 0 || i == index - 1){
                for (int a = 0 ; a < index ; a++){
                    arr[i][a] = 0;
                }
            } else {
                for (int j = 0; j < index; j++) {
                    if(j == 0 || j == index-1){
                        arr[i][j] = 0;
                    } else {
                        arr[i][j] = scanner.nextInt();
                    }
                }
            }
        }

        System.out.println(solution(arr));
    }
}
