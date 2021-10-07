package Inflearn.sort;

import java.util.Scanner;

public class Q4 {

    private static void solution(int n , int[] tasks){

        // 가장 최근에 들어온 작업을 가장 처음에 넣는다
        // 나머지는 뒤로 민다.

        // 중복되는 값이 있다면 추가하지 않고
        // 현재 배열에서 해당 값을 맨 앞으로 가져오고
        // 나머지는 뒤로 민다.

        // 배열의 길이는 n 을 유지한다.

        int[] cache = createCache(n);

        for(int i = 0 ; i < tasks.length ; i++){
            int a = tasks[i];
            boolean isEx = false;
            int index = 0;
            
            // 존재 확인
            for(int x = 0 ; x < cache.length ; x++){
                int b = cache[x];
                if(a == b) {
                    isEx = true;
                    index = x;
                }
            }
            
            // 정렬 & 삽입
            if(isEx){
                for(int x = index-1 ; x >= 0 ; x--){
                    cache[x+1] = cache[x];
                }
                cache[0] = a;

            } else {
                for(int x = cache.length-2 ; x >= 0 ; x--){
                    cache[x+1] = cache[x];
                }
                cache[0] = a;
            }
        }

        print(cache);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[scanner.nextInt()];
        for(int i=0; i<arr.length ; i++){
            arr[i] = scanner.nextInt();
        }
        solution(n, arr);
    }

    private static void print(int[] cache) {
        for(int i = 0 ; i < cache.length ; i++){
            System.out.print(cache[i] + " ");
        }
    }

    private static int[] createCache(int n){
        int[] cache = new int[n];
        for(int i = 0;  i < n ;i++){
            cache[i] = 0;
        }
        return cache;
    }
}
