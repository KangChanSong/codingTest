package String;

import java.util.Scanner;

public class Q16 {

    static void solution(int p){

        int before = 1;
        int curr = 0;

        for(int i =1 ; i <= p ; i++){

            int sum = before + curr;
            System.out.print(sum + " ");
            before = curr;
            curr = sum;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rep = scanner.nextInt();

        solution(rep);
    }

}
