package Inflearn.Array;

import java.util.Scanner;

public class Q11_선생님풀이 {

    static int solution(int n , int[][] arr){

        int answer = 0 , max=Integer.MIN_VALUE;
        for(int i=1 ; i <= n  ; i++){
            int cnt = 0;
            for(int j = 1 ; j <= n ; j++){
                for(int k = 1 ; k <= 5 ; k++){
                    if(arr[i][k]==arr[j][k]){
                        cnt++;
                        break;
                    }
                }
            }
            if(cnt > max){
                max = cnt;
                answer = i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[][] arr = new int[num][5];
        for(int i = 1 ; i <= num ; i++){
            for(int j = 1 ; j <= 5; j++){
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println(solution(num , arr));
    }
}
