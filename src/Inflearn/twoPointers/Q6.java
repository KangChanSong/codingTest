package Inflearn.twoPointers;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q6 {
    private static int solution(int k, int[] arr){
        
        // k + 1 번째 전에서 -1 을 뺌 (맨 앞, 맨 끝 고려)
        List<Integer> list = getIndexesOfZeroes(arr);

        int length = list.size();
        // 맨 앞
        int first = list.get(k+1);
        // 맨 뒤
        int last = list.get(length -1) - list.get(length - 1 - (k + 1));
        int res = first > last ? first : last;

        for(int i = 1 ; i < list.size() - 1 ; i++){
            int before = i - (k+1);
            if(before > 0){
                int temp = list.get(i) - list.get(before) - 1;
                if(temp > res) res = temp;
            }
        }

        return res;
    }

    private static List<Integer> getIndexesOfZeroes( int[] arr) {

        List<Integer> list = new ArrayList<>();
        list.add(0);
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == 0) list.add(i);
        }
        list.add(arr.length-1);

        return list;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++ ) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(solution(k, arr));
    }
}
