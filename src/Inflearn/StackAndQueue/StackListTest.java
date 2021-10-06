package Inflearn.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackListTest {

    private static void test1(){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        stack.pop();
        System.out.println(stack);

        Stack<Integer> stack1 = stack;
        stack1.pop();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
    }
}
