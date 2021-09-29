package Inflearn.StackAndQueue;

import java.util.Scanner;

public class Q1오답 {

    private static final char LEFT = '(';
    private static final char RIGHT = ')';

    private static boolean solution(String s){
        char[] chars = s.toCharArray();
        if(chars[0] == RIGHT) return false;

        int leftCnt = 0;
        int rightCnt = 0;
        for(int i=0 ; i<chars.length ; i++){
            // 같은 기호의 연속을 카운트.
            if(chars[i] == RIGHT) rightCnt++;
            if(chars[i] == LEFT) leftCnt++;

            if(i == chars.length - 1){
                if(leftCnt == rightCnt) return true;
                else return false;
            }

            if(chars[i] == RIGHT && chars[i + 1] == LEFT){
                if(leftCnt != rightCnt){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(solution(s) ? "YES" : "NO");
    }
}
