package book;

import java.util.Arrays;
import java.util.EmptyStackException;

class IntStack{
    private int max;
    private int pointer;
    private int[] stack;

    public class EmptyIntStackException extends RuntimeException{}

    public class OverflowIntStackException extends RuntimeException{}

    public IntStack(int capacity){
        pointer = 0;
        max = capacity;
        try{
            stack = new int[max];
        } catch (OutOfMemoryError e){
            max = 0;
        }
    }

    public void push(int n) throws OverflowIntStackException{
        if(pointer >= max) throw new OverflowIntStackException();
        stack[pointer++] = n;
    }

    public int pop(){
        if(pointer < 0) throw new EmptyStackException();
        return stack[--pointer];
    }

    public int peek(){
        if(pointer <= 0) throw new EmptyStackException();
        return stack[pointer - 1];
    }

    public int indexOf(int n){
        for(int i = 0 ; i < stack.length ; i++){
            if(stack[i] == n) return i;
        }
        return -1;
    }

    public void clear(){
        pointer = 0;
    }

    public int capacity(){
        return max;
    }

    public int size(){
        return pointer;
    }

    public boolean isEmpty(){
        return pointer<= 0;
    }

    public boolean isFull(){
        return pointer>= max;
    }

    public void dump(){
        if(pointer <= 0) System.out.println("stack is empty");
        else {
            for(int i = 0 ; i < pointer ; i++){
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }

    public int[] getStack() {
        return stack;
    }
}

public class P136_Stack {
    public static void main(String[] args) {
        IntStack stack = new IntStack(10);
        stack.dump();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.dump();
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.indexOf(1) = " + stack.indexOf(1));
        

    }
}
