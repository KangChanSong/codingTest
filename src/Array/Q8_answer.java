package Array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Q8_answer {

    static int solution(ArrayList<int[]> list){

        int lineMax = 0;
        int aSum = 0;
        int bSum = 0;
        int asc = 0 ;
        int desc = list.get(0).length-1;

        for(int i=0 ; i < list.get(0).length ; i++){

            int[] arr = list.get(i);
            int row = 0;
            for(int a = 0 ; a < arr.length ; a++){
                row += arr[a];
            }
            int col = 0;
            for(int b = 0 ; b < arr.length ; b++){
                col += list.get(b)[i];
            }
            int max = row > col ? row : col;
            lineMax = lineMax > max ? lineMax : max;

            aSum += list.get(i)[asc];
            asc++;
            bSum += list.get(i)[desc];
            desc--;

        }
        int crMax = aSum > bSum ? aSum: bSum;
        return lineMax > crMax ? lineMax : crMax;

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int rep = scanner.nextInt();
        ArrayList<int[]> list = new ArrayList<>();

        for(int i = 0 ; i < rep ; i++){
            int[] arr = new int[rep];
            for(int j = 0 ; j < rep ; j ++){
                arr[j] = scanner.nextInt();
            }
            list.add(arr);
        }

        System.out.println(solution(list));
    }
}
