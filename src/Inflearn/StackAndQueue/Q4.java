package Inflearn.StackAndQueue;

import java.util.*;

public class Q4 {

    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";

    private static int solution(String s){
        // 1. 숫자 발견 시 스택에 push
        // 2. 수식 발견 시 앞 두 숫자 pop 후 연산 후 push
        Stack<String> stack = new Stack<>();
        for(Character c : s.toCharArray()){
            String str = c.toString();

            if(str.equals(PLUS) || str.equals(MINUS) || str.equals(MULTIPLY) || str.equals(DIVIDE)){
                int y = Integer.valueOf(stack.pop());
                int x = Integer.valueOf(stack.pop());
                int res = 0;
                switch (str){
                    case PLUS:
                        res = x + y;
                        break;
                    case MINUS:
                        res = x - y;
                        break;
                    case MULTIPLY:
                        res = x * y;
                        break;
                    case DIVIDE:
                        res = x / y;
                        break;
                }
                stack.push(res + "");

            } else {
                stack.push(str);
            }
        }

        return Integer.valueOf(stack.pop());
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(solution(s));
    }
}
