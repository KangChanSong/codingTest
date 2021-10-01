package Inflearn.StackAndQueue;

import java.util.Stack;

public class StackListTest {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.pop();
        System.out.println(stack);

        Stack<Integer> stack1 = stack;
        stack1.pop();
        System.out.println(stack1);
    }
}
