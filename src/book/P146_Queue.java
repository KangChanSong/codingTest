package book;

import java.util.Arrays;

class IntArrQueue{
    int max;
    int pointer;
    int[] queue;

    public IntArrQueue(int capacity){
        this.pointer = 0;
        this.max = capacity;
        this.queue = new int[max];
    }

    public void enqueue(int n){
        queue[pointer++] = n;
    }

    public int dequeue(){
        int n = queue[0];
        for(int i = 1 ; i < max ; i++){
            queue[i-1] = queue[i];
        }
        pointer--;
        return n;
    }

    @Override
    public String toString() {
        return "IntArrQueue{" +
                "queue=" + Arrays.toString(queue) +
                '}';
    }
}
public class P146_Queue {
    public static void main(String[] args) {
        IntArrQueue queue = new IntArrQueue(10);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue);
        System.out.println("queue.dequeue() = " + queue.dequeue());
        System.out.println(queue);
        System.out.println("queue.dequeue() = " + queue.dequeue());
        System.out.println(queue);
        System.out.println("queue.dequeue() = " + queue.dequeue());
        System.out.println(queue);

    }
}
