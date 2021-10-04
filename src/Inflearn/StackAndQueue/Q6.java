package Inflearn.StackAndQueue;

import java.util.*;

public class Q6 {
    private static Queue<Integer> createList(int n) {
        Queue<Integer> list = new LinkedList<>();
        for(int i = 1; i <= n ; i++){
            list.add(i);
        }
        return list;
    }

    private static int solution(int n, int k){
        // 스택 생성
        Queue<Integer> list = createList(n);

        int count = 0;
        while (list.size() > 1){
            count++;
            if(count == k){
                list.poll();
                count = 0;
            } else {
                list.add(list.poll());
            }
        }

        return list.poll();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(solution(n,k));
    }
}
