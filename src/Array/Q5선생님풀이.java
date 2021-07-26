package Array;

import java.util.Scanner;


//에라토스테레스 체
//원소의 배수들을 먼저 걸러냄
public class Q5선생님풀이 {

    static int solution(int n){

        int count = 0;
        int[] arr = new int[n+1];

        for(int i = 2 ; i <= n ; i ++){

            if(arr[i] == 0) count++;
            for(int j=i ; j <= n ; j = j+i){
                arr[j] = 1;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        System.out.println(solution(num));
    }
}
