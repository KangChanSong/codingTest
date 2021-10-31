package engineerKorea;

import java.util.EmptyStackException;

public class StackImpl {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
    }
}
class Stack<T>{
    class Node<T>{
        private T data;
        private Node<T> next;
        public Node(T data){
            this.data = data;
        }
    }

    Node<T> top;
    public T pop(){
        if(top == null) throw new EmptyStackException();
        T data = top.data;
        top = top.next;
        return data;
    }

    public void push(T data){
        Node<T> node = new Node<>(data);
        if(top == null) top = node;
        else {
            node.next = top;
            top = node;
        }
    }

    public boolean isEmpty(){
        return top == null;
    }
}