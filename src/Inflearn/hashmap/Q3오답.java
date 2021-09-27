package Inflearn.hashmap;
import java.util.*;

// map.size 를 이용하면 됏엇음...
public class Q3오답 {

    private static void solution(int[] arr, int k){
        // 맵에 원소들을 넣는다.
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0 ; i < arr.length ; i++){
            if(i >= k){
                Integer x = map.get(arr[i - k]);
                if(x == 0) map.remove(arr[i-k]);
                else map.put(arr[i-k], x-1);
            }
            if(map.get(arr[i]) == null){
                map.put(arr[i], 0);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
            if(i >= k -1 ){
                System.out.print(map.size() + " ");}
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scanner.nextInt();
        }

        solution(arr, k);
    }
}