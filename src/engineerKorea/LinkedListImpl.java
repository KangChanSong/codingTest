package engineerKorea;

import org.w3c.dom.Node;

import java.util.LinkedList;

public class LinkedListImpl {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        System.out.println(list.toString());
        System.out.println("list.get(3) = " + list.get(3));

    }
}

class MyLinkedList{
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    Node root;
    Node current;

    public void add(int data){
        if(root == null) {
            root = new Node(data);
            current = root;
        } else {
            current.next = new Node(data);
            current = current.next;
        }
    }

    public int get(int index){
        if(index == 0) return root.data;

        Node temp = root.next;
        for(int i = 1 ; i < index ; i++){
            if(temp == null) return -1;
            temp = temp.next;
        }

        return temp.data;
    }

    @Override
    public String toString() {
        Node node = root;
        StringBuilder builder = new StringBuilder();
        builder.append("[ ");
        while (node != null){
            builder.append(node.data+" ");
            node = node.next;
        }
        builder.append("]");
        return builder.toString();
    }
}
