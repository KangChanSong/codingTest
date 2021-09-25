package Inflearn.twoPointers;

import java.util.Scanner;

public class Q5 {

    private static int solution(int n){
        // 1 부터 n / 2 까지 연속된 값의 합을 구한다.
        int x = 1;
        int max = 500;
        int res = 0;
        while (x <= n/2){
            int sum = 0;
            for(int i = x ; i < max ; i++){
                sum += i;
                if(sum == n) {
                    res++;
                    break;
                }
                if(sum > n){
                    break;
                }
            }
            x++;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(solution(n));
    }
}
