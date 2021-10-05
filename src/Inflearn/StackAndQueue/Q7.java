package Inflearn.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q7 {

    private static Queue<String> convert(String str){
        Queue<String> queue = new LinkedList<>();
        for(char c : str.toCharArray()){
            queue.add(String.valueOf(c));
        }
        return queue;
    }

    private static String solution(String essentials, String lessons){
        String res = "YES";
        Queue<String> essQ = convert(essentials);
        Queue<String> lessQ = convert(lessons);

        while (!essQ.isEmpty()){
            if(!lessQ.isEmpty()) {
                String polled = lessQ.poll();
                if (essentials.contains(polled)) {
                    String polledFromEss = essQ.poll();
                    if (!polledFromEss.equals(polled)) return "NO";
                }
            } else {
                return "NO";
            }
        }


        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ess = scanner.next();
        String less = scanner.next();
        System.out.println(solution(ess, less));
    }
}
