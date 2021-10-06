package Inflearn.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q8 {

    private static int solution(int m , Queue<Integer> patients){
        int initialSize = patients.size();
        int location = m;
        // m 번째 환자보다 큰 값이 존재하지 않을때까지 poll
        // 결과 큐의 사이즈 추출

        while (patients.size()>1){
            int poll = patients.poll();
            if(isSmaller(poll, patients)){
                patients.add(poll);
                if(location == 0) location = patients.size()-1;
                else location--;
            } else {
                if(location == 0) break;
                else location--;
            }
        }

        return initialSize - patients.size();
    }

    private static boolean isSmaller(int poll, Queue<Integer> patients) {
        boolean isSmaller = false;
        for(int i = 0 ; i < patients.size() ; i++){
            Integer p = patients.poll();
            patients.add(p);
            if(poll < p){
                isSmaller = true;
            }
        }

        return isSmaller;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Queue<Integer> list = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            list.add(scanner.nextInt());
        }

        System.out.println(solution(m, list));
    }
}
