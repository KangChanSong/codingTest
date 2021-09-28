package Inflearn.hashmap;

import java.util.*;

public class Q5 {

    private static List<Integer> makeList(int[] arr){

        List<Integer> list= new ArrayList<>();

        for(int x = 0 ; x < arr.length - 2 ; x++){
            for(int y = x + 1 ; y < arr.length ; y++){
                for(int z = y + 1 ; z < arr.length ; z++){
                    int sum = arr[x] + arr[y] + arr[z];
                    if(!list.contains(sum)) list.add(sum);
                }
            }
        }

        return list;
    }

    private static int solution(int[] arr, int k){
        // 3장을 뽑을 수 있는 경우의 수들을 기록한다.
        List<Integer> list = makeList(arr);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? -1 : 1;
            }
        });
        if(list.size() < k) return -1;
        else return list.get(k-1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0  ; i < arr.length ; i++){
            arr[i] = scanner.nextInt();
        }

        System.out.println(solution(arr, k));
    }
}