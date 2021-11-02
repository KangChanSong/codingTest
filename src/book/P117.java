package book;

import java.util.Arrays;

public class P117 {
    public static void main(String[] args) {
        int[] arr = {1,4,2,3,5,6,3,2};
        int n = 2;
        System.out.println("=== Q3 ===");
        System.out.println(Q3(arr ,n));

        System.out.println("=== Q4 ===");
        Arrays.sort(arr);
        System.out.println(Q4(arr, n));
    }

    static int Q3(int[] arr, int n){
        int[] idx = new int[arr.length];
        int idxI = 0;
        int count = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == n){
                idx[idxI] = i;
                idxI++;
                count++;
            }
        }

        System.out.println(Arrays.toString(idx));
        return count;
    }

    static int Q4(int[] arr, int n){
        int high = arr.length - 1;
        int low = 0;
        int mid;
        while (true){
            mid = (high + low) / 2;

            StringBuilder builder = new StringBuilder();
            for(int x = low ; x <= high ; x++){
                if(x == mid) builder.append("*");
                else builder.append("--");
            }
            System.out.println(builder);
            for(int i = 0 ; i < arr.length ; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            if(arr[mid] == n) return mid;
            if(arr[mid] > n) high = mid-1;
            if(arr[mid] < n) low = mid+1;
        }
    }
}
