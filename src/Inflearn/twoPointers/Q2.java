package Inflearn.twoPointers;

import java.util.*;

public class Q2 {

    private static List<Integer> search(int[] arr1, int[] arr2) {

        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < arr1.length ; i++ ){
            int n = Arrays.binarySearch(arr2, arr1[i]);
            if(n >= 0){
                // 중복 값 체크
                int searched = arr2[n];
                if(!list.contains(searched)){
                    list.add(searched);
                }
            }
        }
        return list;
    }

    private static void solution(int[] arr1, int[] arr2){
        // 두 배열을 정렬한다
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        // 이진 탐색으로 공통된 원소를 찾는다
        List<Integer> list = search(arr1, arr2);
        // 출력한다
        list.forEach(i -> System.out.print(i + " "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr1 = new int[n];
        for(int i=0 ; i < n ; i++){
            arr1[i] = scanner.nextInt();
        }

        n = scanner.nextInt();
        int[] arr2 = new int[n];
        for(int i=0 ; i < n ; i++){
            arr2[i] = scanner.nextInt();
        }

        solution(arr1, arr2);
    }
}
