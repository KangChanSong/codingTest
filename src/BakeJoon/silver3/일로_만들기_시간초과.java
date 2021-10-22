package BakeJoon.silver3;

import java.util.List;
import java.util.Scanner;

public class 일로_만들기_시간초과 {

    static int count = Integer.MAX_VALUE;

    private static void solution(int n){
        // 모든 가능성을 테스트해서 최솟값을 구한다.
        calculate(n, 0);
        System.out.println(count);
    }

    private static void calculate(int n, int z) {
        if(n < 1){
            return;
        }
        if(n == 1){
            if(z < count) count = z;
            return;
        }

        int temp = ++z;

        if(n % 3 == 0){
            int a = n / 3;
            calculate(a, temp);
        }
        if(n % 2 == 0){
            int b = n / 2;
            calculate(b, temp);
        }
        int c = n - 1;
        calculate(c, temp);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        solution(scanner.nextInt());
    }
}
