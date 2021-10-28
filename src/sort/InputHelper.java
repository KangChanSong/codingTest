package sort;

import java.util.Scanner;

public class InputHelper {
    public static int[] inputArray(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}
