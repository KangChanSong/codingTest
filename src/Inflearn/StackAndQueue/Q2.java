package Inflearn.StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class Q2 {

    public static final char CLOSE = '(';
    public static final char OPEN = ')';

private static Stack<Character> convertToStack(String s){
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(int i = 0 ; i < chars.length ; i++){
            stack.push(chars[i]);
        }
        return stack;
    }

    private static String solution(String s){

        Stack<Character> stack = convertToStack(s);
        StringBuilder res = new StringBuilder();
        int x = 0;
        for(int i = 0 ; i < s.length() ; i++){
            Character pop = stack.pop();
            // 괄호의 열림 감지
            if(pop == OPEN) {
                x++;
            }
            // 다음 괄호가 열리기 전까지 문자 추가
            if(x == 0) {
                res.append(pop);
            }

            // 괄호의 닫힘 감지
            if(pop == CLOSE){
                x--;
            }
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(solution(s));
    }
}
