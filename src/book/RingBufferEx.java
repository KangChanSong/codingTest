package book;

import java.util.Arrays;

class RingBufferQueue{
    private int max;
    private int front;
    private int rear;
    private int num;
    private int[] queue;

    public RingBufferQueue(int capacity){
        num = front = rear = 0;
        max = capacity;
        queue = new int[max];
    }

    public int enque(int x){
        queue[rear++] = x; // 현재 rear 에 값을 저장하고 rear을 증가시킨다.
        num++; // 큐에 들어있는 데이터 수를 증가시킨다.
        if(rear == max) rear = 0; // rear 가 max를 넘어서면 다시 0으로 초기화 (링 버퍼)
        return x;
    }

    public int deque(){
        int x = queue[front++];
        num--;
        if(front == max) front = 0;
        return x;
    }

    public int peek(){
        return queue[front];
    }

    public int indexOf(int x){
        for(int i = 0 ; i < num ; i++){
            int idx = (i+front) % max; // ex) 13 % 11 = 2
            if(queue[idx] == x){
                return idx;
            }
        }
        return -1;
    }

    public void clear(){
        num = front = rear = 0;
    }

    public int capacity(){
        return max;
    }

    public int size(){
        return num;
    }

    public boolean isEmpty(){
        return num <= 0;
    }

    public boolean isFull(){
        return num >= max;
    }

    public void dump(){
        if(num <= 0) System.out.println("큐가 비어있습니다.");
        else{
            for(int i = 0 ; i < num ; i++){
                System.out.println(queue[(i+front) % max] + " ");
            }
            System.out.println();
        }
    }

    public int search(int x){
        int count = 0;
        int index = front;
        while (true){
            if(count == max){
                return 0;
            }
            if(queue[index] == x){
                return count;
            }
            index++; count++;
            if(index == max) index = 0;
        }
    }
}

public class RingBufferEx {
    public static void main(String[] args) {
        RingBufferQueue queue = new RingBufferQueue(10);
        queue.dump();
        for(int i = 0 ; i < 15 ; i++){
            queue.enque(i);
        }
        System.out.println("queue.search(4) = " + queue.search(4));
        System.out.println("queue.search(5) = " + queue.search(5));
        System.out.println("queue.search(6) = " + queue.search(6));
        System.out.println("queue.search(7) = " + queue.search(7));
    }
}
