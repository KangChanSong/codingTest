package Inflearn.StackAndQueue;

import java.util.Stack;

public class Q1Stack_시도 {

    private static boolean solution(String s){
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < chars.length ; i++){
            stack.push(chars[i]);
        }

        for(int i = 0 ; i < chars.length ; i++){
            System.out.println(stack.pop());
        }
        return false;
    }

    public static void main(String[] args) {
        solution("abcdefg");
    }
}
