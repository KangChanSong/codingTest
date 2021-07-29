package Inflearn.Array;

import java.util.Scanner;

//시간초과..
public class Q5내풀이 {

    static int solution(int n){

        int count = 0;
        boolean flag = false;

        for(int i=2; i <= n ; i++){

            for(int j=2 ; j< i ; j++){
                if(i%j == 0) flag = true;
            }

            if(!flag){
                count++;
            } else{
                flag = false;
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
