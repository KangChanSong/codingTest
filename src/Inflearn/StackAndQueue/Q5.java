package Inflearn.StackAndQueue;

import java.util.Scanner;

public class Q5 {

    private static final char OPEN = '(';
    private static final char CLOSE = ')';

    private static int solution(String s){

        char[] chars = s.toCharArray();
        int height = 0;
        int count = 0;

        for (int i = 0 ; i < chars.length -1 ; i++) {

            // 현재 쇠막대기가 겹친 높이를 구한다.
            // 증가 or 감소

            // 레이저 감지
            if (chars[i] == OPEN && chars[i + 1] == CLOSE) {
                count += height;
            } else {
                if (chars[i] == OPEN) height++;
            }

            // 끊김 감지
            if(chars[i] == CLOSE && chars[i-1] != OPEN && height != 0){
                count++;
                height--;
            }

            // 마지막 감지
            if(i == chars.length-2){
                count += height;
            }

        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(solution(s));
    }
}
